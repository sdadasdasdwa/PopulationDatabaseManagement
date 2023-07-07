package com.dongruan.population.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dongruan.population.entity.MsArticle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 86181
* @description 针对表【ms_article】的数据库操作Mapper
* @createDate 2023-07-06 16:48:09
* @Entity com.dongruan.population.entity.MsArticle
*/
public interface MsArticleMapper extends BaseMapper<MsArticle> {


    List<MsArticle> listArticles();
}




