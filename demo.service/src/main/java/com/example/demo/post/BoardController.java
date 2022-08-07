
package com.example.demo.post;



import com.example.demo.entity.Board;
import com.example.demo.entity.Comment;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardMapper boardMapper;

    @PostMapping("/save")
    public Long insertBoard(@RequestBody Board board){
        return boardMapper.save(board);
    }

    @GetMapping("/all")
    public List<Board> getBoards (){
        return boardMapper.findAllByOrderByModifiedAtDesc();
    }

    @GetMapping("/{id}")
    public Board getBoard (@PathVariable Long id){
        return boardMapper.findById(id);
    }

    @GetMapping("/search")
    public List<Board> getSearchs (@RequestParam String searchWord){
        System.out.println(searchWord);
        return boardMapper.findAllSearch(searchWord);
    }

    @PutMapping("/update/{id}")
    public void updateBoard(@RequestBody Board board) {
        boardMapper.update(board);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard (@PathVariable Long id){
        boardMapper.deleteById(id);
    }



    //날짜 넣기
}
