package com.saick.base.dao.mapper;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.saick.base.dao.MapperUtils;
import com.saick.base.dao.entiy.User;

/**
 * 一些基本的增删改查的方法测试，还有一些注意事项
 * 
 * @author Liubao
 * @2014年12月16日
 * 
 */
public class UserMapperTest {

    /**
     * 多数据库环境,测试输出当前时间
     */
    @Test
    @SuppressWarnings("deprecation")
    public void TestGetnow() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 操作数据库
        Date date = userMapper.getDateNow();
        System.out.println(date.toLocaleString());
        
        Timestamp timestamp = userMapper.getTimestampNow();
        System.out.println(timestamp.toLocaleString());
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    @Test
    public void testFindUserById() {
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获限mapper接口实例
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 构造查询条件user对象
        User user = userMapper.findUserById(16);
        System.out.println(user);
    }

    // 测试查询用户信息,根据id
    @Test
    public void testFindUserById_2() {
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获限mapper接口实例
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 构造查询条件user对象
        User user = userMapper.findUserById(16);
        // 释放资源
        sqlSession.close();
        System.out.println(user);
    }

    /**
     * 插入一条user信息
     * 
     */
    @Test
    public void testInsertUser() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        User user = new User();
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-03-06"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setUsername("wangli");
        // 操作数据库
        userMapper.insertUser(user);
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    /**
     * oracle数据库操作插入数据
     */
    @Test
    public void testInsertUser_oracle() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        User user = new User();
        // 操作数据库
        userMapper.insertUser(user);
        System.out.println(user);// 查看empno是否已经进行了查询获取
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    /**
     * update方法测试
     */
    @Test
    public void testUpdateUser() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        User user = new User();
        user.setId(20l);
        try {
            user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse("1990-02-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setUsername("wangli02");
        // 操作数据库
        userMapper.updateUserById(user);
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    /**
     * 根据id删除用户
     */
    @Test
    public void testDeleteUserById() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        // 操作数据库
        userMapper.deleteUserById(20);
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    /**
     * 查找所有用户信息
     */
    @Test
    public void testFindAllUsers() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        // 操作数据库
        List<User> users = userMapper.findAllUsers();
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    /**
     * 查找所有用户信息,返回一个map
     */
    @Test
    public void TestFindAllUsersResultMap() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        // 操作数据库
        List<Map<String, User>> users = userMapper.findAllUsersResultMap();
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    /**
     * 查找所有用户信息,返回一个map
     */
    @Test
    public void TestFindAllUsersResultMap_Person() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        // 操作数据库
        // List<User> list = userMapper.findAllUsersResultMap_Person();
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    /**
     * 根据姓名进行模糊查询
     */
    @Test
    public void TestFindUsersByNameLike() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        // 操作数据库
        User user = new User();
        user.setUsername("王");
        List<User> list = userMapper.findUsersByNameLike(user.getUsername());
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    // 方式二
    @Test
    public void TestFindUsersByNameLike2() {
        // 获取连接
        SqlSession sqlSession = MapperUtils.getSqlSession();
        // 获取Mapper接口对象
        UserMapper userMapper = this.getMapper(sqlSession, UserMapper.class);
        // 准备数据
        // 操作数据库
        User user = new User();
        user.setUsername("王");
        List<User> list = userMapper.findUsersByNameLike2(user);
        // 需要手动提交事务(mysql不是自动提交事务的吗?为什么还需要手动提交,因为这里的操作数据库的事务,已经交给了mybatis来管理了)
        sqlSession.commit();
        // 释放资源
        MapperUtils.releaseResources(sqlSession);
    }

    // 封装获取对应的Mapper接口对象的方法(没有必要)
    private <T> T getMapper(SqlSession sqlSession, Class<T> clazz) {
        return sqlSession.getMapper(clazz);
    }

}
