package com.saick.base.dao.entiy;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 对User对象的校验,是通过注解完成的
 * 
 * Date类型数据如何进行校验

 * @author Liubao
 * @Version 1.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = -3379175634334411627L;
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String email;

    private Date birthday;

    // @DateTimeFormat(pattern = DateTimeFormat.ISO.DATE)
    // @NotEmpty
    public Date getBirthday() {
        return birthday;

    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    // 必须提供无参的构造方法
    public User() {
    }

    public User(String username, String password, String nickname, String email) {
        super();
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public User(Long id, String username, String password, String nickname,
            String email) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    @NotEmpty(message = "用户名不能为空!")
    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(max = 10, min = 3, message = "密码长度需要在3-10位之间")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "昵称不能为空!")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Email(message = "邮箱地址并不正确")
    @NotEmpty(message = "邮箱地址不能为空!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", nickname=" + nickname + ", email=" + email
                + ", birthday=" + birthday + "]";
    }

}
