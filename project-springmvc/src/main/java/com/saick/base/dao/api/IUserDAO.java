package com.saick.base.dao.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.saick.base.dao.entiy.User;

/**
 * 方式1:如下+类名.xml+扫描(3种方式)
 * 
 * 方式二:参见注解@Select(value="select * from itcast_user where id = #{id}")
 * 
 * @author Liubao
 * @Version 1.0
 * 
 */
public interface IUserDAO {

    // 查询所有用户列表
    public List<User> findList();

    // 根据id查询单个用户信息
    // @Select(value="select * from itcast_user where id = #{id}")
    public User findById(Long id);

    // 保存新用户
    public void save(User user);

    // 更新用户信息
    public void update(User user);

    // 根据id删除用户信息
    public void deleteById(Long id);

    // 根据ids数组,批量删除用户
    public void deleteByIds(Long[] ids);

    // 根据用户中的属性,如姓名等多个不确定条件,进行模糊查询
    public List<User> findByConditions(User user);

    // 根据用户姓名单个条件,进行模糊查询
    public List<User> findByNameLike(User user);

    // 批量插入数据的操作1:map实现(属于方法的重载)
    public void saveManyByMap(Map<String, List<User>> userMap);

    // 批量插入数据的操作2:map实现(属于方法的重载)
    public void saveManyByList(List<User> userList);
    
    // 多数据库环境,测试输出当前时间
    public Date getDateNow();
    
    // 多数据库环境,测试输出当前时间
    public Timestamp getTimestampNow();

}
