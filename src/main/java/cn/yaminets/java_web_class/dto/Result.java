package cn.yaminets.java_web_class.dto;

import cn.yaminets.java_web_class.Exception.CException;
import cn.yaminets.java_web_class.enums.CodeMessage;
import com.alibaba.fastjson.JSON;

public class Result<T> {
    private int code;
    private String msg;
    private T data;

    private Result(T data){
        this.data = data;
        this.msg = CodeMessage.SUCCESS.getResultMessage();
        this.code = CodeMessage.SUCCESS.getResultCode();
    }

    private Result(CodeMessage message){
        this.code = message.getResultCode();
        this.msg = message.getResultMessage();
    }

    public T getData() {
        return data;
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static <T> Result<T> error(CodeMessage codeMessage){
        return new Result<T>(codeMessage);
    }

    public String toJson(){
        return JSON.toJSONString(this);
    }
}
