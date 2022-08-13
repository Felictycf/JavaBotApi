package com.wuzh.blog.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuzh.blog.Service.TagService;
import com.wuzh.blog.dao.mapper.TagMapper;
import com.wuzh.blog.dao.pojo.Tag;
import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther :Wuzh
 * @date :2022/7/13
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    public TagVo copy(Tag tag){
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        tagVo.setId(String.valueOf(tag.getId()));
        return tagVo;
    }
    public List<TagVo> copyList(List<Tag> tagList){
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(copy(tag));
        }
        return tagVoList;
    }
    @Override
    public List<TagVo> findTagsByArticleId(Long articleId) {
        List<Tag> tags=tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        /*根据标签下拥有的问题数量进行查询
        * 根据tag_id分组计数从大到小排列
        * */
        List<Long> tagIds=tagMapper.findHotsTagIds(limit);
        if (CollectionUtils.isEmpty(tagIds)){
            return Result.success(Collections.emptyList());
        }
        List<Tag> tagIds1 = tagMapper.findTagsByTagsIds(tagIds);
        return Result.success(tagIds1);
    }

    @Override
    public Result tags() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(Tag::getId,Tag::getTagName);
        List<Tag> tags = tagMapper.selectList(queryWrapper);

        return Result.success(copyList(tags));
    }

    @Override
    public Result findDetails() {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        List<Tag> tags = tagMapper.selectList(queryWrapper);
        return Result.success(copyList(tags));
    }

    @Override
    public Result findDetailsById(Long id) {

       Tag tag= tagMapper.selectById(id);
       return Result.success(copy(tag));
    }
}
