package com.leave.dao.impl;

import com.leave.bean.Msg;
import com.leave.dao.BaseDao;
import com.leave.dao.msgDao;

import java.sql.SQLException;
import java.util.List;

public class msgDaoImpl extends BaseDao<Msg> implements msgDao {
    //查找留言信息
    @Override
    public List<Msg> findMsg(String msg_name) throws SQLException {
        String sql="select msg_id,msg_name,msg_content,msg_time from msg where msg_name=?";
        return getBeanList(Msg.class,sql,msg_name);
    }
    //添加留言
    @Override
    public void addMsg(Msg msg) throws SQLException {
        String sql="insert into msg (msg_name,msg_content,msg_time) values (?,?,?) ";
        update(sql,msg.getMsg_name(),msg.getMsg_content(),msg.getMsg_time());
    }
    //查看所有留言信息
    @Override
    public List<Msg> findAllMsg() throws SQLException {
        String sql="select msg_id,msg_name,msg_content,msg_time from msg";
        return getBeanList(Msg.class,sql);
    }
}
