package com.xc.pojo;

import java.util.Date;

public class SpuAttrValue {
    private Long id;
    private String value_name;
    private Date createtime;
    private Date updatetime;
    private String value_attr_key_id;

    private SpuAttrValueSpus spuAttrValueSpus;

    public SpuAttrValueSpus getSpuAttrValueSpus() {
        return spuAttrValueSpus;
    }

    public void setSpuAttrValueSpus(SpuAttrValueSpus spuAttrValueSpus) {
        this.spuAttrValueSpus = spuAttrValueSpus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue_name() {
        return value_name;
    }

    public void setValue_name(String value_name) {
        this.value_name = value_name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getValue_attr_key_id() {
        return value_attr_key_id;
    }

    public void setValue_attr_key_id(String value_attr_key_id) {
        this.value_attr_key_id = value_attr_key_id;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"value_name\":\"" + value_name + '\"' +
                ", \"value_attr_key_id\":\"" + value_attr_key_id + '\"' +
                '}';
    }
}
