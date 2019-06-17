package cn.yaminets.java_web_class.enums;

public enum  CodeMessage {

    SUCCESS(100,"成功"),
    LOGIN_USER_NAME_ERROR(101,"账号错误"),
    LOGIN_PASSWORD_ERROR(102,"密码错误"),
    RESGISTER_USER_EXIST(103,"账号已经存在");

    private int resultCode;
    private String resultMessage;

    CodeMessage(int resultCode,String resultMessage){
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
