package com.leave.bean;


public class Msg {
    private Integer msg_id;
    private String msg_name;
    private String msg_content;
    private String msg_time;

    public Msg(Integer msg_id, String msg_name, String msg_content, String msg_time) {
        this.msg_id = msg_id;
        this.msg_name = msg_name;
        this.msg_content = msg_content;
        this.msg_time = msg_time;
    }

    public Msg() {
    }

    public Integer getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(Integer msg_id) {
        this.msg_id = msg_id;
    }

    public String getMsg_name() {
        return msg_name;
    }

    public void setMsg_name(String msg_name) {
        this.msg_name = msg_name;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }

    public String getMsg_time() {
        return msg_time;
    }

    public void setMsg_time(String msg_time) {
        this.msg_time = msg_time;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg_id=" + msg_id +
                ", msg_name='" + msg_name + '\'' +
                ", msg_content='" + msg_content + '\'' +
                ", msg_time=" + msg_time +
                '}';
    }
}
