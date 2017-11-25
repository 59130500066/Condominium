/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condominium.model;

import condominium.ConnectionBuilder;
import java.sql.*;

/**
 *
 * @author BoomGDH559
 */
public class Status {
    
    private int statusId;
    private String statusName;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    
    public static Status findstatusbyId(int statusId){
        
        Status st = new Status();
        try{
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement state = con.prepareStatement("select * from status where statusId = ?");
            state.setInt(1, statusId);
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                st.setStatusId(rs.getInt(1));
                st.setStatusName(rs.getString(2));
            }
        }catch(SQLException s){
            System.err.print(s);
        }
        return st;
        
        
    }
    
    
}
