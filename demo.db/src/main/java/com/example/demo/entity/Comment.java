package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Comment {
    private Long id;
    private String reply;
    private String replyWriter;
    private Long boardId;


    public Comment(String reply, String replyWriter, Long boardId) {
        this.reply=reply;
        this.replyWriter=replyWriter;
        this.boardId=boardId;
    }
}
