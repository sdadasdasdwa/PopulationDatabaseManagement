package com.dongruan.population.mapper;

import com.dongruan.population.entity.Idcard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 86181
* @description 针对表【idcard】的数据库操作Mapper
* @createDate 2023-07-03 15:26:40
* @Entity com.dongruan.population.entity.Idcard
*/
public interface IdcardMapper extends BaseMapper<Idcard> {

    List<Idcard> queryIdCard(Idcard idcard);

    List<Idcard> selectIDcard(Idcard conditions);

    boolean updateIDcard(Idcard idcard);
}




