package com.saick.base.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 这里可以读取加载不同的数据库配置信息
 * 
 * @author Liubao
 * @2014年12月19日
 * 
 */
public class MapperUtils {
    private static SqlSessionFactoryBuilder builder = null;
    private static SqlSessionFactory sqlSessionFactory = null;
    private static String config = "test/mybatis.cfg.xml";
    static {
        // 读取配置文件
        builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new InitialisationException("加载配置文件失败");
        }
        // sqlSessionFactory = builder.build(inputStream, "development_oracle");
        sqlSessionFactory = builder.build(inputStream, "development_mysql");

    }

    // 获取一个新的sqlSession对象的方法
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    // 释放资源
    public static void releaseResources(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
        }
        sqlSession = null;
    }
}
