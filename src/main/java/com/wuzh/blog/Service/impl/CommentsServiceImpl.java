package com.wuzh.blog.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wuzh.blog.Service.CommentsService;
import com.wuzh.blog.Service.SysUserService;
import com.wuzh.blog.Service.ThreadService;
import com.wuzh.blog.dao.mapper.ArticleMapper;
import com.wuzh.blog.dao.mapper.CommentMapper;
import com.wuzh.blog.dao.pojo.Article;
import com.wuzh.blog.dao.pojo.Comment;
import com.wuzh.blog.dao.pojo.SysUser;
import com.wuzh.blog.utils.UserThreadLocal;
import com.wuzh.blog.vo.CommentVo;
import com.wuzh.blog.vo.Result;
import com.wuzh.blog.vo.UserVo;
import com.wuzh.blog.vo.params.CommentParam;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther :Wuzh
 * @date :2022/7/22/13:07
 */
@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ThreadService threadService;
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Result commentsByArticleId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getArticleId,id);
        queryWrapper.eq(Comment::getLevel,1);
        List<Comment> comments=commentMapper.selectList(queryWrapper);
        List<CommentVo> commentVos=copyList(comments);
        threadService.updateArticleCommentCount(articleMapper,id);
        return Result.success(commentVos);

    }

    @Override
    public Result comment(CommentParam commentParam) {
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        Comment comment=new Comment();
        comment.setArticleId(commentParam.getArticleId());
        comment.setAuthorId(sysUser.getId());
        comment.setContent(commentParam.getContent());
        comment.setCreateDate(System.currentTimeMillis());
        Long parent=commentParam.getParent();
        if (parent==null ||parent==0){
            comment.setLevel(1);
        }else {
            comment.setLevel(2);
        }
        comment.setParentId(parent==null?0:parent);
        Long toUserId=commentParam.getToUserId();
        comment.setToUid(toUserId==null?0:toUserId);
        commentMapper.insert(comment);
        return Result.success(null);
    }

    private List<CommentVo> copyList(List<Comment> comments) {
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : comments) {
            commentVoList.add(copy(comment));
        }
        return commentVoList;
    }
    public CommentVo copy(Comment comment){
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(comment,commentVo);
        //时间格式化
        commentVo.setCreateDate(new DateTime(comment.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        commentVo.setId(String.valueOf(comment.getId()));
        Long authorId = comment.getAuthorId();
        UserVo userVo = sysUserService.findUserVoById(authorId);
        commentVo.setAuthor(userVo);
        //评论的评论
        Integer level= commentVo.getLevel();
        if (1==level){
            Long id= comment.getId();
            List<CommentVo> commentVoList=findCommentsByParentId(id);
            commentVo.setChildrens(commentVoList);
        }
        if (level>1){
            Long toUid=comment.getToUid();
            UserVo toUserVo=sysUserService.findUserVoById(toUid);
            commentVo.setToUser(toUserVo);
        }
        return commentVo;


    }

    private List<CommentVo> findCommentsByParentId(Long id) {
        LambdaQueryWrapper<Comment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getParentId,id);
        queryWrapper.eq(Comment::getLevel,2);
        return copyList(commentMapper.selectList(queryWrapper));
    }
}
