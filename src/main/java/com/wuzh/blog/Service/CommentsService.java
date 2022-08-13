package com.wuzh.blog.Service;

import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.params.CommentParam;

/**
 * @auther :Wuzh
 * @date :2022/7/22/13:07
 */
public interface CommentsService {
    Result commentsByArticleId(Long id);

    Result comment(CommentParam commentParam);
}
