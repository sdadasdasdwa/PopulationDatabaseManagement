package com.dongruan.population.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongruan.population.entity.Idcard;
import com.dongruan.population.entity.Person;
import com.dongruan.population.service.IdcardService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

@Controller
public class IDCardController {

    @Autowired
    private IdcardService idcardService;

    @RequestMapping("/query_idcard")
    @ResponseBody
    public List queryIdCard(@RequestBody Idcard idcard){
        return idcardService.queryIdCard(idcard);
    }

    @RequestMapping("/queryByConditions")
    @ResponseBody
    public PageInfo queryByConditions(String param){
        JSONObject jsonObject = JSONObject.parseObject(param);
        Integer PageNo = (Integer) jsonObject.get("pageNo");
        Integer PageSize = (Integer) jsonObject.get("pageSize");
//        System.out.println("pageNo: "+PageNo);
//        System.out.println("pageSize: "+PageSize);
        Idcard conditions = jsonObject.toJavaObject(Idcard.class);
//        System.out.println("condition= "+conditions);
        Page<Idcard> page = PageHelper.startPage(PageNo,PageSize);
        List list = idcardService.selectIDcard(conditions);
        PageInfo<Idcard> pageInfo = new PageInfo(list, PageSize);
        return pageInfo;
    }

    @RequestMapping("/insertIDCard")
    @ResponseBody
    public boolean insertIDCard(@RequestBody Idcard idcard){
        System.out.println("insertIDCard");
        return idcardService.insertIDCard(idcard);
    }

    @RequestMapping("/deleteIDCard")
    @ResponseBody
    public Boolean deleteIDCard(Integer id){
        return idcardService.deleteIDCard(id);
    }

    @RequestMapping("/updateIDcard")
    @ResponseBody
    public boolean updateIDcard(@RequestBody Idcard idcard){
        return idcardService.updateIDcard(idcard);
    }





}
