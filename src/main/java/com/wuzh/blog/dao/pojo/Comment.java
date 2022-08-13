package com.wuzh.blog.dao.pojo;

import lombok.Data;

/**
 * @auther :Wuzh
 * @date :2022/7/22/13:07
 */
@Data
public class Comment {

    private Long id;

    private String content;

    private Long createDate;

    private Long articleId;

    private Long authorId;

    private Long parentId;

    private Long toUid;

    private Integer level;
}
