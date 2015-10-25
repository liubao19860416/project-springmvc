package com.saick.base.dao.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.saick.base.dao.api.IUserDAO;
import com.saick.base.dao.entiy.User;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Resource
    private SqlSessionFactory sqlSessionFactory;

     //private IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,
     //IUserDAO.class);

    /**
     * 封装获取对应的Mapper接口对象的方法
     */
    private <T> T getUserDAOMapper(SqlSessionFactory sqlSessionFactory,
            Class<T> clazz) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(clazz);
    }

    /**
     * 通过直接调用sql映射路径的方式执行sql语句
     */
    public User findUserById(int id) throws Exception {
        //会话
         User user=null;
        try {
            //使用sqlSession操作数据库
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //selectOne的第一个参数：指定sql的id(statement 的id),第二个参数：向sql中传的参数值
            //user= (User)sqlSession.selectOne("com.saick.base.dao.api.IUserDAO.findUserById", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    /**
     * 查询所有用户列表
     */
    @Override
    public List<User> findList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDAO userDAOMapper = sqlSession.getMapper(IUserDAO.class);
        List<User> users = userDAOMapper.findList();
        return users;
    }

    /**
     * 根据id查询单个用户信息
     */
    @Override
    public User findById(Long id) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        // 一级缓存默认存在(查询缓存)
        // 打开二级缓存,设置为true,也可以在标签中打开
        // sqlSessionFactory.getConfiguration().setCacheEnabled(true);
        // User findById = userDAOMapper.findById(id);

        // 这里需要跨session才可以实现
        // userDAOMapper = this.getUserDAOMapper(sqlSessionFactory, IUserDAO.class);
        // User findById2 = userDAOMapper.findById(id);
        return userDAOMapper.findById(id);
    }

    /**
     * 保存新用户
     */
    @Override
    public void save(User user) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        // 打开二级缓存,设置为true,也可以在标签中打开
        // sqlSessionFactory.getConfiguration().setCacheEnabled(false);

        // 测试事务
        // userDAOMapper.save(user);
        // int i = 1 / 0;
        // user.setUsername(user.getUsername() + ":");
        // int i = sqlSessionFactory.openSession().delete(null);
        userDAOMapper.save(user);
    }

    /**
     * 更新用户信息
     */
    @Override
    public void update(User user) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        userDAOMapper.update(user);
    }

    /**
     * 根据id删除用户
     */
    @Override
    public void deleteById(Long id) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        userDAOMapper.deleteById(id);
    }

    /**
     * 根据ids数组,批量删除用户信息
     */
    @Override
    public void deleteByIds(Long[] ids) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        userDAOMapper.deleteByIds(ids);
    }

    /**
     * 根据用户多个不确定条件,进行模糊查询
     */
    @Override
    public List<User> findByConditions(User user) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        return userDAOMapper.findByConditions(user);
    }

    /**
     * 根据用户名字单个条件,进行模糊条件查询
     */
    @Override
    public List<User> findByNameLike(User user) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        return userDAOMapper.findByNameLike(user);
    }

    /**
     * 批量添加用户数据2:使用list实现saveUserBatch
     */
    @Override
    public void saveManyByList(List<User> userList) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        userDAOMapper.saveManyByList(userList);
        System.out.println("通过dao实现类批量插入数据" + userList);
    }

    /**
     * 批量添加用户数据1:使用map实现(暂时未实现)
     */
    @Override
    @Deprecated
    public void saveManyByMap(Map<String, List<User>> userMap) {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        System.out.println("通过dao实现类批量插入数据" + userMap);
        userDAOMapper.saveManyByMap(userMap);
    }

    @Override
    public Date getDateNow() {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        return userDAOMapper.getDateNow();
    }

    @Override
    public Timestamp getTimestampNow() {
        IUserDAO userDAOMapper = this.getUserDAOMapper(sqlSessionFactory,IUserDAO.class);
        return userDAOMapper.getTimestampNow();
    }

}
