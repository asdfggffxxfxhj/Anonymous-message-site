package com.leave.service.impl;

import com.leave.bean.Msg;
import com.leave.dao.impl.msgDaoImpl;
import com.leave.service.MsgService;
import com.leave.dao.msgDao;
import java.util.List;

public class MsgServiceImpl implements MsgService {
    private msgDao msgdao=new msgDaoImpl();
    @Override
    public List<Msg> findAllMsg() throws Exception {
        return msgdao.findAllMsg();
    }

    @Override
    public List<Msg> findMsg(String msg_name) throws Exception {
        return msgdao.findMsg(msg_name);
    }

    @Override
    public void addMsg(Msg msg) throws Exception {
        msgdao.addMsg(msg);
    }
}
