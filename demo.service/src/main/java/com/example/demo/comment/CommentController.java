package com.example.demo.comment;

import com.example.demo.entity.Comment;
import com.example.demo.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentMapper commentMapper;

    @PostMapping("/save")
    public Long insertComment(@RequestBody Comment comment){
        return commentMapper.save(comment);
    }


    @DeleteMapping(value="/delete/{id}")
    public Long deleteComment(@PathVariable Long id) {

        return commentMapper.deleteById(id);
    }

    @GetMapping("/{boardId}")
    public List<Comment> getComments (@PathVariable Long boardId){
        return commentMapper.findByBoardId(boardId);
    }




}
