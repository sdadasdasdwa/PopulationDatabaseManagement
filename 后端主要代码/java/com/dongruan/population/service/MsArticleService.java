package com.dongruan.population.service;

import com.dongruan.population.entity.MsArticle;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86181
* @description 针对表【ms_article】的数据库操作Service
* @createDate 2023-07-06 16:48:09
*/
public interface MsArticleService extends IService<MsArticle> {


    List listArticles();
}
