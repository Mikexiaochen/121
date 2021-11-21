package com.xc.service;

import com.xc.pojo.Spu;

import java.util.List;

public interface SpuService {
    /**
     * 根据分类的id获取商品列表
     * @param cate_id
     * @return
     */
    List<Spu> getspulist(Integer cate_id);
}
