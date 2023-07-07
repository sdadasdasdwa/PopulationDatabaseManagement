package com.dongruan.population.mapper;

import com.dongruan.population.entity.MovingOut;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 86181
* @description 针对表【moving_out】的数据库操作Mapper
* @createDate 2023-07-04 21:19:07
* @Entity com.dongruan.population.entity.MovingOut
*/
public interface MovingOutMapper extends BaseMapper<MovingOut> {


    List<MovingOut> selectMovingOut(MovingOut conditions);

    boolean updateMovingOut(MovingOut movingOut);
}




