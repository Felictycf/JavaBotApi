package com.wuzh.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuzh.blog.dao.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther :Wuzh
 * @date :2022/7/22/13:07
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
