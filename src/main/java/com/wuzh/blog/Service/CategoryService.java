package com.wuzh.blog.Service;

import com.wuzh.blog.vo.CategoryVo;
import com.wuzh.blog.vo.Result;
import org.springframework.stereotype.Service;

/**
 * @auther :Wuzh
 * @date :2022/7/17/18:07
 */
@Service
public interface CategoryService {
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result findAllDetailById(Long id);
}
