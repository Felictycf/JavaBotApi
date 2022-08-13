package com.wuzh.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuzh.blog.dao.daos.Archives;
import com.wuzh.blog.dao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther :Wuzh
 * @date :2022/7/12
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article>{
    List<Archives> listArticles();

    IPage<Article>  listArticle(Page<Article>page,
                                Long categoryId,
                                Long tagId,
                                String year,
                                String month

    );
}
