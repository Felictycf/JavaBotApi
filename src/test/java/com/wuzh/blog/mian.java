package com.wuzh.blog;

import com.wuzh.blog.dao.mapper.RegisterCodeMapper;
import com.wuzh.blog.dao.pojo.RegisterCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther :Wuzh
 * @date :2022/7/29/21:07
 */
public class mian {
    @Autowired
    private RegisterCodeMapper registerCodeMapper;
    public void a(){
//        List<RegisterCode> findcode = registerCodeMapper.findcode();
        System.out.println(registerCodeMapper.findcode());
//        boolean contains = findcode.contains(666666);
//        System.out.println(contains);

    }

    public static void main(String[] args) {
        mian a=new mian();
        a.a();
    }
}
