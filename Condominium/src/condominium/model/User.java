/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condominium.model;

import condominium.ConnectionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author B_PNP
 */
public class User {

    private int userId;
    private String userFname;
    private String userLname;
    private String userIdcard;
    private String userTelno;
    private String userNation;
    private String userEmergTel;
    private String userType;
    private String userAddress;
    private String userName;
    private String userPassword;

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }

    public String getUserTelno() {
        return userTelno;
    }

    public void setUserTelno(String userTelno) {
        this.userTelno = userTelno;
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation;
    }

    public String getUserEmergTel() {
        return userEmergTel;
    }

    public void setUserEmergTel(String userEmergTel) {
        this.userEmergTel = userEmergTel;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public User(String userType, String userName, String userPassword) {
        this.userType = userType;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User() {
    }

  
    public static User findByUser(String user, String pass) {
        User u = new User();
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT * FROM `user` WHERE `userName` LIKE ? AND `userPassword` LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                u.setUserType(rs.getString("userType"));
                u.setUserName(rs.getString("userName"));
                u.setUserPassword(rs.getString("userPassword"));
                u.setUserFname(rs.getString("userFName"));
                u.setUserLname(rs.getString("userLName"));
                u.setUserAddress(rs.getString("userAddress"));
                u.setUserEmergTel(rs.getString("userEmergTel"));
                u.setUserId(rs.getInt("userId"));
                u.setUserNation(rs.getString("userNation"));
                u.setUserTelno(rs.getString("userTelno"));                
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return u;
    }
    
    public static User findById(int userId) {
        User u = new User();
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT * FROM `user` WHERE userId = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1,userId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                u.setUserType(rs.getString("userType"));
                u.setUserName(rs.getString("userName"));
                u.setUserPassword(rs.getString("userPassword"));
                u.setUserFname(rs.getString("userFName"));
                u.setUserLname(rs.getString("userLName"));
                u.setUserAddress(rs.getString("userAddress"));
                u.setUserEmergTel(rs.getString("userEmergTel"));
                u.setUserId(rs.getInt("userId"));
                u.setUserNation(rs.getString("userNation"));
                u.setUserTelno(rs.getString("userTelno"));                
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
        return u;
    }
    

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", userFname=" + userFname + ", userLname=" + userLname + ", userIdcard=" + userIdcard + ", userTelno=" + userTelno + ", userNation=" + userNation + ", userEmergTel=" + userEmergTel + ", userType=" + userType + ", userAddress=" + userAddress + ", userName=" + userName + ", userPassword=" + userPassword + '}';
    }

    public static void main(String[] args) {
        System.out.println(findByUser("bom", "admin"));
    }
}
