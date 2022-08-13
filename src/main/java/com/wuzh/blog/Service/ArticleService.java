package com.wuzh.blog.Service;

import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.params.ArticleParam;
import com.wuzh.blog.vo.params.PageParams;

/**
 * @auther :Wuzh
 * @date :2022/7/13
 */

public interface ArticleService {
    Result listArticle(PageParams pageParams);

    Result hotArticle(int limit);

    Result newArticles(int limit);
/*
* 文章归档*/
    Result listArticles();
/*
* 查看文章详情*/
    Result findArticleById(Long articleId);
/*发布问题*/
    Result publish(ArticleParam articleParam);
}
