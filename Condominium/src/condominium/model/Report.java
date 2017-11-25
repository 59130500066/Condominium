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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author B_PNP
 */
public class Report {

    private int reportId;
    private String reportTopic;
    private String reportDetail;
    private String chargeName;
    private int chargePrice;
    private int roomId;
    private int probId;
    private int statusId;
    private int manId;
    private Timestamp reportStart;
    private ManagerEmp man;
    private Status status;
    private Problem prob;
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
    public ManagerEmp getMan() {
        return man;
    }

    public void setMan(ManagerEmp man) {
        this.man = man;
    }

    public Status getStat() {
        return status;
    }

    public void setStat(Status status) {
        this.status = status;
    }

    public Problem getProb() {
        return prob;
    }

    public void setProb(Problem prob) {
        this.prob = prob;
    }
    
    
    
    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportTopic() {
        return reportTopic;
    }

    public void setReportTopic(String reportTopic) {
        this.reportTopic = reportTopic;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public Timestamp getReportStart() {
        return reportStart;
    }

    public void setReportStart(Timestamp reportStart) {
        this.reportStart = reportStart;
    }

    

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }

    public int getChargePrice() {
        return chargePrice;
    }

    public void setChargePrice(int chargePrice) {
        this.chargePrice = chargePrice;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getProbId() {
        return probId;
    }

    public void setProbId(int probId) {
        this.probId = probId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getManId() {
        return manId;
    }

    public void setManId(int manId) {
        this.manId = manId;
    }

    public static boolean insertReoprt(String reportTop, String reposrtDe,
            int problemId, int roomId) {
        boolean r = false;
        try {
            Connection con = ConnectionBuilder.getConnection();
            String sql = "INSERT INTO `Condominium`.`report` (`reportId`, "
                    + "`reportTopic`, `reportDetail`, `reportStart`, `chargeName`, "
                    + "`chargePrice`, `roomId`, `probId`, `statusId`, `manId`) "
                    + "VALUES (NULL, ?, ?, CURRENT_TIMESTAMP, '', "
                    + "0, ?, ?, 1, 0);";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, reportTop);
            pstm.setString(2, reposrtDe);
            pstm.setInt(3, roomId);
            pstm.setInt(4, problemId);
            int update = pstm.executeUpdate();
            if (update == 1) {
                r = true;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return r;
    }
    
    public static List<Report> showTable(){
        
        List<Report> rp = null;
        try{
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement state = con.prepareStatement("select * from report r join status s on r.statusId = s.statusId join managerEmp m on r.manId = m.manId join problemType p on p.probId = r.probId join room rm on r.roomId = rm.roomId");
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                if (rp == null) {
                    rp = new ArrayList<Report>();
                }
                Report rep = new Report();
                rep.setReportStart(rs.getTimestamp("reportStart"));
                rep.setReportTopic(rs.getString("reportTopic"));
                rep.setRoom(Room.finduserbyId(rs.getInt("roomId")));
                rep.setProb(Problem.findprobbyId(rs.getInt("probId")));
                rep.setStat(Status.findstatusbyId(rs.getInt("statusId")));
                rep.setMan(ManagerEmp.findmanbyId(rs.getInt("manId")));
                rp.add(rep);
            }
            
        }catch(SQLException s){
            s.printStackTrace();
            System.err.print(s);
        }
        
        return rp;
    
    }
    
    public static Report configShow(int reportId){
        
        Report config = new Report();
        try{
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement state = con.prepareStatement("select * from report r join status s on r.statusId = s.statusId join managerEmp m on r.manId = m.manId "
                    + "join problemType p on p.probId = r.probId join room rm on r.roomId = rm.roomId where r.reportId = ?");
            state.setInt(1, reportId);
            ResultSet rs = state.executeQuery();
            while(rs.next()){
                config.setReportTopic(rs.getString("reportTopic"));
                config.setReportDetail(rs.getString("reportDetail"));
                config.setRoom(Room.finduserbyId(rs.getInt("roomId")));
                config.setProb(Problem.findprobbyId(rs.getInt("probId")));
            }
            con.close();
        }catch(SQLException s){
            s.printStackTrace();
            System.err.print(s);
        }
        
        return config;
    }

//    public static void main(String[] args) {
//        Report config = Report.configShow(9);
//        System.out.println(config.getReportTopic());
//    }
}
