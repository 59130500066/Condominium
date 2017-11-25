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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BoomGDH559
 */
public class ManagerEmp {

    public static List<ManagerEmp> showEmp() {
        
        List<ManagerEmp> emp = null;
        try{
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement state = con.prepareStatement("select * from managerEmp");
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                if(emp == null){
                    emp = new ArrayList<ManagerEmp>();
                }
                ManagerEmp man = new ManagerEmp();
                man.setmFname(rs.getString("manFname"));
                man.setmLname(rs.getString("manLname"));
                emp.add(man);
            }
            con.close();
        }catch(SQLException s){
            s.printStackTrace();
        }
        return emp;
        
    }
    
    private int manId;
    private String mFname,mLname;

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public String getmFname() {
        return mFname;
    }

    public void setmFname(String mFname) {
        this.mFname = mFname;
    }

    public String getmLname() {
        return mLname;
    }

    public void setmLname(String mLname) {
        this.mLname = mLname;
    }
    
    public static ManagerEmp findmanbyId(int manId){
        
        ManagerEmp man = new ManagerEmp();
        try{
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement state = con.prepareStatement("select * from managerEmp where manId = ?");
            state.setInt(1, manId);
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                man.setManId(rs.getInt(1));
                man.setmFname(rs.getString(2));
                man.setmLname(rs.getString(3));
            }
        }catch(SQLException s){
            System.err.print(s);
        }
        return man;
        
        
    }
    
    
    
//    public static void main(String[] args) {
//        
//        List<ManagerEmp> emp = ManagerEmp.showEmp();
//        for (ManagerEmp managerEmp : emp) {
//            System.out.println(managerEmp.getManId()+" "+managerEmp.getmFname()+" "+managerEmp.getmLname());
//        }
//    }
    
    
    
}

