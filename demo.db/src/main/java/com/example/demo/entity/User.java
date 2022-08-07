package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {
    //pk, 이름,비밀번호, id

    private Long id;

    private String userName;


    private String nickName;//유저id


    private String password;

    public User(String username, String nickName, String password) {
        this.userName=username;
        this.nickName=nickName;
        this.password=password;
    }
}
