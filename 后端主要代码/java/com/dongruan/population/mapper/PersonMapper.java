package com.dongruan.population.mapper;

import com.dongruan.population.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author 86181
* @description 针对表【person】的数据库操作Mapper
* @createDate 2023-07-03 15:47:17
* @Entity com.dongruan.population.entity.Person
*/
@SuppressWarnings("MybatisXMapperMethodInspection")
public interface PersonMapper extends BaseMapper<Person> {



    boolean updateByConditons(@Param("person") Person person, @Param("conditions") Map conditions);

    List<Person> selectAll();

    List<Person> selectByConditions(Person person);
}




