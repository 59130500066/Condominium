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
import java.sql.SQLException;

/**
 *
 * @author B_PNP
 */
public class Room {
    private int roomId;
    private String roomNo;
    private String roomType;
    private String roomFloor;
    private int userId;
    private int buildId;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(String roomFloor) {
        this.roomFloor = roomFloor;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBuildId() {
        return buildId;
    }

    public void setBuildId(int buildId) {
        this.buildId = buildId;
    }

    @Override
    public String toString() {
        return "Room{" + "roomId=" + roomId + ", roomNo=" + roomNo + ", roomType=" + roomType + ", roomFloor=" + roomFloor + ", userId=" + userId + ", buildId=" + buildId + '}';
    }
    
    public static Room finduserbyId(int roomId){
        
        Room rm = new Room();
        try{
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement state = con.prepareStatement("select * from room rm join user u on rm.userId = u.userId where rm.roomId = ?");
            state.setInt(1,roomId);
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                rm.setRoomId(rs.getInt("roomId"));
                rm.setRoomNo(rs.getString("roomNo"));
                rm.setUser(User.findById(rs.getInt("userId")));
                
            }
            
            con.close();
            
        }catch(SQLException s){
            s.printStackTrace();
            System.err.print(s);
        }

        return rm;    
        
        
    }
  
    public static Room findRoomIdByUserId(int userId){
        Room r = new Room();
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT * FROM `room` WHERE `userId` = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                r.setRoomId(rs.getInt("roomId"));                               
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    
    public static void main(String[] args) {
        System.out.println(findRoomIdByUserId(4));
    }
}
