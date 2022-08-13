package com.wuzh.blog.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuzh.blog.dao.mapper.ArticleMapper;
import com.wuzh.blog.dao.mapper.CommentMapper;
import com.wuzh.blog.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @auther :Wuzh
 * @date :2022/7/19/22:07
 */
@Component
public class ThreadService {
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {
        //阅读次数
        int viewCounts = article.getViewCounts();
        Article article1=new Article();
        article1.setViewCounts(viewCounts+1);
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId,article.getId());
        queryWrapper.eq(Article::getViewCounts,viewCounts);
        articleMapper.update(article1,queryWrapper);


    }

    public void updateArticleCommentCount(ArticleMapper articleMapper,Long id) {
        Article article = articleMapper.selectById(id);
        int commentCountsount=article.getCommentCounts();
        Article article1=new Article();
        article1.setCommentCounts(commentCountsount+1);
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId,article.getId());
        queryWrapper.eq(Article::getCommentCounts,commentCountsount);
        articleMapper.update(article1,queryWrapper);
    }
}
