/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author KimYoseph
 */
public class userDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    
    // DB 연결
    public userDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String jdbcDriver = "jdbc:mysql://localhost:3306/health?" +
                                "useUnicod=true&characterEncoding=UTF-8";
            // 아이디 비번 자기꺼 입력
            String dbUser = "root";
            String dbPass = "rootpw";
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // 회원가입
    public int joinMember(User user){
        String SQL = "insert into user values(?, ?, ?)";
//        String SQL = "insert into user values(";
//        SQL += "'" + id + "', ";
//        SQL += "'" + pw + "', ";
//        SQL += "'" + name + "')";
        try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            pstmt.setString(3, user.getUserName());
            return  pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  -1;
    }
}
