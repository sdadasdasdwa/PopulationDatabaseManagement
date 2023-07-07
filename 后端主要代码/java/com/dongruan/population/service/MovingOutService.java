package com.dongruan.population.service;

import com.dongruan.population.entity.Idcard;
import com.dongruan.population.entity.MovingOut;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86181
* @description 针对表【moving_out】的数据库操作Service
* @createDate 2023-07-04 21:19:07
*/
public interface MovingOutService extends IService<MovingOut> {

    List selectMoveOut(MovingOut conditions);

    boolean deleteMoveOut(Integer id);

    boolean updateMovingOut(MovingOut movingOut);
}
