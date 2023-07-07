package com.dongruan.population.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongruan.population.entity.Person;
import com.dongruan.population.service.PersonService;
import com.dongruan.population.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
* @author 86181
* @description 针对表【person】的数据库操作Service实现
* @createDate 2023-07-03 15:47:17
*/
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person>
    implements PersonService{

    @Resource
    PersonMapper personMapper;

    public List selectAll(){
        return personMapper.selectAll();
    }

    @Override
    public List getByConditions(Person person) {
        return personMapper.selectByConditions(person);
    }

    @Override
    public boolean addPerson(Person person) {
        return personMapper.insert(person) <0?false:true;
    }

    @Override
    public boolean updatePerson(Person person) {
        return personMapper.updateById(person)<0?false:true;
    }

    @Override
    public boolean updateByConditions(Person person, Map conditions) {
        return personMapper.updateByConditons(person,conditions);
    }

    @Override
    public boolean deleteById(Integer id) {
        return personMapper.deleteById(id)<0?false:true;
    }
}




