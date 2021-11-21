package com.xc.service;

import com.xc.pojo.Spu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "spu-provider")
public interface SpuService {
    @GetMapping("/spu/list/{cate_id}")
    public List<Spu> getlist(@PathVariable("cate_id") Integer cate_id);
}
