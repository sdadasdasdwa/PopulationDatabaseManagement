package com.dongruan.population.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongruan.population.entity.Idcard;
import com.dongruan.population.entity.MovingOut;
import com.dongruan.population.mapper.IdcardMapper;
import com.dongruan.population.service.MovingOutService;
import com.dongruan.population.mapper.MovingOutMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author 86181
* @description 针对表【moving_out】的数据库操作Service实现
* @createDate 2023-07-04 21:19:07
*/
@Service
public class MovingOutServiceImpl extends ServiceImpl<MovingOutMapper, MovingOut>
    implements MovingOutService{

    @Resource
    MovingOutMapper movingOutMapper;

    @Override
    public List selectMoveOut(MovingOut conditions) {
        return movingOutMapper.selectMovingOut(conditions);
    }

    @Override
    public boolean deleteMoveOut(Integer id) {
        return movingOutMapper.deleteById(id)<0?false:true;
    }

    @Override
    public boolean updateMovingOut(MovingOut movingOut) {
        return movingOutMapper.updateMovingOut(movingOut);
    }
}




