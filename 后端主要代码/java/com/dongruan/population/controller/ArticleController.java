package com.dongruan.population.controller;

import com.dongruan.population.entity.MsArticle;
import com.dongruan.population.entity.Person;
import com.dongruan.population.service.MsArticleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private MsArticleService msArticleService;

    @RequestMapping("/articles")
    @ResponseBody
    public PageInfo listArticles(Integer pageNo, Integer pageSize){
        System.out.println(pageNo);
        System.out.println(pageSize);
        Page<MsArticle> page = PageHelper.startPage(pageNo,pageSize);
        List list = msArticleService.listArticles();
        PageInfo<MsArticle> pageInfo = new PageInfo<>(list, pageSize);
        System.out.println(pageInfo);
        return pageInfo;
    }

}
