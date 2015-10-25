package com.saick.base.dao.mapper;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.saick.base.dao.entiy.User;

public interface UserMapper {

    // 根据id查找用户信息
    // @Select(value="select * from itcast_user where id = #{id}")
    public User findUserById(Integer id);

    // 插入一条数据
    public void insertUser(User user);
    
    // 插入一条数据
    public void insertUser2(User user);

    // 更新user对象
    public void updateUserById(User user);

    // 删除对象
    public void deleteUserById(Integer id);

    // 查找所有用户信息
    public List<User> findAllUsers();

    // 查找所有用户信息(返回一个list的map集合)
    public List<Map<String, User>> findAllUsersResultMap();

    // 查找所有用户信息(返回一个list的map集合)
    // public List<Person> findAllUsersResultMap_Person();

    // 根据姓名,进行模糊查询(返回结果是一个list)
    public List<User> findUsersByNameLike(String username);

    public List<User> findUsersByNameLike2(User user);

    // 多数据库环境,测试输出当前时间
    public Date getDateNow();
    
    // 多数据库环境,测试输出当前时间
    public Timestamp getTimestampNow();

}
