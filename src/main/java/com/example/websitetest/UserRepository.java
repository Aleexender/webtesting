package com.example.websitetest;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean addUser(String id) {
        jdbcTemplate.execute("INSERT INTO member(id) VALUES('" + id + "'))");
        return true;
    }

    public boolean addUser(UserModel userModel) {
        jdbcTemplate.execute("INSERT INTO user (id, password, idnumber, email) VALUES " +
                "('" + userModel.getId() + "', '" + userModel.getPassword() + "', '" + userModel.getIdnumber() + "', '" + userModel.getEmail()+ "')");

        return true;
    }


    public boolean checkUser(String id) {
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM member WHERE id = '" + id + "'", Integer.class);
        return count == 0;
    }

    public boolean checkidcard(String idCardNumber) {
        int count = jdbcTemplate.queryForObject("SELECT count(*) FROM member WHERE id = '" + idCardNumber + "'", Integer.class);
        return count == 0;
    }

//    public UserModel getUser(String id) {
//        UserModel userModel = new UserModel();
//    }
}

