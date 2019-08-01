/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Janani;

import Sohan.HomePage;
import Sohan.Login;
import Soi.gui2;
import java.awt.Color;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.util.*;

/**
 *
 * @author it15-102560
 */
public class Lecture_Hall extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ppst = null;
    ResultSet rs = null;
    String Hno = "";
    String cap = "";
    String Hyear = "";
    String Hmonth = "";
    String Hdate = "";
    String Hstart = "";
    String Hend = "";
    MethodImplementation mi = new MethodImplementation();

    public Lecture_Hall() {
        initComponents();
        con = DBConnect.connect();
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss"); // format date time
    Calendar cal = Calendar.getInstance(); // get current calendar
    String f = (sdf.format(cal.getTime())); // get current date and time to a string variable 

    public void fillCombo() {
        String sql = "select hall_name from lhall_maintenance";
        try {
            ppst = con.prepareStatement(sql);
            rs = ppst.executeQuery();
            String s = DbUtils.resultSetToNestedList(rs).toString();

            int len = s.length();
            int start = 2;
            int end = 0;
            int num = len / 8;
            System.out.println(num);
            String k;
            hallName.insertItemAt("Select", 0);
            hallName1.insertItemAt("Select", 0);
            hallName.setSelectedIndex(0);
            hallName1.setSelectedIndex(0);
            for (int i = 1; i <= num; i++) {
                end = start + 5;
                k = s.substring(start, end);
                hallName.insertItemAt(k, i);
                hallName1.insertItemAt(k, i);
                start = end + 4;
            }
        } catch (Exception e) {
            System.out.println("cannot display names");
        }
    }

    public void fillCapacity() {
        String sql = "select capacity from lhall_maintenance where hall_name = '" + hallName.getSelectedItem() + "'";
        String cap = mi.ColumnFromDB(sql);
        capa.setText(cap);
    }

    public void Clear() {
        hallName.setSelectedItem("Select");
        capa.setText(null);
        dateChooser.setDate(null);
        start.setSelectedItem("Select");
        end.setSelectedItem("Select");
    }

//    public boolean checkDuplicateBooking() {
//        boolean state = false;
//        String sql1 = "select hall_name from lechall where  hall_name = '" + hallName.getSelectedItem().toString() + "'";
//        String sql2 = "select year from lechall where hall_name = '" + hallName.getSelectedItem().toString() + "'";
//        String sql3 = "select month from lechall where hall_name = '" + hallName.getSelectedItem().toString() + "'";
//        String sql4 = "select date from lechall where hall_name = '" + hallName.getSelectedItem().toString() + "'";
//        String sql5 = "select startTime from lechall where hall_name = '" + hallName.getSelectedItem() + "'";
//
//        String hallname = mi.ColumnFromDB(sql1);
//        String year = mi.ColumnFromDB(sql2);
//        String month = mi.ColumnFromDB(sql3);
//        String date = mi.ColumnFromDB(sql4);
//        String st = mi.ColumnFromDB(sql5);
//        String sh = st.substring(0, 2);//db value
//        String sm = st.substring(3, 5);
//
//        String dateTime = dateChooser.getDate().toString();
//        String Hyear = mi.year(dateTime);
//        Hmonth = mi.monthToCompare(dateTime);
//        Hdate = mi.date(dateTime);
//        String stHr = start.getSelectedItem().toString().substring(0, 2);//user input
//        String stMin = start.getSelectedItem().toString().substring(3, 5); 
//        int strtHr, startMin, dbsh, dbsm =0;
//        strtHr = Integer.parseInt(stHr);
//        startMin = Integer.parseInt(stMin);
//        dbsh = Integer.parseInt(sh);
//        dbsm = Integer.parseInt(sm);
//
//        if (((hallname.equals(hallName.getSelectedItem().toString())) && (year.equals(Hyear)) && (month.equals(Hmonth)) && 
//           (date.equals(Hdate))&&(strtHr == dbsh))||((hallname.equals(hallName.getSelectedItem().toString())) && (year.equals(Hyear)) && (month.equals(Hmonth)) && 
//           (date.equals(Hdate))&&((strtHr > dbsh)&&(strtHr< dbsh+2)))){
//            state = true;
//        } else {
//            state = false;
//            
//        }
//
//        return state;
//    }

    JLabel lab1 = new JLabel("User Name");

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        side_bar = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        capa = new javax.swing.JLabel();
        hallName = new javax.swing.JComboBox();
        start = new javax.swing.JComboBox();
        end = new javax.swing.JComboBox();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        notf2 = new javax.swing.JPanel();
        available = new javax.swing.JButton();
        book = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        viewS = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        hallName1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        top_panel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        main_panel.setBackground(new java.awt.Color(255, 255, 255));
        main_panel.setOpaque(false);
        main_panel.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(67, 70, 75));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Course Details");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Manage Courses");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Course Content");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(67, 70, 75));
        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hall Maintenance", "Lecture Hall", "Practical Hall" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(jLabel10)
                .addGap(113, 113, 113)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel10)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        main_panel.add(jPanel4);
        jPanel4.setBounds(0, 50, 860, 100);

        jPanel5.setBackground(new java.awt.Color(59, 62, 67));
        jPanel5.setLayout(null);

        jButton10.setBackground(new java.awt.Color(12, 173, 183));
        jButton10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("HOME");
        jButton10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10);
        jButton10.setBounds(50, 30, 127, 33);

        main_panel.add(jPanel5);
        jPanel5.setBounds(860, 50, 220, 100);

        side_bar.setBackground(new java.awt.Color(12, 173, 183));

        javax.swing.GroupLayout side_barLayout = new javax.swing.GroupLayout(side_bar);
        side_bar.setLayout(side_barLayout);
        side_barLayout.setHorizontalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        side_barLayout.setVerticalGroup(
            side_barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        main_panel.add(side_bar);
        side_bar.setBounds(860, 150, 220, 510);

        jPanel8.setBackground(new java.awt.Color(52, 53, 57));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        main_panel.add(jPanel8);
        jPanel8.setBounds(-10, 660, 1090, 30);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Duration(To) ");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(40, 270, 120, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 150, 100, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Capacity");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(40, 100, 90, 20);

        capa.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        capa.setForeground(new java.awt.Color(255, 255, 255));
        capa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                capaMouseClicked(evt);
            }
        });
        jPanel2.add(capa);
        capa.setBounds(160, 100, 130, 30);

        hallName.setBackground(new java.awt.Color(0, 153, 153));
        hallName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        hallName.setForeground(new java.awt.Color(255, 255, 255));
        hallName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hallNameItemStateChanged(evt);
            }
        });
        hallName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hallNameMouseClicked(evt);
            }
        });
        hallName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hallNameActionPerformed(evt);
            }
        });
        jPanel2.add(hallName);
        hallName.setBounds(160, 50, 130, 20);

        start.setBackground(new java.awt.Color(0, 153, 153));
        start.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        start.setForeground(new java.awt.Color(255, 255, 255));
        start.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00" }));
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        jPanel2.add(start);
        start.setBounds(160, 210, 130, 26);

        end.setBackground(new java.awt.Color(0, 153, 153));
        end.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        end.setForeground(new java.awt.Color(255, 255, 255));
        end.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18.00", "18:30" }));
        jPanel2.add(end);
        end.setBounds(160, 270, 130, 26);

        dateChooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateChooserMouseClicked(evt);
            }
        });
        jPanel2.add(dateChooser);
        dateChooser.setBounds(160, 150, 130, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Duration (from) ");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(40, 210, 110, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hall Name");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(40, 50, 90, 20);

        notf2.setBackground(new java.awt.Color(102, 51, 0));

        available.setBackground(new java.awt.Color(0, 153, 153));
        available.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        available.setForeground(new java.awt.Color(255, 255, 255));
        available.setText("Search Availability Today ");
        available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                availableActionPerformed(evt);
            }
        });

        book.setBackground(new java.awt.Color(0, 153, 153));
        book.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        book.setForeground(new java.awt.Color(255, 255, 255));
        book.setText("Book");
        book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 153, 153));
        update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(0, 153, 153));
        delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(0, 153, 153));
        reset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        viewS.setBackground(new java.awt.Color(0, 102, 102));
        viewS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        viewS.setForeground(new java.awt.Color(255, 255, 255));
        viewS.setText("View Schedule");
        viewS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Hall Name", "Capacity", "Year", "Month", "Date", "Start Time", "End Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        hallName1.setBackground(new java.awt.Color(0, 153, 153));
        hallName1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hallName1.setForeground(new java.awt.Color(255, 255, 255));
        hallName1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                hallName1ItemStateChanged(evt);
            }
        });
        hallName1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hallName1MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Hall No");

        search.setBackground(new java.awt.Color(0, 153, 153));
        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notf2Layout = new javax.swing.GroupLayout(notf2);
        notf2.setLayout(notf2Layout);
        notf2Layout.setHorizontalGroup(
            notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notf2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewS, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(notf2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(notf2Layout.createSequentialGroup()
                                .addComponent(hallName1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        notf2Layout.setVerticalGroup(
            notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, notf2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(notf2Layout.createSequentialGroup()
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(notf2Layout.createSequentialGroup()
                        .addComponent(book, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(notf2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(notf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hallName1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(available, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );

        jPanel2.add(notf2);
        notf2.setBounds(30, 40, 780, 420);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Janani/Images/lechall.jpg"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 860, 510);

        main_panel.add(jPanel2);
        jPanel2.setBounds(0, 150, 860, 510);

        top_panel.setBackground(new java.awt.Color(52, 53, 57));
        top_panel.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Welcome");
        top_panel.add(jLabel2);
        jLabel2.setBounds(90, 10, 71, 25);

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
        jButton2.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("LOGOUT");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        top_panel.add(jButton2);
        jButton2.setBounds(975, 9, 90, 32);

        btn_back.setBackground(new java.awt.Color(57, 60, 64));
        btn_back.setFont(new java.awt.Font("Leelawadee UI", 0, 16)); // NOI18N
        btn_back.setForeground(new java.awt.Color(204, 204, 204));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sohan/icons/ic_keyboard_arrow_left_white_24dp_1x.png"))); // NOI18N
        btn_back.setBorderPainted(false);
        btn_back.setContentAreaFilled(false);
        btn_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_back.setIconTextGap(10);
        btn_back.setOpaque(true);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        top_panel.add(btn_back);
        btn_back.setBounds(0, 0, 60, 50);

        main_panel.add(top_panel);
        top_panel.setBounds(0, 0, 1080, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main_panel, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1080, 688));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        delete.setEnabled(false);
        update.setEnabled(false);
        fillCombo();
//        notf2.setBackground(new Color(102,51,0,85));
//        hallName.setBackground(new Color(102,51,0,150));
//        hallName1.setBackground(new Color(102,51,0,150));
//        start.setBackground(new Color(102,51,0,150));
//        end.setBackground(new Color(102,51,0,150));
//        book.setBackground(new Color(102,51,0,150));
//        update.setBackground(new Color(102,51,0,150));
//        delete.setBackground(new Color(102,51,0,150));
//        reset.setBackground(new Color(102,51,0,150));
//        viewS.setBackground(new Color(102,51,0,150));
//        search.setBackground(new Color(102,51,0,150));
//        available.setBackground(new Color(102,51,0,150));
    }//GEN-LAST:event_formWindowOpened


    private void hallNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hallNameItemStateChanged

        if (!hallName.getSelectedItem().equals("Select")) {
            fillCapacity();
        } else {
            capa.setText("");
        }
    }//GEN-LAST:event_hallNameItemStateChanged

    private void hallNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hallNameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hallNameMouseClicked

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startActionPerformed

    private void capaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_capaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_capaMouseClicked

    private void dateChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateChooserMouseClicked

    }//GEN-LAST:event_dateChooserMouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        Manager_course a = new Manager_course();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        Course_Details a = new Course_Details();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Student_course s = new Student_course();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked


    private void hallNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hallNameActionPerformed

    }//GEN-LAST:event_hallNameActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        String state = jComboBox1.getSelectedItem().toString();

        if (state.equals("Lecture Hall")) {
            LHall_maintenance h = new LHall_maintenance();
            h.setVisible(true);
            this.dispose();
        } else if (state.equals("Practical Hall")) {
            PHall_maintenance p = new PHall_maintenance();
            p.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        Home h = new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String Hname = hallName1.getSelectedItem().toString();
        if (!Hname.equals("Select")) {
            String sql = "select hall_name as 'Hall Name',capacity as Capacity, year as Year, date as Date, month as Month, startTime as 'Start Time', endTime as 'End Time' from lechall where hall_name ='" + Hname + "'";
            rs = mi.tableLoad(sql);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } else {
            JOptionPane.showMessageDialog(null, "Please select a hall name!");
        }
    }//GEN-LAST:event_searchActionPerformed

    private void hallName1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hallName1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_hallName1MouseClicked

    private void hallName1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_hallName1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_hallName1ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int r = jTable1.getSelectedRow();

        String name = jTable1.getValueAt(r, 0).toString();
        String ca = jTable1.getValueAt(r, 1).toString();
        String yr = jTable1.getValueAt(r, 2).toString();
        String mnth = jTable1.getValueAt(r, 3).toString();
        String dt = jTable1.getValueAt(r, 4).toString();
        String stm = jTable1.getValueAt(r, 5).toString();
        String etm = jTable1.getValueAt(r, 6).toString();

        hallName.setSelectedItem(name);
        capa.setText(ca);
        dateChooser.setDate(null);
        start.setSelectedItem(stm);
        end.setSelectedItem(etm);
        delete.setEnabled(true);
        update.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void viewSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSActionPerformed
        String sql = "select hall_name as 'Hall Name', capacity as Capacity, year as Year, month as Month,date as Date,startTime as 'Start Time', endTime as 'End Time' from lechall";
        rs = mi.tableLoad(sql);
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_viewSActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        Clear();
    }//GEN-LAST:event_resetActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        int r = jTable1.getSelectedRow();
        String yr = jTable1.getValueAt(r, 2).toString();
        String mnth = jTable1.getValueAt(r, 3).toString();
        String dt = jTable1.getValueAt(r, 4).toString();
        int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete?");
        String name = hallName.getSelectedItem().toString();
        if (x == 0) {
            String sql = "delete from lechall where hall_name = '" + name + "' and year =  '"+ yr+"' and month = '"+mnth+"' and date = '"+dt+"' and startTime = '"+start.getSelectedItem().toString()+"' and endTime = '"+end.getSelectedItem().toString()+"'";
            if ((mi.ColumnToDB(sql)) == true) {
                JOptionPane.showMessageDialog(null, "successfully deleted!");
            }
        } else {
            System.out.println("cannot delete");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        Hno = hallName.getSelectedItem().toString();
        Hstart = start.getSelectedItem().toString();
        Hend = end.getSelectedItem().toString();
        String date = dateChooser.getDate().toString();
        String Hyear = date.substring(24, 28);
        Hmonth = mi.monthToDB(date);
        Hdate = date.substring(8, 10);

        int r = jTable1.getSelectedRow();

        String name = jTable1.getValueAt(r, 0).toString();
        String ca = jTable1.getValueAt(r, 1).toString();
        String yr = jTable1.getValueAt(r, 2).toString();
        String mnth = jTable1.getValueAt(r, 3).toString();
        String dt = jTable1.getValueAt(r, 4).toString();
        String stm = jTable1.getValueAt(r, 5).toString();
        
        if (mi.DateValidation(date, Hstart, f) == true) {
            if (!Hno.equals("Select")) {
                int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");
                if (x == 0) {
                    String sql2 = "select hallId from lhall_maintenance where hall_name = '" + name + "'";
                    String id = mi.ColumnFromDB(sql2);
                    String sql = "update lechall set HallID ='" + id + "', hall_name = '"+hallName.getSelectedItem().toString()+"', capacity = '" + capa.getText() + "', year = '" + Hyear + "', month='" + Hmonth + "', date='" + Hdate + "',startTime='" + Hstart + "' , endTime = '"+Hend+"' where HallID ='" + id + "' and year = '" + yr + "' and month='" + mnth + "' and date='" + dt + "' and startTime='" + stm + "'";
                    if ((mi.ColumnToDB(sql)) == true) {
                        JOptionPane.showMessageDialog(null, "Hall booking updated!");
                    } else {
                        System.out.println("cannot update the hall bookings");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a hall no");
            }
        }
        Clear();
    }//GEN-LAST:event_updateActionPerformed

    private void bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookActionPerformed

        String Hname = hallName.getSelectedItem().toString();
        cap = capa.getText();
        Hstart = start.getSelectedItem().toString();
        Hend = end.getSelectedItem().toString();
        String s = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); //values taken from datechooser

        if(mi.HallBookingNullFieldValidation(Hname, Hstart, Hend, s)==true){

            String x = dateChooser.getDate().toString();
            String Hyear = x.substring(24, 28); // get year from the string x
            String Hmon = mi.monthToDB(x);
            String Hdate = x.substring(8, 10);

            if (mi.DateValidation(x, Hstart, f) == true) {
                //            if(checkDuplicateBooking()==false){
                    String sql2 = "select hallId from lhall_maintenance where hall_name = '" + hallName.getSelectedItem() + "'";
                    String id = mi.ColumnFromDB(sql2);
                    String sql = "insert into lechall (HallID, hall_name, capacity, year, month, date, startTime, endTime) values ('" + id + "','" + Hname + "','" + cap + "','" + Hyear + "','" + Hmon + "','" + Hdate + "','" + Hstart + "','" + Hend + "') ";
                    if ((mi.ColumnToDB(sql)) == true) {
                        JOptionPane.showMessageDialog(null, "Hall booked!");
                    } else {
                        JOptionPane.showMessageDialog(null, "data insertion failed!");
                    }
                    //            }
                //            else{
                    //            JOptionPane.showMessageDialog(null,"Sorry! This hall is already booked at this time!");
                    //            }
            }
        }
    }//GEN-LAST:event_bookActionPerformed

    private void availableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_availableActionPerformed
        String yyr = f.substring(0, 4); // get currrent year from the string f
        String mmnth = mi.monthFromIntToString(f);
        String date = f.substring(8, 10);
        String sql = "select hall_name, capacity from lhall_maintenance where hall_name not in ( select hall_name from lechall where year = '"+yyr+"' and month = '"+mmnth+"' and date = '"+date+"')";
        rs = mi.tableLoad(sql);
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_availableActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered

        jButton2.setBackground(new java.awt.Color(5, 150, 160));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited

        jButton2.setBackground(new java.awt.Color(12, 173, 183));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Login l = new Login();
        l.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed

        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_backActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(gui2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gui2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gui2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gui2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lecture_Hall().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton available;
    private javax.swing.JButton book;
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel capa;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox end;
    private javax.swing.JComboBox hallName;
    private javax.swing.JComboBox hallName1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel main_panel;
    private javax.swing.JPanel notf2;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    private javax.swing.JPanel side_bar;
    private javax.swing.JComboBox start;
    private javax.swing.JPanel top_panel;
    private javax.swing.JButton update;
    private javax.swing.JButton viewS;
    // End of variables declaration//GEN-END:variables
}
