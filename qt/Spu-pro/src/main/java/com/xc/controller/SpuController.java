package com.xc.controller;

import com.xc.pojo.Spu;
import com.xc.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spu")
public class SpuController {

    @Autowired
    private SpuService spuService;


    @GetMapping("/list/{cate_id}")
    public List<Spu> getlist(@PathVariable("cate_id") Integer cate_id){
        return spuService.getspulist(cate_id);
    }
}
