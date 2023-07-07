package com.dongruan.population.controller;

import com.alibaba.fastjson.JSONObject;
import com.dongruan.population.entity.Idcard;
import com.dongruan.population.entity.MovingOut;
import com.dongruan.population.service.MovingOutService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MoveOutController {

    @Autowired
    private MovingOutService movingOutService;

    @RequestMapping("/queryMoveOut")
    @ResponseBody
    public PageInfo queryByConditions(String param){
        JSONObject jsonObject = JSONObject.parseObject(param);
        Integer PageNo = (Integer) jsonObject.get("pageNo");
        Integer PageSize = (Integer) jsonObject.get("pageSize");
//        System.out.println("pageNo: "+PageNo);
//        System.out.println("pageSize: "+PageSize);
        MovingOut conditions = jsonObject.toJavaObject(MovingOut.class);
//        System.out.println("condition= "+conditions);
        Page<Idcard> page = PageHelper.startPage(PageNo,PageSize);
        List list = movingOutService.selectMoveOut(conditions);
        PageInfo<Idcard> pageInfo = new PageInfo(list, PageSize);
        return pageInfo;
    }

    @RequestMapping("/deleteMoveOut")
    @ResponseBody
    public boolean deleteMoveOut( Integer id){
        return movingOutService.deleteMoveOut(id);
    }

    @RequestMapping("/updateMoveOut")
    @ResponseBody
    public boolean updateMoveOut(@RequestBody MovingOut movingOut){
        return movingOutService.updateMovingOut(movingOut);
    }
}
