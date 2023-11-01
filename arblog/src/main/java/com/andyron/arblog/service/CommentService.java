package com.andyron.arblog.service;

import com.andyron.arblog.po.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> listCommentByblogId(Long blogId);

    Comment saveCommet(Comment comment);
}
