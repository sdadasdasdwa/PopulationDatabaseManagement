package com.dongruan.population.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongruan.population.entity.Idcard;
import com.dongruan.population.mapper.PersonMapper;
import com.dongruan.population.service.IdcardService;
import com.dongruan.population.mapper.IdcardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @author 86181
* @description 针对表【idcard】的数据库操作Service实现
* @createDate 2023-07-03 15:26:40
*/
@Service
public class IdcardServiceImpl extends ServiceImpl<IdcardMapper, Idcard>
    implements IdcardService{

    @Resource
    IdcardMapper idcardMapper;
    @Override
    public List queryIdCard(Idcard idcard) {
//        System.out.println(idcard.getBirthdate());
        return idcardMapper.queryIdCard(idcard);
    }

    @Override
    public List selectIDcard(Idcard conditions) {
//        System.out.println("birthdate= "+conditions.getBirthdate());
        return idcardMapper.selectIDcard(conditions);
    }

    @Override
    public Boolean insertIDCard(Idcard idcard) {
        return idcardMapper.insert(idcard) <0?false:true;
    }

    @Override
    public Boolean deleteIDCard(Integer id) {
        return idcardMapper.deleteById(id)<0?false:true;
    }

    @Override
    public boolean updateIDcard(Idcard idcard) {
        return idcardMapper.updateIDcard(idcard);
    }
}




