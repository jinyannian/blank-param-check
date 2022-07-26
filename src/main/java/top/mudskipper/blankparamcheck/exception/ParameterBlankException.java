package top.mudskipper.blankparamcheck.exception;

import org.apache.commons.lang3.StringUtils;

public class ParameterBlankException extends RuntimeException {
    private static final String MSG_FMT = "Parameter(s) %s can not be blank.";
    public ParameterBlankException(String paramname) {
        super(String.format(MSG_FMT, paramname));
    }
    public ParameterBlankException(String[] paramnames) {
        super(String.format(MSG_FMT, StringUtils.join(paramnames, ", ")));
    }
}
