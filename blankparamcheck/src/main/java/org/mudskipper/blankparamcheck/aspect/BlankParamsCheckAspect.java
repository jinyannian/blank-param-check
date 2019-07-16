package org.mudskipper.blankparamcheck.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.mudskipper.blankparamcheck.annotation.BlankParamsCheck;
import org.mudskipper.blankparamcheck.annotation.BlankParamsCheckMethodExceptional;
import org.mudskipper.blankparamcheck.annotation.BlankParamsCheckParamExceptional;
import org.mudskipper.blankparamcheck.exception.ParamsBlankException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class BlankParamsCheckAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("bean(*Controller)")
    public void webLog(){}

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            request = attributes.getRequest();
		}
        if (request != null) {
            // 记录下请求内容
            logger.info("request class method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Method method = methodSignature.getMethod();
            BlankParamsCheck methodCheck = method.getAnnotation(BlankParamsCheck.class);
            BlankParamsCheckMethodExceptional methodExceptionalCheck = method.getAnnotation(BlankParamsCheckMethodExceptional.class);
            BlankParamsCheck classCheck = method.getDeclaringClass().getAnnotation(BlankParamsCheck.class);
            boolean methodCheckBoo = methodCheck == null ? false : methodCheck.name();
            boolean methodCheckExceptionalBoo = methodExceptionalCheck == null ? false : methodExceptionalCheck.name();
            boolean classCheckBoo = classCheck == null ? false : classCheck.name();
            boolean check = (methodCheckBoo || classCheckBoo) && !methodCheckExceptionalBoo ? true : false;
            logger.info("check params ? = {}", check);
            if (check) {
                Map<String, String[]> parameterMap = request.getParameterMap();
                String[] parameterNames = methodSignature.getParameterNames();
                List<String> nocheckParameterNameList = new ArrayList<>();
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                for (int i = 0; i < parameterAnnotations.length; i++) {
                    Annotation[] annotations = parameterAnnotations[i];
                    for (Annotation annotation : annotations) {
                        if (annotation.annotationType().equals(BlankParamsCheckParamExceptional.class)) {
                            nocheckParameterNameList.add(parameterNames[i]);
                        }
                    }
                }
                logger.info("list of method params = {}", parameterNames == null ? null : Arrays.asList(parameterNames));
                logger.info("list of ignored mehtod params = {}", nocheckParameterNameList);
                for (String paramName : parameterNames) {
                    if (!nocheckParameterNameList.contains(paramName)) {
                        String[] strs = parameterMap.get(paramName);
                        if (strs == null || strs.length == 0 || StringUtils.isBlank(strs[0])) {
                            throw new ParamsBlankException(paramName);
                        }
                    }
                }
            }
        }
    }
}
