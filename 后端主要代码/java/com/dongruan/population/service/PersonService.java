package com.dongruan.population.service;

import com.dongruan.population.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 86181
* @description 针对表【person】的数据库操作Service
* @createDate 2023-07-03 15:47:17
*/
public interface PersonService extends IService<Person> {

    List selectAll();

    List getByConditions(Person person);

    boolean addPerson(Person person);

    boolean updatePerson(Person person);

    boolean updateByConditions(Person person, Map conditions);

    boolean deleteById(Integer id);
}
