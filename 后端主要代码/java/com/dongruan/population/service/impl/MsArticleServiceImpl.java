package com.dongruan.population.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dongruan.population.entity.MsArticle;
import com.dongruan.population.service.MsArticleService;
import com.dongruan.population.mapper.MsArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 86181
 * @description 针对表【ms_article】的数据库操作Service实现
 * @createDate 2023-07-06 16:48:09
 */
@Service
public class MsArticleServiceImpl extends ServiceImpl<MsArticleMapper, MsArticle>
        implements MsArticleService {

    @Resource
    MsArticleMapper msArticleMapper;


    @Override
    public List listArticles() {
        return msArticleMapper.listArticles();
    }
}




