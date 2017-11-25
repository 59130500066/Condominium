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
public class Problem {
    private int probId;
    private String probName;

    public int getProbId() {
        return probId;
    }

    public void setProbId(int probId) {
        this.probId = probId;
    }

    public String getProbName() {
        return probName;
    }

    public void setProbName(String probName) {
        this.probName = probName;
    }

    @Override
    public String toString() {
        return "Problem{" + "probId=" + probId + ", probName=" + probName + '}';
    }
    
    public static Problem findProbIdByprobName(String probName){
        Problem p = new Problem();
        try{
            Connection con = ConnectionBuilder.getConnection();
            String sql = "SELECT * FROM `problemType` WHERE `probName` LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, probName);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                p.setProbId(rs.getInt("probId"));                               
            }
            con.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return p;
    }
    
    public static void main(String[] args) {
        System.out.println(findProbIdByprobName("ระบบไฟฟ้า"));
    }
}
