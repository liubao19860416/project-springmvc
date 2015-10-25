package com.saick.base.service.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.saick.base.dao.entiy.User;
import com.saick.base.dao.entiy.UserList;

/**
 * service接口
 * 
 * @author Liubao
 * @2014年12月19日
 * 
 */
public interface IUserService {

    public abstract List<User> findUserList();

    public abstract User findUserById(Long id);

    public abstract void saveUser(User user);

    public abstract void updateUser(User user);

    public abstract void deleteUserById(Long id);

    public abstract void deleteUserByIds(Long[] ids);

    public abstract List<User> findUserByConditions(User user);

    public abstract List<User> findUserByNameLike(User user);

    public abstract void saveUserMany(UserList userList);
    
    // 多数据库环境,测试输出当前时间
    public Date getDateNow();
    
    // 多数据库环境,测试输出当前时间
    public Timestamp getTimestampNow();

}
