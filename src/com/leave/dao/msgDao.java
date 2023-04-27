package com.leave.dao;

import com.leave.bean.Msg;

import java.sql.SQLException;
import java.util.List;

public interface msgDao {
    /**
     * 查询留言
     * @param msg_name
     * @return
     * @throws SQLException
     */
    List<Msg> findMsg(String msg_name) throws SQLException;

    /**
     * 添加留言
     * @param msg
     * @throws SQLException
     */
    void addMsg(Msg msg) throws SQLException;

    /**
     * 查看所有的留言信息
     * @return
     * @throws SQLException
     */
    List<Msg> findAllMsg() throws SQLException;
}
