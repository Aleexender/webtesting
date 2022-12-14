package com.example.websitetest;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String id; //아이디
    private String password; // 비밀번호
    private String idnumber; // 주민번호
    private String email; // 이메일
}
