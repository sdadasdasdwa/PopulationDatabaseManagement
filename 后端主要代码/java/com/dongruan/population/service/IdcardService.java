package com.dongruan.population.service;

import com.dongruan.population.entity.Idcard;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86181
* @description 针对表【idcard】的数据库操作Service
* @createDate 2023-07-03 15:26:40
*/
public interface IdcardService extends IService<Idcard> {

    List queryIdCard(Idcard idcard);

    List selectIDcard(Idcard conditions);

    Boolean insertIDCard(Idcard idcard);

    Boolean deleteIDCard(Integer id);

    boolean updateIDcard(Idcard idcard);
}
