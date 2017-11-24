/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condominium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BoomGDH559
 */
public class ConnectionBuilder {

    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://45.76.180.36:3306/Condominium?characterEncoding=UTF-8", "test", "test");
            //characterEncoding=UTF-8

//            PreparedStatement state = con.prepareStatement("select * from user");
//            ResultSet result = state.executeQuery();
//            while(result.next()){
//                System.out.println(result.getString("userId")+" "+result.getNString("userName"));
//            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException n) {
            System.out.println("Can't Connection");
        }
        return con;

    }

    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionBuilder.getConnection();
        PreparedStatement state = con.prepareStatement("select * from user");
        ResultSet result = state.executeQuery();
        while (result.next()) {
            System.out.println(result.getInt("userId") + " " + result.getNString("userFname"));
        }
    }

}
