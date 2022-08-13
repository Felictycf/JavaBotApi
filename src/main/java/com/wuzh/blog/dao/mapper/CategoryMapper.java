package com.wuzh.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.wuzh.blog.dao.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther :Wuzh
 * @date :2022/7/17/18:07
 */@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
