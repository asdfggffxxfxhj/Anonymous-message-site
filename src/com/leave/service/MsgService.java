package com.leave.service;

import com.leave.bean.Msg;

import java.util.List;

public interface MsgService {
    //查看所有的留言信息
    List<Msg> findAllMsg() throws Exception;
    //查看留言信息
    List<Msg> findMsg(String msg_name) throws Exception;
    //增加留言
    void addMsg(Msg msg) throws Exception;
}
