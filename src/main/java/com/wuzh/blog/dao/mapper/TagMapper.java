package com.wuzh.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuzh.blog.dao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther :Wuzh
 * @date :2022/7/13
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> findTagsByArticleId(Long articleId);

    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagsIds(List<Long> tagIds);
}
