package com.xc.service.imp;

import com.xc.dao.SpuDao;
import com.xc.pojo.Spu;
import com.xc.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private SpuDao spuDao;

    @Override
    public List<Spu> getspulist(Integer cate_id) {
        return spuDao.findspuList(cate_id);
    }
}
