/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condominium;

import com.toedter.calendar.JDateChooser;
import condominium.model.ManagerEmp;
import condominium.model.Problem;
import condominium.model.Report;
import static condominium.model.Report.showTable;
import condominium.model.Room;
import condominium.model.User;
import java.awt.Color;
import java.sql.Connection;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BoomGDH559
 */
public class Condominium extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public void showReportUser() {
        List<Report> rep = Report.showTable();
        DefaultTableModel model = (DefaultTableModel) viewReportTB.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < 6; i++) {
            row[0] = rep.get(i).getReportStart();
            row[1] = rep.get(i).getRoom().getUser().getUserFname() + " " + rep.get(i).
                    getRoom().getUser().getUserLname();
            row[2] = rep.get(i).getReportTopic();
            row[3] = rep.get(i).getChargePrice();
            row[4] = rep.get(i).getReportDetail();
            row[5] = rep.get(i).getStat().getStatusName();
            model.addRow(row);
        }
    }

    public void show_report() {
        List<Report> rep = Report.showTable();
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        Object[] row = new Object[7];
        for (int i = 0; i < rep.size(); i++) {
            row[0] = rep.get(i).getReportStart();
            row[1] = rep.get(i).getReportTopic();
            row[2] = rep.get(i).getRoom().getUser().getUserFname() + " " + rep.get(i).getRoom().getUser().getUserLname();
            row[3] = rep.get(i).getRoom().getRoomNo();
            row[4] = rep.get(i).getProb().getProbName();
            row[5] = rep.get(i).getStat().getStatusName();
            row[6] = rep.get(i).getMan().getmFname() + " " + rep.get(i).getMan().getmLname();
            model.addRow(row);
        }
    }

    public void show_emp() {

        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement state = con.prepareStatement("select * from managerEmp");
            ResultSet rs = state.executeQuery();
            while (rs.next()) {
                String name = rs.getString("manFname") + " " + rs.getString("manLname");
                manEmpbox.addItem(name);
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }

    }

    User myuser = null;

    public Condominium() {

        initComponents();
        show_report();
        show_emp();
        showReportUser();
        adRegister.setVisible(false);
        adConfig.setVisible(false);
        adIndex.setVisible(false);
        userIndex.setVisible(false);
        adReport.setVisible(false);
        userProfile.setVisible(false);
        userReport.setVisible(false);
        userViewReport.setVisible(false);
        firstname.setBackground(new Color(0, 0, 0, 0));
        lastname.setBackground(new Color(0, 0, 0, 0));
        usertype.setBackground(new Color(0, 0, 0, 0));
        usertel.setBackground(new Color(0, 0, 0, 0));
        userregis.setBackground(new Color(0, 0, 0, 0));
        useremerg.setBackground(new Color(0, 0, 0, 0));
        userId.setBackground(new Color(0, 0, 0, 0));
        userpass.setBackground(new Color(0, 0, 0, 0));
        usernation.setBackground(new Color(0, 0, 0, 0));
        email.setBackground(new Color(0, 0, 0, 0));
        userpass.setBackground(new Color(0, 0, 0, 0));
        username.setBackground(new Color(0, 0, 0, 0));
        login.setBackground(new Color(0, 0, 0, 0));
        status.setBackground(new Color(0, 0, 0, 0));
        adregisbut.setBackground(new Color(0, 0, 0, 0));
        home.setBackground(new Color(0, 0, 0, 0));
        save.setBackground(new Color(0, 0, 0, 0));
        clear.setBackground(new Color(0, 0, 0, 0));
        register1.setBackground(new Color(0, 0, 0, 0));
        //report.setBackground(new Color(0, 0, 0, 0));
        status.setBackground(new Color(0, 0, 0, 0));
        login.setBackground(new Color(0, 0, 0, 0));
        password.setBackground(new Color(0, 0, 0, 0));
        password.setEchoChar('•');
        setLocationRelativeTo(null);
        profileBtn.setBackground(new Color(0, 0, 0, 0));
        userShow.setBackground(new Color(0, 0, 0, 0));
        reportBtn.setBackground(new Color(0, 0, 0, 0));
        viewStatusBtn.setBackground(new Color(0, 0, 0, 0));
        configTopic.setBackground(new Color(0, 0, 0, 0));
        configRoom.setBackground(new Color(0, 0, 0, 0));
        configDetail.setBackground(new Color(0, 0, 0, 0));
        configType.setBackground(new Color(0, 0, 0, 0));
        searchReport.setBackground(new Color(0, 0, 0, 0));
        configUser.setBackground(new Color(0, 0, 0, 0));
        submit.setBackground(new Color(0, 0, 0, 0));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userViewReport = new javax.swing.JPanel();
        viewReport_okBtn = new javax.swing.JButton();
        viewReportPane = new javax.swing.JScrollPane();
        viewReportTB = new javax.swing.JTable();
        adIndex = new javax.swing.JPanel();
        adregisbut = new javax.swing.JButton();
        register1 = new javax.swing.JButton();
        userIndex_logout1 = new javax.swing.JButton();
        adreportbut = new javax.swing.JButton();
        adminIndexbg = new javax.swing.JLabel();
        adReport = new javax.swing.JPanel();
        home1 = new javax.swing.JButton();
        configbtn = new javax.swing.JButton();
        repTablePane = new javax.swing.JScrollPane();
        reportTable = new javax.swing.JTable();
        adReportBg = new javax.swing.JLabel();
        adConfig = new javax.swing.JPanel();
        searchReportbtn = new javax.swing.JButton();
        okConfig = new javax.swing.JButton();
        cancleConfig = new javax.swing.JButton();
        deleteReport = new javax.swing.JButton();
        configTopic = new javax.swing.JTextField();
        configRoom = new javax.swing.JTextField();
        configDetail = new javax.swing.JTextField();
        configType = new javax.swing.JTextField();
        configUser = new javax.swing.JTextField();
        searchReport = new javax.swing.JTextField();
        statusBox = new javax.swing.JComboBox<>();
        manEmpbox = new javax.swing.JComboBox<>();
        adConfigBg = new javax.swing.JLabel();
        userIndex = new javax.swing.JPanel();
        userShow = new javax.swing.JTextField();
        reportBtn = new javax.swing.JButton();
        profileBtn = new javax.swing.JButton();
        viewStatusBtn = new javax.swing.JButton();
        userIndex_logout = new javax.swing.JButton();
        userIndexBg = new javax.swing.JLabel();
        userReport = new javax.swing.JPanel();
        reportHeader = new javax.swing.JLabel();
        reportDetail = new javax.swing.JLabel();
        problemType = new javax.swing.JLabel();
        reportHeaderTF = new javax.swing.JTextField();
        reportDetailTF = new javax.swing.JTextField();
        problemTypeCB = new javax.swing.JComboBox<>();
        save_report = new javax.swing.JButton();
        cancel_report = new javax.swing.JButton();
        submit = new javax.swing.JTextField();
        userProfile = new javax.swing.JPanel();
        user_fName = new javax.swing.JTextField();
        user_lName = new javax.swing.JTextField();
        user_nation = new javax.swing.JTextField();
        user_idCard = new javax.swing.JTextField();
        user_address = new javax.swing.JTextField();
        user_telNo = new javax.swing.JTextField();
        user_emergTelNo = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        userProfileBg = new javax.swing.JLabel();
        adRegister = new javax.swing.JPanel();
        date = new com.toedter.calendar.JDateChooser();
        lastname = new javax.swing.JTextField();
        home = new javax.swing.JButton();
        userId = new javax.swing.JTextField();
        usertel = new javax.swing.JTextField();
        usernation = new javax.swing.JTextField();
        useremerg = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        userregis = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        usertype = new javax.swing.JComboBox<>();
        clear = new javax.swing.JButton();
        save = new javax.swing.JButton();
        userpass = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        registerBg = new javax.swing.JLabel();
        Login = new javax.swing.JPanel();
        username = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 600));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(750, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userViewReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewReport_okBtn.setText("ตกลง");
        viewReport_okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewReport_okBtnActionPerformed(evt);
            }
        });
        userViewReport.add(viewReport_okBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 70, -1));

        viewReportPane.setBorder(null);

        viewReportTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "วันที่แจ้ง", "ชื่อผู้แจ้ง", "ปัญหาที่แจ้ง", "ค่าใช้จ่าย", "รายละเอียด", "สถานะ"
            }
        ));
        viewReportTB.setEnabled(false);
        viewReportPane.setViewportView(viewReportTB);

        userViewReport.add(viewReportPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 660, 410));

        getContentPane().add(userViewReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        adIndex.setPreferredSize(new java.awt.Dimension(750, 600));
        adIndex.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adregisbut.setContentAreaFilled(false);
        adregisbut.setPreferredSize(new java.awt.Dimension(224, 431));
        adregisbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adregisbutActionPerformed(evt);
            }
        });
        adIndex.add(adregisbut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, 420));

        register1.setContentAreaFilled(false);
        register1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register1ActionPerformed(evt);
            }
        });
        adIndex.add(register1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 70, 30));

        userIndex_logout1.setBorder(null);
        userIndex_logout1.setContentAreaFilled(false);
        userIndex_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIndex_logout1ActionPerformed(evt);
            }
        });
        adIndex.add(userIndex_logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 20));

        adreportbut.setContentAreaFilled(false);
        adreportbut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adreportbutActionPerformed(evt);
            }
        });
        adIndex.add(adreportbut, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 210, 420));

        adminIndexbg.setIcon(new javax.swing.ImageIcon("D:\\Condominium\\Condominium\\Condominium\\src\\condominium\\Admin-index.png")); // NOI18N
        adminIndexbg.setText("jLabel2");
        adIndex.add(adminIndexbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(adIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        adReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home1.setContentAreaFilled(false);
        home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home1ActionPerformed(evt);
            }
        });
        adReport.add(home1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, 80));

        configbtn.setBorder(null);
        configbtn.setContentAreaFilled(false);
        configbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configbtnActionPerformed(evt);
            }
        });
        adReport.add(configbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 90, 40));

        repTablePane.setBorder(null);

        reportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "วันที่แจ้ง", "ปัญหาที่แจ้ง", "ชื่อผู้แจ้ง", "ห้องที่แจ้ง", "ประเภทปัญหา", "สถานะ", "ผู้รับผิดชอบ"
            }
        ));
        reportTable.setEnabled(false);
        repTablePane.setViewportView(reportTable);
        if (reportTable.getColumnModel().getColumnCount() > 0) {
            reportTable.getColumnModel().getColumn(6).setResizable(false);
            reportTable.getColumnModel().getColumn(6).setHeaderValue("ผู้รับผิดชอบ");
        }

        adReport.add(repTablePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 660, 410));

        adReportBg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/condominium/Admin-report.png"))); // NOI18N
        adReportBg.setText("jLabel2");
        adReport.add(adReportBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        adConfig.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchReportbtn.setText("\n");
        searchReportbtn.setBorder(null);
        searchReportbtn.setContentAreaFilled(false);
        searchReportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReportbtnActionPerformed(evt);
            }
        });
        adConfig.add(searchReportbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 70, 30));

        okConfig.setContentAreaFilled(false);
        adConfig.add(okConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 70, 30));

        cancleConfig.setContentAreaFilled(false);
        cancleConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleConfigActionPerformed(evt);
            }
        });
        adConfig.add(cancleConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, 80, 30));

        deleteReport.setContentAreaFilled(false);
        adConfig.add(deleteReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 70, 30));

        configTopic.setEditable(false);
        configTopic.setBorder(null);
        configTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configTopicActionPerformed(evt);
            }
        });
        adConfig.add(configTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 152, 270, 30));

        configRoom.setEditable(false);
        configRoom.setBorder(null);
        adConfig.add(configRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 192, 100, 30));

        configDetail.setEditable(false);
        configDetail.setBorder(null);
        adConfig.add(configDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 400, 70));

        configType.setEditable(false);
        configType.setBorder(null);
        adConfig.add(configType, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 172, 120, 30));

        configUser.setEditable(false);
        configUser.setBorder(null);
        adConfig.add(configUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 192, 100, 30));

        searchReport.setFont(new java.awt.Font("BrowalliaUPC", 1, 24)); // NOI18N
        searchReport.setBorder(null);
        searchReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReportActionPerformed(evt);
            }
        });
        adConfig.add(searchReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 62, 200, 30));

        statusBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "New", "Actualize", "Success", " " }));
        statusBox.setBorder(null);
        adConfig.add(statusBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 222, 120, 30));

        manEmpbox.setBorder(null);
        adConfig.add(manEmpbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 120, 60));

        adConfigBg.setText("jLabel1");
        adConfig.add(adConfigBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 410));

        adReport.add(adConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 660, 410));

        getContentPane().add(adReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        userIndex.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userShow.setEditable(false);
        userShow.setBorder(null);
        userShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userShowActionPerformed(evt);
            }
        });
        userIndex.add(userShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 230, 30));

        reportBtn.setBorder(null);
        reportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBtnActionPerformed(evt);
            }
        });
        userIndex.add(reportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 210, 420));

        profileBtn.setBorder(null);
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });
        userIndex.add(profileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 210, 420));

        viewStatusBtn.setBorder(null);
        viewStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatusBtnActionPerformed(evt);
            }
        });
        userIndex.add(viewStatusBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 210, 420));

        userIndex_logout.setBorder(null);
        userIndex_logout.setContentAreaFilled(false);
        userIndex_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIndex_logoutActionPerformed(evt);
            }
        });
        userIndex.add(userIndex_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 90, 20));

        userIndexBg.setIcon(new javax.swing.ImageIcon("D:\\Condominium\\Condominium\\Condominium\\src\\condominium\\User-index.png")); // NOI18N
        userIndexBg.setText("jLabel1");
        userIndex.add(userIndexBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        getContentPane().add(userIndex, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        userReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reportHeader.setText("หัวข้อปัญหา");
        userReport.add(reportHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        reportDetail.setText("รายละเอียดปัญหา");
        userReport.add(reportDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));

        problemType.setText("ชนิดปัญหา");
        userReport.add(problemType, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));
        userReport.add(reportHeaderTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 600, 30));
        reportHeaderTF.getAccessibleContext().setAccessibleName("");

        reportDetailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportDetailTFActionPerformed(evt);
            }
        });
        userReport.add(reportDetailTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 600, 60));

        problemTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ระบบแอร์", "ระบบประปา", "ระบบไฟฟ้า", "ระบบสื่อสาร", "สิ่งก่อสร้าง/ครุภัณฑ์", "อื่นๆ" }));
        userReport.add(problemTypeCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        save_report.setText("บันทึก");
        save_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_reportActionPerformed(evt);
            }
        });
        userReport.add(save_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        cancel_report.setText("ยกเลิก");
        cancel_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_reportActionPerformed(evt);
            }
        });
        userReport.add(cancel_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, -1, -1));

        submit.setEditable(false);
        submit.setBorder(null);
        userReport.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 310, 150, 40));

        getContentPane().add(userReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        userProfile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_fName.setEditable(false);
        user_fName.setToolTipText("");
        user_fName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_fNameActionPerformed(evt);
            }
        });
        userProfile.add(user_fName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 150, 30));

        user_lName.setEditable(false);
        userProfile.add(user_lName, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 190, 30));

        user_nation.setEditable(false);
        userProfile.add(user_nation, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 190, 30));

        user_idCard.setEditable(false);
        user_idCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_idCardActionPerformed(evt);
            }
        });
        userProfile.add(user_idCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 150, 30));

        user_address.setEditable(false);
        user_address.setAutoscrolls(false);
        userProfile.add(user_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 300, 100));
        user_address.getAccessibleContext().setAccessibleName("");

        user_telNo.setEditable(false);
        userProfile.add(user_telNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 160, 30));

        user_emergTelNo.setEditable(false);
        user_emergTelNo.setToolTipText("");
        userProfile.add(user_emergTelNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 190, 30));

        ok.setText("ตกลง");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        userProfile.add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 505, 150, 70));

        jButton1.setText("jButton1");
        userProfile.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 160, 80));

        userProfileBg.setIcon(new javax.swing.ImageIcon("D:\\Condominium\\Condominium\\Condominium\\src\\condominium\\user-Profile.png")); // NOI18N
        userProfileBg.setText("jLabel1");
        userProfile.add(userProfileBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(userProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        adRegister.setMinimumSize(new java.awt.Dimension(750, 600));
        adRegister.setPreferredSize(new java.awt.Dimension(750, 600));
        adRegister.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        adRegister.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 160, -1));

        lastname.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 130, 30));

        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        adRegister.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, 80));

        userId.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(userId, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 150, 30));

        usertel.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(usertel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 150, 30));

        usernation.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(usernation, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 110, 30));

        useremerg.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(useremerg, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 150, 30));

        email.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, 180, 30));

        userregis.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(userregis, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 130, 30));

        firstname.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 140, 30));

        usertype.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        usertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ระบุ user", "user", "admin" }));
        usertype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertypeActionPerformed(evt);
            }
        });
        adRegister.add(usertype, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 380, 120, 30));
        adRegister.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 530, 100, 40));
        adRegister.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 100, 40));

        userpass.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        adRegister.add(userpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 150, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("DB Helvethaica X 55 Regular", 0, 24)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        adRegister.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 470, 80));

        registerBg.setIcon(new javax.swing.ImageIcon("D:\\Condominium\\Condominium\\Condominium\\src\\condominium\\register.png")); // NOI18N
        registerBg.setText("jLabel1");
        registerBg.setPreferredSize(new java.awt.Dimension(750, 600));
        adRegister.add(registerBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        getContentPane().add(adRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        Login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setBackground(new Color(0,0,0,0));
        username.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 24)); // NOI18N
        username.setForeground(new java.awt.Color(255, 204, 204));
        username.setBorder(null);
        username.setCaretColor(new java.awt.Color(238, 218, 209));
        username.setSelectedTextColor(new java.awt.Color(238, 218, 209));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        Login.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 260, -1));

        status.setEditable(false);
        status.setFont(new java.awt.Font("DB Helvethaica X 55 Regular", 1, 24)); // NOI18N
        status.setForeground(new java.awt.Color(255, 170, 171));
        status.setBorder(null);
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        Login.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 320, 30));

        password.setFont(new java.awt.Font("DB Helvethaica X 45 Li", 1, 36)); // NOI18N
        password.setForeground(new java.awt.Color(255, 171, 172));
        password.setBorder(null);
        Login.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 552, 260, 30));

        login.setBorder(null);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        Login.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 540, 140, 40));

        Background.setForeground(new java.awt.Color(238, 218, 209));
        Background.setIcon(new javax.swing.ImageIcon("D:\\Condominium\\Condominium\\Condominium\\src\\condominium\\gui-ex.png")); // NOI18N
        Background.setText("jLabel1");
        Background.setPreferredSize(new java.awt.Dimension(750, 600));
        Login.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        getContentPane().add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usertypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usertypeActionPerformed

    private void adregisbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adregisbutActionPerformed
        adIndex.setVisible(false);
        adRegister.setVisible(true);
    }//GEN-LAST:event_adregisbutActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        adIndex.setVisible(true);
        adRegister.setVisible(false);
    }//GEN-LAST:event_homeActionPerformed

    private void register1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register1ActionPerformed
        adIndex.setVisible(false);
        adRegister.setVisible(true);

    }//GEN-LAST:event_register1ActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed

    }//GEN-LAST:event_usernameActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
//        username.setText("user02");
//        password.setText("user");
        String user = username.getText();
        char[] word = password.getPassword();
        String pass = new String(word);
        User u = null;
        if (!(user.equals("") && pass.equals(""))) {
            u = User.findByUser(user, pass);
            if (user.equals(u.getUserName()) && (pass.equals(u.getUserPassword()))) {

                if (u.getUserType().equalsIgnoreCase("Admin")) {
                    adIndex.setVisible(true);
                    Login.setVisible(false);
                    myuser = u;
                }
                if (u.getUserType().equalsIgnoreCase("User")) {
                    userIndex.setVisible(true);
                    Login.setVisible(false);
                    myuser = u;

                    if (myuser != null) {
                        userShow.setText(myuser.getUserName());
                    }
                }

            } else {
                String st = "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง";
                status.setText(st);
            }
        } else {
            String st = "กรุณาระบุชื่อผู้ใช้";
            status.setText(st);
        }

    }//GEN-LAST:event_loginActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        //
    }//GEN-LAST:event_statusActionPerformed

    private void home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home1ActionPerformed
        adIndex.setVisible(true);
        adReport.setVisible(false);
    }//GEN-LAST:event_home1ActionPerformed

    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        // TODO add your handling code here:
        userProfile.setVisible(true);
        userIndex.setVisible(false);
        if (myuser != null) {
            user_fName.setText(myuser.getUserFname());
            user_lName.setText(myuser.getUserLname());
            //user_userId.setText(String.valueOf(myuser.getUserId()));
            user_nation.setText(myuser.getUserNation());
            user_idCard.setText(myuser.getUserIdcard());
            user_address.setText(myuser.getUserAddress());
            user_emergTelNo.setText(myuser.getUserEmergTel());
        }

    }//GEN-LAST:event_profileBtnActionPerformed

    private void user_fNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_fNameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_user_fNameActionPerformed

    private void userShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userShowActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_userShowActionPerformed

    private void user_idCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_idCardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_idCardActionPerformed

    private void reportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBtnActionPerformed
        // TODO add your handling code here:
        userIndex.setVisible(false);
        userReport.setVisible(true);

        if (myuser != null) {

        }
    }//GEN-LAST:event_reportBtnActionPerformed

    private void reportDetailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportDetailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportDetailTFActionPerformed

    private void save_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_reportActionPerformed
        // TODO add your handling code here:
        String reportH = reportHeaderTF.getText();
        String reportD = reportDetailTF.getText();
        String probType = problemTypeCB.getSelectedItem().toString();
        Report rp = null;
        Room r = null;
        Problem p = null;
//        System.out.println(myuser.getUserId());
//        System.out.println(reportH);
//        System.out.println(reportD);
//        System.out.println(probType);
        if (!reportH.equals("") && !reportD.equals("")) {
            r = Room.findRoomIdByUserId(myuser.getUserId());
            p = Problem.findProbIdByprobName(probType);
//            System.out.println(p.getProbId());
//            System.out.println(r.getRoomId());
            boolean insert = Report.insertReoprt(reportH, reportD, p.getProbId(),
                    r.getRoomId());
            if (insert) {
                System.out.println("บันทึกเรียบร้อย");
                submit.setText("บันทึกเรียบร้อย");
            }

            submit.setText("ไม่สามารถบันทึกได้");

        }
    }//GEN-LAST:event_save_reportActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
        userProfile.setVisible(false);
        userIndex.setVisible(true);
    }//GEN-LAST:event_okActionPerformed

    private void cancel_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_reportActionPerformed
        // TODO add your handling code here:
        userReport.setVisible(false);
        userIndex.setVisible(true);
    }//GEN-LAST:event_cancel_reportActionPerformed

    private void userIndex_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIndex_logoutActionPerformed
        Login.setVisible(true);
        userIndex.setVisible(false);
        username.setText("");
        password.setText("");
//        myuser = null;
    }//GEN-LAST:event_userIndex_logoutActionPerformed

    private void userIndex_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIndex_logout1ActionPerformed
        Login.setVisible(true);
        adIndex.setVisible(false);
        username.setText("");
        password.setText("");
    }//GEN-LAST:event_userIndex_logout1ActionPerformed

    private void adreportbutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adreportbutActionPerformed
        adReport.setVisible(true);
        adIndex.setVisible(false);
    }//GEN-LAST:event_adreportbutActionPerformed

    private void cancleConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleConfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancleConfigActionPerformed

    private void configbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configbtnActionPerformed
        adConfig.setVisible(true);
        repTablePane.setVisible(false);
    }//GEN-LAST:event_configbtnActionPerformed

    private void searchReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchReportActionPerformed

    }//GEN-LAST:event_searchReportActionPerformed

    private void configTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configTopicActionPerformed

    }//GEN-LAST:event_configTopicActionPerformed

    private void searchReportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchReportbtnActionPerformed
        int reportSearch = Integer.parseInt(searchReport.getText());
        Report config = Report.configShow(reportSearch);
        configTopic.setText(config.getReportTopic());
        configDetail.setText(config.getReportDetail());
        configRoom.setText(config.getRoom().getRoomNo());
        configUser.setText(config.getRoom().getUser().getUserFname() + " " + config.getRoom().getUser().getUserLname());
        configType.setText(config.getProb().getProbName());
    }//GEN-LAST:event_searchReportbtnActionPerformed

    private void viewStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatusBtnActionPerformed
        // TODO add your handling code here:
        userViewReport.setVisible(true);
        userIndex.setVisible(false);
    }//GEN-LAST:event_viewStatusBtnActionPerformed

    private void viewReport_okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReport_okBtnActionPerformed
        // TODO add your handling code here:
        userViewReport.setVisible(false);
        userIndex.setVisible(true);
    }//GEN-LAST:event_viewReport_okBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Condominium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Condominium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Condominium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Condominium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Condominium().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel Login;
    private javax.swing.JPanel adConfig;
    private javax.swing.JLabel adConfigBg;
    private javax.swing.JPanel adIndex;
    private javax.swing.JPanel adRegister;
    private javax.swing.JPanel adReport;
    private javax.swing.JLabel adReportBg;
    private javax.swing.JLabel adminIndexbg;
    private javax.swing.JButton adregisbut;
    private javax.swing.JButton adreportbut;
    private javax.swing.JButton cancel_report;
    private javax.swing.JButton cancleConfig;
    private javax.swing.JButton clear;
    private javax.swing.JTextField configDetail;
    private javax.swing.JTextField configRoom;
    private javax.swing.JTextField configTopic;
    private javax.swing.JTextField configType;
    private javax.swing.JTextField configUser;
    private javax.swing.JButton configbtn;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton deleteReport;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JButton home;
    private javax.swing.JButton home1;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField lastname;
    private javax.swing.JButton login;
    private javax.swing.JComboBox<String> manEmpbox;
    private javax.swing.JButton ok;
    private javax.swing.JButton okConfig;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel problemType;
    private javax.swing.JComboBox<String> problemTypeCB;
    private javax.swing.JButton profileBtn;
    private javax.swing.JButton register1;
    private javax.swing.JLabel registerBg;
    private javax.swing.JScrollPane repTablePane;
    private javax.swing.JButton reportBtn;
    private javax.swing.JLabel reportDetail;
    private javax.swing.JTextField reportDetailTF;
    private javax.swing.JLabel reportHeader;
    private javax.swing.JTextField reportHeaderTF;
    private javax.swing.JTable reportTable;
    private javax.swing.JButton save;
    private javax.swing.JButton save_report;
    private javax.swing.JTextField searchReport;
    private javax.swing.JButton searchReportbtn;
    private javax.swing.JTextField status;
    private javax.swing.JComboBox<String> statusBox;
    private javax.swing.JTextField submit;
    private javax.swing.JTextField userId;
    private javax.swing.JPanel userIndex;
    private javax.swing.JLabel userIndexBg;
    private javax.swing.JButton userIndex_logout;
    private javax.swing.JButton userIndex_logout1;
    private javax.swing.JPanel userProfile;
    private javax.swing.JLabel userProfileBg;
    private javax.swing.JPanel userReport;
    private javax.swing.JTextField userShow;
    private javax.swing.JPanel userViewReport;
    private javax.swing.JTextField user_address;
    private javax.swing.JTextField user_emergTelNo;
    private javax.swing.JTextField user_fName;
    private javax.swing.JTextField user_idCard;
    private javax.swing.JTextField user_lName;
    private javax.swing.JTextField user_nation;
    private javax.swing.JTextField user_telNo;
    private javax.swing.JTextField useremerg;
    private javax.swing.JTextField username;
    private javax.swing.JTextField usernation;
    private javax.swing.JPasswordField userpass;
    private javax.swing.JTextField userregis;
    private javax.swing.JTextField usertel;
    private javax.swing.JComboBox<String> usertype;
    private javax.swing.JScrollPane viewReportPane;
    private javax.swing.JTable viewReportTB;
    private javax.swing.JButton viewReport_okBtn;
    private javax.swing.JButton viewStatusBtn;
    // End of variables declaration//GEN-END:variables
}
