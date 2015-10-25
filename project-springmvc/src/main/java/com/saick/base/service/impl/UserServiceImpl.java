package com.saick.base.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saick.base.dao.api.IUserDAO;
import com.saick.base.dao.entiy.User;
import com.saick.base.dao.entiy.UserList;
import com.saick.base.service.api.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDAO userDAO;

    /**
     * 查询所有用户列表
     */
    @Override
    public List<User> findUserList() {
        return userDAO.findList();
    }

    /**
     * 根据id查询用户信息
     */
    @Override
    public User findUserById(Long id) {
        return userDAO.findById(id);
    }

    /**
     * 添加用户
     */
    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    /**
     * 更新用户信息
     */
    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }

    /**
     * 根据id删除用户
     */
    @Override
    public void deleteUserById(Long id) {
        userDAO.deleteById(id);
    }

    /**
     * 根据ids批量删除用户
     */
    @Override
    // @Transactional(readOnly = true)
    public void deleteUserByIds(Long[] ids) {
        userDAO.deleteByIds(ids);
    }

    /**
     * 根据用户信息,进行模糊条件查询
     */
    @Override
    public List<User> findUserByConditions(User user) {
        return userDAO.findByConditions(user);
    }

    /**
     * 根据用户名字单个条件,进行模糊条件查询
     */
    @Override
    public List<User> findUserByNameLike(User user) {
        return userDAO.findByNameLike(user);
    }

    /**
     * 批量添加用户的方法1(使用list存储对象的方式)
     */
    @Override
    public void saveUserMany(UserList userList) {
        // 这里将我们需要的List<Model>对象取出来
        userDAO.saveManyByList(userList.getUserList());
    }

    @Override
    public Date getDateNow() {
        return userDAO.getDateNow();
    }

    @Override
    public Timestamp getTimestampNow() {
        return userDAO.getTimestampNow();
    }
}
