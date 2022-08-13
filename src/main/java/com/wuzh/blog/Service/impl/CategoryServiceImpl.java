package com.wuzh.blog.Service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuzh.blog.Service.CategoryService;
import com.wuzh.blog.dao.mapper.CategoryMapper;
import com.wuzh.blog.dao.pojo.Category;
import com.wuzh.blog.vo.CategoryVo;
import com.wuzh.blog.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther :Wuzh
 * @date :2022/7/17/18:07
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public CategoryVo findCategoryById(Long categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        CategoryVo categoryVo=new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        categoryVo.setId(String.valueOf(category.getId()));
        return categoryVo;
    }

    @Override
    public Result findAll() {
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        wrapper.select(Category::getId,Category::getCategoryName);
        List<Category> categories = this.categoryMapper.selectList(wrapper);

        return Result.success(copyList(categories));
    }

    @Override
    public Result findAllDetail() {
        LambdaQueryWrapper<Category> wrapper=new LambdaQueryWrapper<>();
        List<Category> categories = this.categoryMapper.selectList(wrapper);

        return Result.success(copyList(categories));
    }

    @Override
    public Result findAllDetailById(Long id) {
        Category category=categoryMapper.selectById(id);
        return Result.success(copy(category));
    }

    public CategoryVo copy(Category category){
        CategoryVo categoryVo=new CategoryVo();

        BeanUtils.copyProperties(category,categoryVo);
        categoryVo.setId(String.valueOf(category.getId()));
        return categoryVo;
    }

    private List<CategoryVo> copyList(List<Category> categoryList) {
        List<CategoryVo> categoryVoList=new ArrayList<>();
        for (Category category:categoryList){
            categoryVoList.add(copy(category));
        }
        return categoryVoList;
    }
}
