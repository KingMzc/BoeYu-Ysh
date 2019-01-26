package com.BoeYu.pojo;

import java.util.Date;

public class Discount {
    private Integer id;

    private String orderr;

    private String type;

    private String flag;

    private String distype;

    private Date createtime;

    private String endtime;

    private String orderid;

    private String export;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderr() {
        return orderr;
    }

    public void setOrderr(String orderr) {
        this.orderr = orderr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public String getDistype() {
        return distype;
    }

    public void setDistype(String distype) {
        this.distype = distype == null ? null : distype.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export == null ? null : export.trim();
    }
}