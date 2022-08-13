package com.wuzh.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuzh.blog.dao.pojo.RegisterCode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther :Wuzh
 * @date :2022/7/29/21:07
 */
@Mapper
public interface RegisterCodeMapper extends BaseMapper<RegisterCode> {
    List<RegisterCode> findcode();
}
