package com.java.controller;

import com.java.service.ESRestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/es")
public class ESRestController {

    @Autowired
    private ESRestService service;

    @PostMapping("/add")
    @ApiOperation("增加数据")
    public String add() {
        return service.add();
    }

    @PostMapping("/update")
    @ApiOperation("修改数据")
    public String update() {
        return service.update();
    }

    @PostMapping("/insertBatch")
    @ApiOperation("批量增加数据")
    public String insertBatch() {
        return service.insertBatch();
    }

    @PostMapping("/deleteByQuery")
    @ApiOperation("根据条件删除")
    public void delete() {
        service.delete();
    }

    @PostMapping("/deleteById")
    @ApiOperation("根据id删除")
    public String deleteById() {
        return service.deleteById();
    }

    @PostMapping("/searchData")
    @ApiOperation("根据条件查询")
    public List searchData() {
        return service.searchData();
    }
}
