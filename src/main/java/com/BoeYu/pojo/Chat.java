package com.BoeYu.pojo;

import java.util.Date;

public class Chat {
    private Integer id;

    private String sendId;

    private String toId;

    private String chatMsg;

    private String chattype;

    private Date createTime;

    private String isread;

    private String tflag;

    public String getTflag() {
        return tflag;
    }

    public void setTflag(String tflag) {
        this.tflag = tflag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId == null ? null : sendId.trim();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public String getChatMsg() {
        return chatMsg;
    }

    public void setChatMsg(String chatMsg) {
        this.chatMsg = chatMsg == null ? null : chatMsg.trim();
    }

    public String getChattype() {
        return chattype;
    }

    public void setChattype(String chattype) {
        this.chattype = chattype == null ? null : chattype.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsread() {
        return isread;
    }

    public void setIsread(String isread) {
        this.isread = isread == null ? null : isread.trim();
    }
}