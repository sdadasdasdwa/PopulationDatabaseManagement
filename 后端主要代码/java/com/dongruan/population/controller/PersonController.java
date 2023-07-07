package com.dongruan.population.controller;

import com.dongruan.population.entity.Person;
import com.dongruan.population.service.PersonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping("/all_person")
    @ResponseBody
    public List allPerson(){
        return personService.selectAll();
    }

    //条件查询
    @RequestMapping("/getByCondition")
    @ResponseBody
    public List getByConditions(@RequestBody Person person){
//        System.out.println(person.getName());
//        System.out.println(person.getIdentifyCode());
        return personService.getByConditions(person);
    }

    //增加
    @RequestMapping("/add")
    @ResponseBody
    public boolean addPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    //根据据id更新数据
    @RequestMapping("/update")
    @ResponseBody
    public boolean updatePerson(@RequestBody Person person){
        return personService.updatePerson(person);
    }

    //根据条件查询
    @RequestMapping("/updateByConditions")
    @ResponseBody
    public boolean updateByConditions(){
        Map conditions = new HashMap<String, Object>();
        conditions.put("name","枞哥");

        Person person = new Person();
        person.setPhone("123456789000");
        person.setAddress("武汉花山");

        return personService.updateByConditions(person,conditions);
    }

    //删除
    @RequestMapping("delete")
    @ResponseBody
    public boolean deleteById(Integer id){
        return personService.deleteById(id);
    }

    @RequestMapping("login1")
    @ResponseBody
    public String login1(String name,  String password){
        System.out.println("name = "+name);
        System.out.println("password = "+password);
        return "login1 success";
    }

//    @RequestMapping("login2")
//    @ResponseBody
//    public String login2(@RequestBody User user){
//        System.out.println("name = "+user.getName());
//        System.out.println("password = "+user.getPassword());
//        return "login2 success";
//    }

    @RequestMapping("/getByPage")
    @ResponseBody
    public PageInfo getByPage(Integer pageNo, Integer pageSize){
        System.out.println(pageNo);
        System.out.println(pageSize);
        Page<Person> page = PageHelper.startPage(pageNo,pageSize);
        List list = personService.selectAll();
        PageInfo<Person> pageInfo = new PageInfo<>(list, pageSize);
        System.out.println(pageInfo);
        return pageInfo;

    }











}
