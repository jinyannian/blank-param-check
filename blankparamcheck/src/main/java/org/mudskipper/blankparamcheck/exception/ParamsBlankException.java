package org.mudskipper.blankparamcheck.exception;

public class ParamsBlankException extends RuntimeException {
    private static final String MSG_FMT = "The parameter %s can not be blank.";
    public ParamsBlankException(String paramname) {
        super(String.format(MSG_FMT, paramname));
    }
}
