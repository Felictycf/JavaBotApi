package com.wuzh.blog.Service;

import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.TagVo;

import java.util.List;

/**
 * @auther :Wuzh
 * @date :2022/7/13
 */
public interface TagService {
    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    Result tags();

    Result findDetails();

    Result findDetailsById(Long id);
}
