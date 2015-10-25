package com.saick.base.dao.entiy;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

/**
 * 接受多个User对象list集合的包装类
 * 
 * @author Liubao
 * @Version 1.0
 */
public class UserList {
    private List<User> userList = new ArrayList<User>();

    /**
     * 当对象中的属性,有地址存在的话,就是指定递归验证关联的对象；
     * 如用户对象中有个地址对象属性，如果想在验证用户对象时一起验证地址对象的话，在地址对象上加@Valid注解即可级联验证
     */
    @Valid
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
