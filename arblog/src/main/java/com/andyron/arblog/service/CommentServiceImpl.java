package com.andyron.arblog.service;

import com.andyron.arblog.dao.CommentRepository;
import com.andyron.arblog.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Andy Ron
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> listCommentByblogId(Long blogId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdTime");
        return commentRepository.findByBlogId(blogId, sort);
    }

    @Transactional
    @Override
    public Comment saveCommet(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if (parentCommentId == -1) {
            comment.setParentComment(commentRepository.getById(parentCommentId));
        } else {
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentRepository.save(comment);
    }
}
