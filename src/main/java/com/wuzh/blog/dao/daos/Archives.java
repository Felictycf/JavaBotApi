package com.wuzh.blog.dao.daos;

import lombok.Data;

/**
 * @auther :Wuzh
 * @date :2022/7/14
 */
@Data
public class Archives {
    private Integer year;
    private Integer month;
    private Long count;
}
