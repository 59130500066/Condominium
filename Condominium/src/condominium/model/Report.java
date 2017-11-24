/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condominium.model;

/**
 *
 * @author B_PNP
 */
public class Report {
    private int reportId;
    private String reportTopic;
    private String reportDetail;
    private String reportStart;
    private String chargeName;
    private int chargePrice;
    private int roomId;
    private int probId;
    private int statusId;
    private int manId;

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

    public String getReportStart() {
        return reportStart;
    }

    public void setReportStart(String reportStart) {
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
    
    
    
    
}
