package com.xc.controller;

import com.xc.pojo.Spu;
import com.xc.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/spu")
@RestController
public class SpuController {

    @Autowired
    private SpuService spuService;

    @GetMapping("/list/{cate_id}")
    public List<Spu> list(@PathVariable("cate_id") Integer cate_id){
        return spuService.getlist(cate_id);
    }




}
