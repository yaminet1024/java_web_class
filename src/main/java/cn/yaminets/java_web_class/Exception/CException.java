package cn.yaminets.java_web_class.Exception;

import cn.yaminets.java_web_class.enums.CodeMessage;

public class CException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private CodeMessage codeMessage;

    public CException(CodeMessage codeMessage){
        super();
        this.codeMessage = codeMessage;
    }

    public CodeMessage getCodeMessage() {
        return codeMessage;
    }
}
