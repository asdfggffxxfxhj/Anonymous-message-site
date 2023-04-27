package com.leave.dao;
import com.leave.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 持久层代码，对数据库进行操作
 * @param <T>
 */
public class BaseDao<T>{
    private QueryRunner queryRunner=new QueryRunner();
    //执行增删改的代码
    public int update(String sql,Object...params){
        try {
            //返回受到影响的行数
            return queryRunner.update(JDBCUtil.getConnection(),sql,params);
        } catch (SQLException e) {
                e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    //执行查询一行数据的sql语句，将结果封装到javabea对象中
    public T getBean(Class<T> clazz,String sql,Object...params){
        try {
            return queryRunner.query(JDBCUtil.getConnection(),sql,new BeanHandler<>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    //执行查询多行数据的sql语句，将数据结果封装在BeanListHandler中
    public List<T> getBeanList(Class<T> clazz,String sql,Object...params){
        try {
            return queryRunner.query(JDBCUtil.getConnection(),sql,new BeanListHandler<>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
