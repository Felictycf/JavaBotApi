package com.wuzh.blog.dao.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;


@Data
public class Bot {
    int id ;
    String  token;
}
