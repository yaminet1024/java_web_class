package cn.yaminets.java_web_class.enums;

public enum  CodeMessage {

    SUCCESS(100,"成功"),
    LOGIN_USER_NAME_ERROR(101,"账号错误"),
    LOGIN_PASSWORD_ERROR(102,"密码错误"),
    RESGISTER_USER_EXIST(103,"账号已经存在"),
    NOT_USER_LOGIN(104,"用户未登录"),
    ORDER_NOT_EXIT(105,"没有订单信息"),
    EMPTY_DATA(106,"数据空"),
    CREATE_ORDER_FAIL(107,"创建订单失败");

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
