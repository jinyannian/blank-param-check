package top.mudskipper.blankparamcheck.exception;

import org.apache.commons.lang3.StringUtils;

public class ParamsBlankException extends RuntimeException {
    private static final String MSG_FMT = "Parameter(s) %s can not be blank.";
    public ParamsBlankException(String paramname) {
        super(String.format(MSG_FMT, paramname));
    }
    public ParamsBlankException(String[] paramnames) {
        super(String.format(MSG_FMT, StringUtils.join(paramnames, ", ")));
    }
}
