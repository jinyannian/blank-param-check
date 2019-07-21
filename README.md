# blank-param-check
this project provides annotations used to check controller(beans whose name matches *Controller) request parameters

quick start
step 1:
import project "blank-param-check"

step 2:
put annotation @EnableBlankParameterCHeck on your spring boot starter application to enable this project

step 3:
put annotation @BlankParameterCheck on a controller or a method in a controller, the parameters of which will not pass if one of them equals to null, "", or "    "

step 4:
you can optionally put the annotation @Ignored to ignore methods or parameters that you do not want to check

step 5:'
you can optionally put the statement "blank.parameter.check.logger=false" in "application.properties" to disable the log output. the default value is "true" if you do not assign
