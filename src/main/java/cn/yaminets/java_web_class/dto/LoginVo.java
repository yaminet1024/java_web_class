package cn.yaminets.java_web_class.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class LoginVo {

    @NotNull
    private String mobile;

    @NotNull
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
