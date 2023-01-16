package com.example.websitetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean addUser(String id) {
        jdbcTemplate.execute("INSERT INTO member (id, count) VALUES " +
                "('" + id + "', '" + 1 + "')");
        return true;
    }

//    public boolean addUser(UserModel userModel) {
//        jdbcTemplate.execute("INSERT INTO member (id, count) VALUES " +
//                "('" + userModel.getCompany() + "', '" + userModel.getCount() +"')");
//
//        return true;
//    }


    public boolean checkUser(String id) {
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM member WHERE id = '" + id + "'", Integer.class);
        return count == 0;
    }
//    public boolean checkUser(String id) {
//        String query = "SELECT count(*) FROM member WHERE id = ?";
//        Integer count = jdbcTemplate.queryForObject(query,);
//        return count == 0;
//    }

    public boolean plusCount(String id) {
        jdbcTemplate.update("UPDATE member SET count = count +1 WHERE id = '" + id + "'");
        return false;
    }


    public List<UserModel> getAll() {

        String sql = "SELECT * FROM member;";

        List<UserModel> list = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {
            UserModel obj = new UserModel();

            obj.setCompany(((String) row.get("id")));
            obj.setCount((Integer) row.get("count"));
            list.add(obj);
        }

        return list;
    }

    public UserModel updateOrInsert(String id) {
        UserModel userModel = new UserModel();
        jdbcTemplate.update("INSERT INTO member (`id` , `count`)\n" + "VALUES ('"+id+"', 1 ) ON DUPLICATE KEY UPDATE `count`=  `count`+1;");
        return userModel;
    }

    public UserModel insertIfNoID(String id) {
        UserModel userModel = new UserModel();
        jdbcTemplate.execute("INSERT INTO member(id,count)\n" + "VALUES( '" + id + "', +1)");
        return userModel;
    }

    public UserModel updateIfIDExist(String id) {
        UserModel userModel = new UserModel();
        jdbcTemplate.update("UPDATE member \n" + "SET `count`= `count`+1 \n" + "WHERE `id`= '"+ id +"'");
        return userModel;
    }

    public UserModel checkIdExist(String id) {

       return jdbcTemplate.queryForObject("SELECT * \n" + "FROM member\n" + "WHERE `id` = '" + id + "'", new RowMapper<UserModel>() {
            @Override
            public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserModel userModel = new UserModel();
                userModel.setCompany(rs.getString("id"));
                userModel.setCount(rs.getInt("count"));
                return userModel;
            }

        });
    }
}


