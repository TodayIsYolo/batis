package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Board {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<Comment> comments;



    public Board(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void updateBoard(String title, String content){
        this.title = title;
        this.content = content;
    }

}
