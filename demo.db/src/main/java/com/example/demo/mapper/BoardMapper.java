package com.example.demo.mapper;

import com.example.demo.entity.Board;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface BoardMapper {
    //저장
    @Insert("INSERT INTO board(title,content,writer, created_at, modified_at) VALUES(#{board.title}, #{board.content}, #{board.writer}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
//    @Result(property = "createdAt", column = "created_at")
    Long save(@Param("board") Board board);


    //전체조회//id를 수정날짜로 변경하기
    @Select("SELECT * FROM board ORDER BY modified_at DESC")
    @Results(id="boardMap", value={
            @Result(property = "id", column = "id"),
            @Result(property = "modifiedAt", column = "modified_at"),
            @Result(property = "title", column = "title"),
            @Result(property = "content", column = "content"),
            @Result(property = "writer", column = "writer"),
            @Result(property = "comments", column = "id", many = @Many(select = "com.example.demo.mapper.CommentMapper.findByBoardId"))
    })
    //수정시간 추가하기
    List<Board> findAllByOrderByModifiedAtDesc();


    @Select("SELECT * FROM board WHERE id=#{id}")
    @ResultMap("boardMap")
    Board findById(@Param("id") Long id);

    @Select("SELECT * FROM board WHERE writer=#{writer}")
    @ResultMap("boardMap")
    Board findByWriter(@Param("writer") String writer);


    @Delete("DELETE FROM board WHERE id=#{id}")
    void deleteById(@Param("id") Long id);
    //수정,삭제,한개조회

    @Update("UPDATE board SET title = #{board.title}, content = #{board.content}, modified_at =  CURRENT_TIMESTAMP WHERE id = #{board.id}")
    void update (@Param("board") Board board);




    @Select("SELECT * FROM board WHERE title LIKE CONCAT('%', #{searchWord, jdbcType=VARCHAR}, '%') OR content LIKE CONCAT('%', #{searchWord, jdbcType=VARCHAR}, '%') ORDER BY modified_at DESC")
//    @ResultMap("boardMap")
    List<Board> findAllSearch(@Param("searchWord") String searchWord);









//    List<Board> findAllByOrderByModifiedAtDesc();
//    List<Board> findByWriter(String writer);
//
//    @Query(value = "SELECT b FROM Board b WHERE b.title LIKE %:searchWord% OR b.content LIKE %:searchWord% ORDER BY b.modifiedAt DESC")
//    List<Board> findAllSearch(String searchWord);
//
//
//    @Query(value = "SELECT b FROM Board b WHERE b.title LIKE %:searchWord% OR b.content LIKE %:searchWord% ORDER BY b.modifiedAt DESC")
//    Page<Board> findAllSearch(String searchWord, Pageable pageable);
//
//    Page<Board> findAllByOrderByModifiedAtDesc(Pageable pageable);
//
}
