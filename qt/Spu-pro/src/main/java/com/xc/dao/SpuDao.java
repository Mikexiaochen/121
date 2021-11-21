package com.xc.dao;

import com.xc.pojo.Spu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpuDao {
    /**
     * 根据分类的id获取spu列表
     * @param cate_id 分类的id
     * @return
     */
    List<Spu> findspuList(@Param("cate_id") Integer cate_id);
}
