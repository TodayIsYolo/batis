package com.example.demo.mapper;

import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO comment(reply,reply_writer,board_id) VALUES(#{comment.reply}, #{comment.replyWriter}, #{comment.boardId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long save(@Param("comment") Comment comment);

    @Delete("DELETE FROM comment WHERE id=#{id}")
    Long deleteById(@Param("id") Long id);

    @Select("SELECT * FROM comment WHERE board_id=#{boardId}")
    @Results(id="CommentMap", value={
            @Result(property = "replyWriter", column = "reply_writer"),
            @Result(property = "boardId", column = "board_id")
    })
    List<Comment> findByBoardId(@Param("boardId") Long boardId);
}
