/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsoccerscout;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author oOo
 */
public class MatchReport extends javax.swing.JFrame {
    static ArrayList<String> PlayerList = new ArrayList<String>();
    static ArrayList<Integer> Overall = new ArrayList<Integer>();
    static ArrayList<Integer> Defence = new ArrayList<Integer>();
    static ArrayList<Integer> Playmaking = new ArrayList<Integer>();
    static ArrayList<Integer> Transistion = new ArrayList<Integer>();
    static ArrayList<Integer> Attack = new ArrayList<Integer>();
    static ArrayList<Integer> List = new ArrayList<Integer>();
    static ArrayList<String> NumList = new ArrayList<String>();
    
    public void getPlayer(String A){
        PreparedStatement st = null;
        ResultSet rs = null;
        String name = "";
        Connection con = MyConnection.getConnection();
        try{
            String query = "SELECT `name` FROM `playertable` WHERE `num` =" + A;
            st = con.prepareStatement(query);
            rs = st.executeQuery();
           while(rs.next()!=false){
           
            name = rs.getString("name");
            PlayerList.add(name);
        }
        }
        catch(SQLException ex){
        java.util.logging.Logger.getLogger(MatchReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        finally{
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException e){
                    
                }
            }
            if(st!=null){
                try{
                    st.close();
                }
                catch (SQLException e){
                    
                }
            }if(con!=null){
                try{
                    con.close();
                }
                catch (SQLException e){
                    
                }
            }
        }
    }
    public void ListPlayer(){
        for(int i = 0;i<14;i++){
            if(i<11 )
            getPlayer(NumList.get(i));
            
            else{
            if(NumList.get(i).equals("Not Subbed")){
                PlayerList.add("NotSubbed");
            }
            else getPlayer(NumList.get(i));
            }
        }
    }
    
    public void getList(){
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = MyConnection.getConnection();
        try{
           
            String query = "SELECT `P1`,`P2`,`P3`,`P4`,`P5`,`P6`,`P7`,`P8`,`P9`,`P10`,`P11`,`CSubbed1`,`CSubbed2`,`CSubbed3` FROM `matchdatabase` WHERE ID = 1";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            
            while(rs.next()){
               NumList.add((rs.getString("P1")));
               NumList.add(rs.getString("P2"));
               NumList.add((rs.getString("P3")));
               NumList.add(rs.getString("P4"));
               NumList.add((rs.getString("P5")));
               NumList.add((rs.getString("P6")));
               NumList.add((rs.getString("P7")));
               NumList.add((rs.getString("P8")));
               NumList.add((rs.getString("P9")));
               NumList.add((rs.getString("P10")));
               NumList.add((rs.getString("P11")));
               if(rs.getString("CSubbed1").equals("0"))
                {
                    NumList.add("Not Subbed");
                }
               else NumList.add(rs.getString("CSubbed1"));
                if(rs.getString("CSubbed2").equals("0"))
                {
                    NumList.add("Not Subbed");
                } 
               else NumList.add(rs.getString("CSubbed2"));
                if(rs.getString("CSubbed3").equals("0"))
                {
                    NumList.add("Not Subbed");
                } 
                else NumList.add(rs.getString("CSubbed3"));
            }
            
        }
        catch(SQLException e){
                    java.util.logging.Logger.getLogger(MatchReport.class.getName()).log(java.util.logging.Level.SEVERE, null, e);

        }
        finally{
            if(rs!=null){
                try{
                    rs.close();
                }
                catch (SQLException e){
                    
                }
            }
            if(st!=null){
                try{
                    st.close();
                }
                catch (SQLException e){
                    
                }
            }if(con!=null){
                try{
                    con.close();
                }
                catch (SQLException e){
                    
                }
            }
    }
    }

    public void setPanelEnabled(JPanel panel) {
    panel.setEnabled(false);

    Component[] components = panel.getComponents();

    for (Component component : components) {
        if (component instanceof JPanel) {
            setPanelEnabled((JPanel) component);
        }
        component.setEnabled(false);
    }
}
       
    
    
    int SubCount = 0;
    /**
     * Creates new form MatchReport
     */
    public MatchReport() {
        getList();
        ListPlayer();
        initComponents();
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel17 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        label19 = new java.awt.Label();
        Goal = new javax.swing.JTextField();
        label20 = new java.awt.Label();
        GetGoal = new javax.swing.JTextField();
        Yellow = new javax.swing.JTextField();
        Red = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Passing = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelName = new java.awt.Label();
        label14 = new java.awt.Label();
        label15 = new java.awt.Label();
        label16 = new java.awt.Label();
        label17 = new java.awt.Label();
        label18 = new java.awt.Label();
        jPanel4 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        Rating1 = new javax.swing.JTextField();
        Goal1 = new javax.swing.JTextField();
        Assist1 = new javax.swing.JTextField();
        Yellow1 = new javax.swing.JTextField();
        Red1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        Rating2 = new javax.swing.JTextField();
        Goal2 = new javax.swing.JTextField();
        Assist2 = new javax.swing.JTextField();
        Yellow2 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        label3 = new java.awt.Label();
        Rating3 = new javax.swing.JTextField();
        Goal3 = new javax.swing.JTextField();
        Assist3 = new javax.swing.JTextField();
        Yellow3 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        Rating4 = new javax.swing.JTextField();
        Goal4 = new javax.swing.JTextField();
        Assist4 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        Yellow4 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        label5 = new java.awt.Label();
        Rating5 = new javax.swing.JTextField();
        Goal5 = new javax.swing.JTextField();
        Assist5 = new javax.swing.JTextField();
        Yellow5 = new javax.swing.JTextField();
        jTextField29 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        label6 = new java.awt.Label();
        Rating6 = new javax.swing.JTextField();
        Goal6 = new javax.swing.JTextField();
        Assist6 = new javax.swing.JTextField();
        Yellow6 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        label7 = new java.awt.Label();
        Rating7 = new javax.swing.JTextField();
        Goal7 = new javax.swing.JTextField();
        Assist7 = new javax.swing.JTextField();
        Yellow7 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        label8 = new java.awt.Label();
        Rating8 = new javax.swing.JTextField();
        Goal8 = new javax.swing.JTextField();
        Assist8 = new javax.swing.JTextField();
        Yellow8 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        label9 = new java.awt.Label();
        Rating9 = new javax.swing.JTextField();
        Goal9 = new javax.swing.JTextField();
        Assist9 = new javax.swing.JTextField();
        Yellow9 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        label10 = new java.awt.Label();
        Rating10 = new javax.swing.JTextField();
        Goal10 = new javax.swing.JTextField();
        Assist10 = new javax.swing.JTextField();
        Yellow10 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        label11 = new java.awt.Label();
        Rating11 = new javax.swing.JTextField();
        Goal11 = new javax.swing.JTextField();
        Assist11 = new javax.swing.JTextField();
        Yellow11 = new javax.swing.JTextField();
        jTextField64 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        label12 = new java.awt.Label();
        Rating12 = new javax.swing.JTextField();
        Goal12 = new javax.swing.JTextField();
        Assist12 = new javax.swing.JTextField();
        Yellow12 = new javax.swing.JTextField();
        jTextField69 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        label13 = new java.awt.Label();
        Rating13 = new javax.swing.JTextField();
        Goal13 = new javax.swing.JTextField();
        Assist13 = new javax.swing.JTextField();
        Yellow13 = new javax.swing.JTextField();
        jTextField74 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Rating14 = new javax.swing.JTextField();
        Goal14 = new javax.swing.JTextField();
        Assist14 = new javax.swing.JTextField();
        Yellow14 = new javax.swing.JTextField();
        jTextField81 = new javax.swing.JTextField();
        jPanel84 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        labelName5 = new java.awt.Label();
        label93 = new java.awt.Label();
        label94 = new java.awt.Label();
        label95 = new java.awt.Label();
        label96 = new java.awt.Label();
        label97 = new java.awt.Label();
        jPanel86 = new javax.swing.JPanel();
        label98 = new java.awt.Label();
        jTextField355 = new javax.swing.JTextField();
        jTextField356 = new javax.swing.JTextField();
        jTextField357 = new javax.swing.JTextField();
        jTextField358 = new javax.swing.JTextField();
        jTextField359 = new javax.swing.JTextField();
        jPanel87 = new javax.swing.JPanel();
        label99 = new java.awt.Label();
        jTextField360 = new javax.swing.JTextField();
        jTextField361 = new javax.swing.JTextField();
        jTextField362 = new javax.swing.JTextField();
        jTextField363 = new javax.swing.JTextField();
        jTextField364 = new javax.swing.JTextField();
        jPanel88 = new javax.swing.JPanel();
        label100 = new java.awt.Label();
        jTextField365 = new javax.swing.JTextField();
        jTextField366 = new javax.swing.JTextField();
        jTextField367 = new javax.swing.JTextField();
        jTextField368 = new javax.swing.JTextField();
        jTextField369 = new javax.swing.JTextField();
        jPanel89 = new javax.swing.JPanel();
        label101 = new java.awt.Label();
        jTextField370 = new javax.swing.JTextField();
        jTextField371 = new javax.swing.JTextField();
        jTextField372 = new javax.swing.JTextField();
        jTextField373 = new javax.swing.JTextField();
        jTextField374 = new javax.swing.JTextField();
        jPanel90 = new javax.swing.JPanel();
        label102 = new java.awt.Label();
        jTextField375 = new javax.swing.JTextField();
        jTextField376 = new javax.swing.JTextField();
        jTextField377 = new javax.swing.JTextField();
        jTextField378 = new javax.swing.JTextField();
        jTextField379 = new javax.swing.JTextField();
        jPanel91 = new javax.swing.JPanel();
        label103 = new java.awt.Label();
        jTextField380 = new javax.swing.JTextField();
        jTextField381 = new javax.swing.JTextField();
        jTextField382 = new javax.swing.JTextField();
        jTextField383 = new javax.swing.JTextField();
        jTextField384 = new javax.swing.JTextField();
        jPanel92 = new javax.swing.JPanel();
        label104 = new java.awt.Label();
        jTextField385 = new javax.swing.JTextField();
        jTextField386 = new javax.swing.JTextField();
        jTextField387 = new javax.swing.JTextField();
        jTextField388 = new javax.swing.JTextField();
        jTextField389 = new javax.swing.JTextField();
        jPanel93 = new javax.swing.JPanel();
        label105 = new java.awt.Label();
        jTextField390 = new javax.swing.JTextField();
        jTextField391 = new javax.swing.JTextField();
        jTextField392 = new javax.swing.JTextField();
        jTextField393 = new javax.swing.JTextField();
        jTextField394 = new javax.swing.JTextField();
        jPanel94 = new javax.swing.JPanel();
        label106 = new java.awt.Label();
        jTextField395 = new javax.swing.JTextField();
        jTextField396 = new javax.swing.JTextField();
        jTextField397 = new javax.swing.JTextField();
        jTextField398 = new javax.swing.JTextField();
        jTextField399 = new javax.swing.JTextField();
        jPanel95 = new javax.swing.JPanel();
        label107 = new java.awt.Label();
        jTextField400 = new javax.swing.JTextField();
        jTextField401 = new javax.swing.JTextField();
        jTextField402 = new javax.swing.JTextField();
        jTextField403 = new javax.swing.JTextField();
        jTextField404 = new javax.swing.JTextField();
        jPanel96 = new javax.swing.JPanel();
        label108 = new java.awt.Label();
        jTextField405 = new javax.swing.JTextField();
        jTextField406 = new javax.swing.JTextField();
        jTextField407 = new javax.swing.JTextField();
        jTextField408 = new javax.swing.JTextField();
        jTextField409 = new javax.swing.JTextField();
        jPanel97 = new javax.swing.JPanel();
        label109 = new java.awt.Label();
        jTextField410 = new javax.swing.JTextField();
        jTextField411 = new javax.swing.JTextField();
        jTextField412 = new javax.swing.JTextField();
        jTextField413 = new javax.swing.JTextField();
        jTextField414 = new javax.swing.JTextField();
        jPanel98 = new javax.swing.JPanel();
        label110 = new java.awt.Label();
        jTextField415 = new javax.swing.JTextField();
        jTextField416 = new javax.swing.JTextField();
        jTextField417 = new javax.swing.JTextField();
        jTextField418 = new javax.swing.JTextField();
        jTextField419 = new javax.swing.JTextField();
        jPanel99 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField420 = new javax.swing.JTextField();
        jTextField421 = new javax.swing.JTextField();
        jTextField422 = new javax.swing.JTextField();
        jTextField423 = new javax.swing.JTextField();
        jTextField424 = new javax.swing.JTextField();
        jPanel100 = new javax.swing.JPanel();
        jPanel101 = new javax.swing.JPanel();
        labelName6 = new java.awt.Label();
        label111 = new java.awt.Label();
        label112 = new java.awt.Label();
        label113 = new java.awt.Label();
        label114 = new java.awt.Label();
        label115 = new java.awt.Label();
        jPanel102 = new javax.swing.JPanel();
        label116 = new java.awt.Label();
        jTextField425 = new javax.swing.JTextField();
        jTextField426 = new javax.swing.JTextField();
        jTextField427 = new javax.swing.JTextField();
        jTextField428 = new javax.swing.JTextField();
        jTextField429 = new javax.swing.JTextField();
        jPanel103 = new javax.swing.JPanel();
        label117 = new java.awt.Label();
        jTextField430 = new javax.swing.JTextField();
        jTextField431 = new javax.swing.JTextField();
        jTextField432 = new javax.swing.JTextField();
        jTextField433 = new javax.swing.JTextField();
        jTextField434 = new javax.swing.JTextField();
        jPanel104 = new javax.swing.JPanel();
        label118 = new java.awt.Label();
        jTextField435 = new javax.swing.JTextField();
        jTextField436 = new javax.swing.JTextField();
        jTextField437 = new javax.swing.JTextField();
        jTextField438 = new javax.swing.JTextField();
        jTextField439 = new javax.swing.JTextField();
        jPanel105 = new javax.swing.JPanel();
        label119 = new java.awt.Label();
        jTextField440 = new javax.swing.JTextField();
        jTextField441 = new javax.swing.JTextField();
        jTextField442 = new javax.swing.JTextField();
        jTextField443 = new javax.swing.JTextField();
        jTextField444 = new javax.swing.JTextField();
        jPanel106 = new javax.swing.JPanel();
        label120 = new java.awt.Label();
        jTextField445 = new javax.swing.JTextField();
        jTextField446 = new javax.swing.JTextField();
        jTextField447 = new javax.swing.JTextField();
        jTextField448 = new javax.swing.JTextField();
        jTextField449 = new javax.swing.JTextField();
        jPanel107 = new javax.swing.JPanel();
        label121 = new java.awt.Label();
        jTextField450 = new javax.swing.JTextField();
        jTextField451 = new javax.swing.JTextField();
        jTextField452 = new javax.swing.JTextField();
        jTextField453 = new javax.swing.JTextField();
        jTextField454 = new javax.swing.JTextField();
        jPanel108 = new javax.swing.JPanel();
        label122 = new java.awt.Label();
        jTextField455 = new javax.swing.JTextField();
        jTextField456 = new javax.swing.JTextField();
        jTextField457 = new javax.swing.JTextField();
        jTextField458 = new javax.swing.JTextField();
        jTextField459 = new javax.swing.JTextField();
        jPanel109 = new javax.swing.JPanel();
        label123 = new java.awt.Label();
        jTextField460 = new javax.swing.JTextField();
        jTextField461 = new javax.swing.JTextField();
        jTextField462 = new javax.swing.JTextField();
        jTextField463 = new javax.swing.JTextField();
        jTextField464 = new javax.swing.JTextField();
        jPanel110 = new javax.swing.JPanel();
        label124 = new java.awt.Label();
        jTextField465 = new javax.swing.JTextField();
        jTextField466 = new javax.swing.JTextField();
        jTextField467 = new javax.swing.JTextField();
        jTextField468 = new javax.swing.JTextField();
        jTextField469 = new javax.swing.JTextField();
        jPanel111 = new javax.swing.JPanel();
        label125 = new java.awt.Label();
        jTextField470 = new javax.swing.JTextField();
        jTextField471 = new javax.swing.JTextField();
        jTextField472 = new javax.swing.JTextField();
        jTextField473 = new javax.swing.JTextField();
        jTextField474 = new javax.swing.JTextField();
        jPanel112 = new javax.swing.JPanel();
        label126 = new java.awt.Label();
        jTextField475 = new javax.swing.JTextField();
        jTextField476 = new javax.swing.JTextField();
        jTextField477 = new javax.swing.JTextField();
        jTextField478 = new javax.swing.JTextField();
        jTextField479 = new javax.swing.JTextField();
        jPanel113 = new javax.swing.JPanel();
        label127 = new java.awt.Label();
        jTextField480 = new javax.swing.JTextField();
        jTextField481 = new javax.swing.JTextField();
        jTextField482 = new javax.swing.JTextField();
        jTextField483 = new javax.swing.JTextField();
        jTextField484 = new javax.swing.JTextField();
        jPanel114 = new javax.swing.JPanel();
        label128 = new java.awt.Label();
        jTextField485 = new javax.swing.JTextField();
        jTextField486 = new javax.swing.JTextField();
        jTextField487 = new javax.swing.JTextField();
        jTextField488 = new javax.swing.JTextField();
        jTextField489 = new javax.swing.JTextField();
        jPanel115 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField490 = new javax.swing.JTextField();
        jTextField491 = new javax.swing.JTextField();
        jTextField492 = new javax.swing.JTextField();
        jTextField493 = new javax.swing.JTextField();
        jTextField494 = new javax.swing.JTextField();
        jPanel116 = new javax.swing.JPanel();
        jPanel117 = new javax.swing.JPanel();
        labelName7 = new java.awt.Label();
        label129 = new java.awt.Label();
        label130 = new java.awt.Label();
        label131 = new java.awt.Label();
        label132 = new java.awt.Label();
        label133 = new java.awt.Label();
        jPanel118 = new javax.swing.JPanel();
        label134 = new java.awt.Label();
        jTextField495 = new javax.swing.JTextField();
        jTextField496 = new javax.swing.JTextField();
        jTextField497 = new javax.swing.JTextField();
        jTextField498 = new javax.swing.JTextField();
        jTextField499 = new javax.swing.JTextField();
        jPanel119 = new javax.swing.JPanel();
        label135 = new java.awt.Label();
        jTextField500 = new javax.swing.JTextField();
        jTextField501 = new javax.swing.JTextField();
        jTextField502 = new javax.swing.JTextField();
        jTextField503 = new javax.swing.JTextField();
        jTextField504 = new javax.swing.JTextField();
        jPanel120 = new javax.swing.JPanel();
        label136 = new java.awt.Label();
        jTextField505 = new javax.swing.JTextField();
        jTextField506 = new javax.swing.JTextField();
        jTextField507 = new javax.swing.JTextField();
        jTextField508 = new javax.swing.JTextField();
        jTextField509 = new javax.swing.JTextField();
        jPanel121 = new javax.swing.JPanel();
        label137 = new java.awt.Label();
        jTextField510 = new javax.swing.JTextField();
        jTextField511 = new javax.swing.JTextField();
        jTextField512 = new javax.swing.JTextField();
        jTextField513 = new javax.swing.JTextField();
        jTextField514 = new javax.swing.JTextField();
        jPanel122 = new javax.swing.JPanel();
        label138 = new java.awt.Label();
        jTextField515 = new javax.swing.JTextField();
        jTextField516 = new javax.swing.JTextField();
        jTextField517 = new javax.swing.JTextField();
        jTextField518 = new javax.swing.JTextField();
        jTextField519 = new javax.swing.JTextField();
        jPanel123 = new javax.swing.JPanel();
        label139 = new java.awt.Label();
        jTextField520 = new javax.swing.JTextField();
        jTextField521 = new javax.swing.JTextField();
        jTextField522 = new javax.swing.JTextField();
        jTextField523 = new javax.swing.JTextField();
        jTextField524 = new javax.swing.JTextField();
        jPanel124 = new javax.swing.JPanel();
        label140 = new java.awt.Label();
        jTextField525 = new javax.swing.JTextField();
        jTextField526 = new javax.swing.JTextField();
        jTextField527 = new javax.swing.JTextField();
        jTextField528 = new javax.swing.JTextField();
        jTextField529 = new javax.swing.JTextField();
        jPanel125 = new javax.swing.JPanel();
        label141 = new java.awt.Label();
        jTextField530 = new javax.swing.JTextField();
        jTextField531 = new javax.swing.JTextField();
        jTextField532 = new javax.swing.JTextField();
        jTextField533 = new javax.swing.JTextField();
        jTextField534 = new javax.swing.JTextField();
        jPanel126 = new javax.swing.JPanel();
        label142 = new java.awt.Label();
        jTextField535 = new javax.swing.JTextField();
        jTextField536 = new javax.swing.JTextField();
        jTextField537 = new javax.swing.JTextField();
        jTextField538 = new javax.swing.JTextField();
        jTextField539 = new javax.swing.JTextField();
        jPanel127 = new javax.swing.JPanel();
        label143 = new java.awt.Label();
        jTextField540 = new javax.swing.JTextField();
        jTextField541 = new javax.swing.JTextField();
        jTextField542 = new javax.swing.JTextField();
        jTextField543 = new javax.swing.JTextField();
        jTextField544 = new javax.swing.JTextField();
        jPanel128 = new javax.swing.JPanel();
        label144 = new java.awt.Label();
        jTextField545 = new javax.swing.JTextField();
        jTextField546 = new javax.swing.JTextField();
        jTextField547 = new javax.swing.JTextField();
        jTextField548 = new javax.swing.JTextField();
        jTextField549 = new javax.swing.JTextField();
        jPanel129 = new javax.swing.JPanel();
        label145 = new java.awt.Label();
        jTextField550 = new javax.swing.JTextField();
        jTextField551 = new javax.swing.JTextField();
        jTextField552 = new javax.swing.JTextField();
        jTextField553 = new javax.swing.JTextField();
        jTextField554 = new javax.swing.JTextField();
        jPanel130 = new javax.swing.JPanel();
        label146 = new java.awt.Label();
        jTextField555 = new javax.swing.JTextField();
        jTextField556 = new javax.swing.JTextField();
        jTextField557 = new javax.swing.JTextField();
        jTextField558 = new javax.swing.JTextField();
        jTextField559 = new javax.swing.JTextField();
        jPanel131 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField560 = new javax.swing.JTextField();
        jTextField561 = new javax.swing.JTextField();
        jTextField562 = new javax.swing.JTextField();
        jTextField563 = new javax.swing.JTextField();
        jTextField564 = new javax.swing.JTextField();
        jPanel132 = new javax.swing.JPanel();
        jPanel133 = new javax.swing.JPanel();
        labelName8 = new java.awt.Label();
        label147 = new java.awt.Label();
        label148 = new java.awt.Label();
        label149 = new java.awt.Label();
        label150 = new java.awt.Label();
        label151 = new java.awt.Label();
        jPanel134 = new javax.swing.JPanel();
        label152 = new java.awt.Label();
        jTextField565 = new javax.swing.JTextField();
        jTextField566 = new javax.swing.JTextField();
        jTextField567 = new javax.swing.JTextField();
        jTextField568 = new javax.swing.JTextField();
        jTextField569 = new javax.swing.JTextField();
        jPanel135 = new javax.swing.JPanel();
        label153 = new java.awt.Label();
        jTextField570 = new javax.swing.JTextField();
        jTextField571 = new javax.swing.JTextField();
        jTextField572 = new javax.swing.JTextField();
        jTextField573 = new javax.swing.JTextField();
        jTextField574 = new javax.swing.JTextField();
        jPanel136 = new javax.swing.JPanel();
        label154 = new java.awt.Label();
        jTextField575 = new javax.swing.JTextField();
        jTextField576 = new javax.swing.JTextField();
        jTextField577 = new javax.swing.JTextField();
        jTextField578 = new javax.swing.JTextField();
        jTextField579 = new javax.swing.JTextField();
        jPanel137 = new javax.swing.JPanel();
        label155 = new java.awt.Label();
        jTextField580 = new javax.swing.JTextField();
        jTextField581 = new javax.swing.JTextField();
        jTextField582 = new javax.swing.JTextField();
        jTextField583 = new javax.swing.JTextField();
        jTextField584 = new javax.swing.JTextField();
        jPanel138 = new javax.swing.JPanel();
        label156 = new java.awt.Label();
        jTextField585 = new javax.swing.JTextField();
        jTextField586 = new javax.swing.JTextField();
        jTextField587 = new javax.swing.JTextField();
        jTextField588 = new javax.swing.JTextField();
        jTextField589 = new javax.swing.JTextField();
        jPanel139 = new javax.swing.JPanel();
        label157 = new java.awt.Label();
        jTextField590 = new javax.swing.JTextField();
        jTextField591 = new javax.swing.JTextField();
        jTextField592 = new javax.swing.JTextField();
        jTextField593 = new javax.swing.JTextField();
        jTextField594 = new javax.swing.JTextField();
        jPanel140 = new javax.swing.JPanel();
        label158 = new java.awt.Label();
        jTextField595 = new javax.swing.JTextField();
        jTextField596 = new javax.swing.JTextField();
        jTextField597 = new javax.swing.JTextField();
        jTextField598 = new javax.swing.JTextField();
        jTextField599 = new javax.swing.JTextField();
        jPanel141 = new javax.swing.JPanel();
        label159 = new java.awt.Label();
        jTextField600 = new javax.swing.JTextField();
        jTextField601 = new javax.swing.JTextField();
        jTextField602 = new javax.swing.JTextField();
        jTextField603 = new javax.swing.JTextField();
        jTextField604 = new javax.swing.JTextField();
        jPanel142 = new javax.swing.JPanel();
        label160 = new java.awt.Label();
        jTextField605 = new javax.swing.JTextField();
        jTextField606 = new javax.swing.JTextField();
        jTextField607 = new javax.swing.JTextField();
        jTextField608 = new javax.swing.JTextField();
        jTextField609 = new javax.swing.JTextField();
        jPanel143 = new javax.swing.JPanel();
        label161 = new java.awt.Label();
        jTextField610 = new javax.swing.JTextField();
        jTextField611 = new javax.swing.JTextField();
        jTextField612 = new javax.swing.JTextField();
        jTextField613 = new javax.swing.JTextField();
        jTextField614 = new javax.swing.JTextField();
        jPanel144 = new javax.swing.JPanel();
        label162 = new java.awt.Label();
        jTextField615 = new javax.swing.JTextField();
        jTextField616 = new javax.swing.JTextField();
        jTextField617 = new javax.swing.JTextField();
        jTextField618 = new javax.swing.JTextField();
        jTextField619 = new javax.swing.JTextField();
        jPanel145 = new javax.swing.JPanel();
        label163 = new java.awt.Label();
        jTextField620 = new javax.swing.JTextField();
        jTextField621 = new javax.swing.JTextField();
        jTextField622 = new javax.swing.JTextField();
        jTextField623 = new javax.swing.JTextField();
        jTextField624 = new javax.swing.JTextField();
        jPanel146 = new javax.swing.JPanel();
        label164 = new java.awt.Label();
        jTextField625 = new javax.swing.JTextField();
        jTextField626 = new javax.swing.JTextField();
        jTextField627 = new javax.swing.JTextField();
        jTextField628 = new javax.swing.JTextField();
        jTextField629 = new javax.swing.JTextField();
        jPanel147 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField630 = new javax.swing.JTextField();
        jTextField631 = new javax.swing.JTextField();
        jTextField632 = new javax.swing.JTextField();
        jTextField633 = new javax.swing.JTextField();
        jTextField634 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label19.setText("Goal (Your Team)");

        Goal.setText("0");
        Goal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoalActionPerformed(evt);
            }
        });

        label20.setText("Goal (Your Opponent)");

        GetGoal.setText("0");
        GetGoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetGoalActionPerformed(evt);
            }
        });

        Yellow.setText("0");
        Yellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YellowActionPerformed(evt);
            }
        });

        Red.setText("0");

        jLabel2.setText("Yellow/Red");

        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(Goal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GetGoal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(Yellow, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Red, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Goal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(label19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GetGoal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(Yellow, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Red, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        labelName.setAlignment(java.awt.Label.CENTER);
        labelName.setText("Name");

        label14.setText("Rating");

        label15.setText("Goal");

        label16.setText("Assist");

        label17.setText("Yellow");

        label18.setText("Red");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelName, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(label14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        label1.setText(PlayerList.get(0));

        Rating1.setText("0");

        Goal1.setText("0");

        Assist1.setText("0");

        Yellow1.setText("0");
        Yellow1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Yellow1ActionPerformed(evt);
            }
        });

        Red1.setText("0");
        Red1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Red1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(Rating1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Goal1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Assist1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Yellow1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Red1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Assist1)
                        .addComponent(Yellow1)
                        .addComponent(Red1)
                        .addComponent(Rating1)
                        .addComponent(Goal1))))
        );

        label2.setText(PlayerList.get(1));

        Rating2.setText("0");

        Goal2.setText("0");
        Goal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Goal2ActionPerformed(evt);
            }
        });

        Assist2.setText("0");
        Assist2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Assist2ActionPerformed(evt);
            }
        });

        Yellow2.setText("0");
        Yellow2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Yellow2ActionPerformed(evt);
            }
        });

        jTextField14.setText("0");
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(Rating2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Goal2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Assist2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Yellow2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Rating2)
                .addComponent(Goal2)
                .addComponent(Assist2)
                .addComponent(Yellow2)
                .addComponent(jTextField14))
        );

        label3.setText(PlayerList.get(2));

        Rating3.setText("0");

        Goal3.setText("0");

        Assist3.setText("0");

        Yellow3.setText("0");

        jTextField19.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(Rating3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Goal3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Assist3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Yellow3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Rating3)
            .addComponent(Goal3)
            .addComponent(Assist3)
            .addComponent(Yellow3)
            .addComponent(jTextField19)
        );

        label4.setText(PlayerList.get(3));

        Rating4.setText("0");

        Goal4.setText("0");

        Assist4.setText("0");

        jTextField23.setText("0");

        Yellow4.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(Rating4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Goal4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Assist4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Yellow4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Rating4, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(Goal4)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Assist4)
                .addComponent(jTextField23))
            .addComponent(Yellow4)
        );

        label5.setText(PlayerList.get(4));

        Rating5.setText("0");

        Goal5.setText("0");

        Assist5.setText("0");

        Yellow5.setText("0");

        jTextField29.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(Rating5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Goal5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Assist5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Yellow5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Rating5)
            .addComponent(Goal5)
            .addComponent(Assist5)
            .addComponent(Yellow5)
            .addComponent(jTextField29)
        );

        label6.setText(PlayerList.get(5));

        Rating6.setText("0");
        Rating6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rating6ActionPerformed(evt);
            }
        });

        Goal6.setText("0");

        Assist6.setText("0");

        Yellow6.setText("0");

        jTextField34.setText("0");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(Rating6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(Goal6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Assist6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Yellow6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Rating6)
            .addComponent(Goal6)
            .addComponent(Assist6)
            .addComponent(Yellow6)
            .addComponent(jTextField34)
        );

        label7.setText(PlayerList.get(6));

        Rating7.setText("0");
        Rating7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rating7ActionPerformed(evt);
            }
        });

        Goal7.setText("0");

        Assist7.setText("0");

        Yellow7.setText("0");

        jTextField39.setText("0");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(Rating7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(Goal7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Assist7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Yellow7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Rating7)
            .addComponent(Goal7)
            .addComponent(Assist7)
            .addComponent(Yellow7)
            .addComponent(jTextField39)
        );

        label8.setText(PlayerList.get(7));

        Rating8.setText("0");

        Goal8.setText("0");

        Assist8.setText("0");

        Yellow8.setText("0");

        jTextField49.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(Rating8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Goal8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Assist8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Yellow8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Rating8)
            .addComponent(Goal8)
            .addComponent(Assist8)
            .addComponent(Yellow8)
            .addComponent(jTextField49)
        );

        label9.setText(PlayerList.get(8));

        Rating9.setText("0");

        Goal9.setText("0");

        Assist9.setText("0");

        Yellow9.setText("0");

        jTextField54.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(Rating9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Goal9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Assist9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Yellow9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField54, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Rating9)
            .addComponent(Goal9)
            .addComponent(Assist9)
            .addComponent(Yellow9)
            .addComponent(jTextField54)
        );

        label10.setText(PlayerList.get(9));

        Rating10.setText("0");

        Goal10.setText("0");

        Assist10.setText("0");

        Yellow10.setText("0");

        jTextField59.setText("0");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(Rating10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Goal10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Assist10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Yellow10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField59, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Rating10)
            .addComponent(Goal10)
            .addComponent(Assist10)
            .addComponent(Yellow10)
            .addComponent(jTextField59)
        );

        label11.setText(PlayerList.get(10));

        Rating11.setText("0");

        Goal11.setText("0");

        Assist11.setText("0");

        Yellow11.setText("0");

        jTextField64.setText("0");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(Rating11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Goal11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Assist11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Yellow11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Rating11)
            .addComponent(Goal11)
            .addComponent(Assist11)
            .addComponent(Yellow11)
            .addComponent(jTextField64)
        );

        if(SubCount < 1 ) this.setVisible(false);

        label12.setText(PlayerList.get(11));

        Rating12.setText("0");

        Goal12.setText("0");

        Assist12.setText("0");

        Yellow12.setText("0");
        Yellow12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Yellow12ActionPerformed(evt);
            }
        });

        jTextField69.setText("0");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(Rating12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(Goal12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Assist12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Yellow12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField69, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Rating12)
            .addComponent(Goal12)
            .addComponent(Assist12)
            .addComponent(Yellow12)
            .addComponent(jTextField69)
        );

        label13.setText(PlayerList.get(12));

        Rating13.setText("0");

        Goal13.setText("0");

        Assist13.setText("0");

        Yellow13.setText("0");

        jTextField74.setText("0");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(Rating13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Goal13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(Assist13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Yellow13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField74, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Rating13)
            .addComponent(Goal13)
            .addComponent(Assist13)
            .addComponent(Yellow13)
            .addComponent(jTextField74)
        );

        jLabel1.setText(PlayerList.get(13));

        Rating14.setText("0");
        Rating14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rating14ActionPerformed(evt);
            }
        });

        Goal14.setText("0");
        Goal14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Goal14ActionPerformed(evt);
            }
        });

        Assist14.setText("0");
        Assist14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Assist14ActionPerformed(evt);
            }
        });

        Yellow14.setText("0");
        Yellow14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Yellow14ActionPerformed(evt);
            }
        });

        jTextField81.setText("0");
        jTextField81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField81ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(Rating14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(Goal14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Assist14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Yellow14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField81, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Rating14, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Goal14)
            .addComponent(Assist14)
            .addComponent(Yellow14)
            .addComponent(jTextField81)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if(SubCount <1) {

            setPanelEnabled(jPanel15);
        }
        if(SubCount <2) {

            setPanelEnabled(jPanel16);
        }
        if(SubCount <3) {

            setPanelEnabled(jPanel18);
        }

        Passing.addTab("Overall", jPanel2);

        labelName5.setAlignment(java.awt.Label.CENTER);
        labelName5.setText("Name");

        label93.setText("Tackle");

        label94.setText("Tackle Completed");

        label95.setText("Interception");

        label96.setText("Header");

        label97.setText("Foul");

        javax.swing.GroupLayout jPanel85Layout = new javax.swing.GroupLayout(jPanel85);
        jPanel85.setLayout(jPanel85Layout);
        jPanel85Layout.setHorizontalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel85Layout.createSequentialGroup()
                .addComponent(labelName5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label93, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label94, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label95, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label96, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label97, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel85Layout.setVerticalGroup(
            jPanel85Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelName5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(label93, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        label98.setText(PlayerList.get(0));

        jTextField355.setText("0");
        jTextField355.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField355ActionPerformed(evt);
            }
        });

        jTextField356.setText("0");

        jTextField357.setText("0");

        jTextField358.setText("0");
        jTextField358.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField358ActionPerformed(evt);
            }
        });

        jTextField359.setText("0");
        jTextField359.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField359ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel86Layout = new javax.swing.GroupLayout(jPanel86);
        jPanel86.setLayout(jPanel86Layout);
        jPanel86Layout.setHorizontalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addComponent(label98, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField355, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField356, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField357, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField358, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField359, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel86Layout.setVerticalGroup(
            jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel86Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label98, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel86Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField357)
                        .addComponent(jTextField358)
                        .addComponent(jTextField359)
                        .addComponent(jTextField355)
                        .addComponent(jTextField356))))
        );

        label99.setText(PlayerList.get(1));

        jTextField360.setText("0");

        jTextField361.setText("0");
        jTextField361.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField361ActionPerformed(evt);
            }
        });

        jTextField362.setText("0");
        jTextField362.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField362ActionPerformed(evt);
            }
        });

        jTextField363.setText("0");
        jTextField363.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField363ActionPerformed(evt);
            }
        });

        jTextField364.setText("0");
        jTextField364.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField364ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel87Layout = new javax.swing.GroupLayout(jPanel87);
        jPanel87.setLayout(jPanel87Layout);
        jPanel87Layout.setHorizontalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel87Layout.createSequentialGroup()
                .addComponent(label99, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField360, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField361, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField362, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField363, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField364, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel87Layout.setVerticalGroup(
            jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label99, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel87Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField360)
                .addComponent(jTextField361)
                .addComponent(jTextField362)
                .addComponent(jTextField363)
                .addComponent(jTextField364))
        );

        label100.setText(PlayerList.get(2));

        jTextField365.setText("0");

        jTextField366.setText("0");

        jTextField367.setText("0");

        jTextField368.setText("0");

        jTextField369.setText("0");

        javax.swing.GroupLayout jPanel88Layout = new javax.swing.GroupLayout(jPanel88);
        jPanel88.setLayout(jPanel88Layout);
        jPanel88Layout.setHorizontalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel88Layout.createSequentialGroup()
                .addComponent(label100, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jTextField365, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField366, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField367, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField368, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField369, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel88Layout.setVerticalGroup(
            jPanel88Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField365)
            .addComponent(jTextField366)
            .addComponent(jTextField367)
            .addComponent(jTextField368)
            .addComponent(jTextField369)
        );

        label101.setText(PlayerList.get(3));

        jTextField370.setText("0");

        jTextField371.setText("0");

        jTextField372.setText("0");

        jTextField373.setText("0");

        jTextField374.setText("0");

        javax.swing.GroupLayout jPanel89Layout = new javax.swing.GroupLayout(jPanel89);
        jPanel89.setLayout(jPanel89Layout);
        jPanel89Layout.setHorizontalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel89Layout.createSequentialGroup()
                .addComponent(label101, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField370, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField371, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField372, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField374, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jTextField373, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel89Layout.setVerticalGroup(
            jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField370, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(jTextField371)
            .addGroup(jPanel89Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField372)
                .addComponent(jTextField373))
            .addComponent(jTextField374)
        );

        label102.setText(PlayerList.get(4));

        jTextField375.setText("0");

        jTextField376.setText("0");

        jTextField377.setText("0");

        jTextField378.setText("0");

        jTextField379.setText("0");

        javax.swing.GroupLayout jPanel90Layout = new javax.swing.GroupLayout(jPanel90);
        jPanel90.setLayout(jPanel90Layout);
        jPanel90Layout.setHorizontalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel90Layout.createSequentialGroup()
                .addComponent(label102, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jTextField375, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField376, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField377, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField378, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField379, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel90Layout.setVerticalGroup(
            jPanel90Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField375)
            .addComponent(jTextField376)
            .addComponent(jTextField377)
            .addComponent(jTextField378)
            .addComponent(jTextField379)
        );

        label103.setText(PlayerList.get(5));

        jTextField380.setText("0");

        jTextField381.setText("0");

        jTextField382.setText("0");

        jTextField383.setText("0");

        jTextField384.setText("0");

        javax.swing.GroupLayout jPanel91Layout = new javax.swing.GroupLayout(jPanel91);
        jPanel91.setLayout(jPanel91Layout);
        jPanel91Layout.setHorizontalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel91Layout.createSequentialGroup()
                .addComponent(label103, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField380, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField381, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField382, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField383, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField384, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel91Layout.setVerticalGroup(
            jPanel91Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField380)
            .addComponent(jTextField381)
            .addComponent(jTextField382)
            .addComponent(jTextField383)
            .addComponent(jTextField384)
        );

        label104.setText(PlayerList.get(6));

        jTextField385.setText("0");

        jTextField386.setText("0");

        jTextField387.setText("0");

        jTextField388.setText("0");

        jTextField389.setText("0");

        javax.swing.GroupLayout jPanel92Layout = new javax.swing.GroupLayout(jPanel92);
        jPanel92.setLayout(jPanel92Layout);
        jPanel92Layout.setHorizontalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel92Layout.createSequentialGroup()
                .addComponent(label104, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField385, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField386, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField387, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField388, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField389, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel92Layout.setVerticalGroup(
            jPanel92Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField385)
            .addComponent(jTextField386)
            .addComponent(jTextField387)
            .addComponent(jTextField388)
            .addComponent(jTextField389)
        );

        label105.setText(PlayerList.get(7));

        jTextField390.setText("0");

        jTextField391.setText("0");

        jTextField392.setText("0");

        jTextField393.setText("0");

        jTextField394.setText("0");

        javax.swing.GroupLayout jPanel93Layout = new javax.swing.GroupLayout(jPanel93);
        jPanel93.setLayout(jPanel93Layout);
        jPanel93Layout.setHorizontalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel93Layout.createSequentialGroup()
                .addComponent(label105, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField390, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField391, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField392, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField393, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField394, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel93Layout.setVerticalGroup(
            jPanel93Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField390)
            .addComponent(jTextField391)
            .addComponent(jTextField392)
            .addComponent(jTextField393)
            .addComponent(jTextField394)
        );

        label106.setText(PlayerList.get(8));

        jTextField395.setText("0");

        jTextField396.setText("0");

        jTextField397.setText("0");

        jTextField398.setText("0");

        jTextField399.setText("0");

        javax.swing.GroupLayout jPanel94Layout = new javax.swing.GroupLayout(jPanel94);
        jPanel94.setLayout(jPanel94Layout);
        jPanel94Layout.setHorizontalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel94Layout.createSequentialGroup()
                .addComponent(label106, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jTextField395, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField396, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField397, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField398, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField399, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel94Layout.setVerticalGroup(
            jPanel94Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField395)
            .addComponent(jTextField396)
            .addComponent(jTextField397)
            .addComponent(jTextField398)
            .addComponent(jTextField399)
        );

        label107.setText(PlayerList.get(9));

        jTextField400.setText("0");

        jTextField401.setText("0");

        jTextField402.setText("0");

        jTextField403.setText("0");

        jTextField404.setText("0");

        javax.swing.GroupLayout jPanel95Layout = new javax.swing.GroupLayout(jPanel95);
        jPanel95.setLayout(jPanel95Layout);
        jPanel95Layout.setHorizontalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel95Layout.createSequentialGroup()
                .addComponent(label107, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField400, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField401, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField402, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField403, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField404, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel95Layout.setVerticalGroup(
            jPanel95Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField400)
            .addComponent(jTextField401)
            .addComponent(jTextField402)
            .addComponent(jTextField403)
            .addComponent(jTextField404)
        );

        label108.setText(PlayerList.get(10));

        jTextField405.setText("0");

        jTextField406.setText("0");

        jTextField407.setText("0");

        jTextField408.setText("0");

        jTextField409.setText("0");

        javax.swing.GroupLayout jPanel96Layout = new javax.swing.GroupLayout(jPanel96);
        jPanel96.setLayout(jPanel96Layout);
        jPanel96Layout.setHorizontalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel96Layout.createSequentialGroup()
                .addComponent(label108, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField405, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField406, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField407, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField408, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField409, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel96Layout.setVerticalGroup(
            jPanel96Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField405)
            .addComponent(jTextField406)
            .addComponent(jTextField407)
            .addComponent(jTextField408)
            .addComponent(jTextField409)
        );

        if(SubCount < 1 ) this.setVisible(false);

        label109.setText(PlayerList.get(11));

        jTextField410.setText("0");

        jTextField411.setText("0");

        jTextField412.setText("0");

        jTextField413.setText("0");

        jTextField414.setText("0");

        javax.swing.GroupLayout jPanel97Layout = new javax.swing.GroupLayout(jPanel97);
        jPanel97.setLayout(jPanel97Layout);
        jPanel97Layout.setHorizontalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel97Layout.createSequentialGroup()
                .addComponent(label109, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jTextField410, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField411, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField412, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField413, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField414, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel97Layout.setVerticalGroup(
            jPanel97Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField410)
            .addComponent(jTextField411)
            .addComponent(jTextField412)
            .addComponent(jTextField413)
            .addComponent(jTextField414)
        );

        label110.setText(PlayerList.get(12));

        jTextField415.setText("0");

        jTextField416.setText("0");

        jTextField417.setText("0");

        jTextField418.setText("0");

        jTextField419.setText("0");

        javax.swing.GroupLayout jPanel98Layout = new javax.swing.GroupLayout(jPanel98);
        jPanel98.setLayout(jPanel98Layout);
        jPanel98Layout.setHorizontalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel98Layout.createSequentialGroup()
                .addComponent(label110, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jTextField415, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField416, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField417, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField418, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField419, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel98Layout.setVerticalGroup(
            jPanel98Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField415)
            .addComponent(jTextField416)
            .addComponent(jTextField417)
            .addComponent(jTextField418)
            .addComponent(jTextField419)
        );

        jLabel7.setText(PlayerList.get(13));

        jTextField420.setText("0");
        jTextField420.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField420ActionPerformed(evt);
            }
        });

        jTextField421.setText("0");
        jTextField421.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField421ActionPerformed(evt);
            }
        });

        jTextField422.setText("0");
        jTextField422.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField422ActionPerformed(evt);
            }
        });

        jTextField423.setText("0");
        jTextField423.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField423ActionPerformed(evt);
            }
        });

        jTextField424.setText("0");
        jTextField424.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField424ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel99Layout = new javax.swing.GroupLayout(jPanel99);
        jPanel99.setLayout(jPanel99Layout);
        jPanel99Layout.setHorizontalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel99Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField420, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jTextField421, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField422, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField423, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField424, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel99Layout.setVerticalGroup(
            jPanel99Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField420, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jTextField421)
            .addComponent(jTextField422)
            .addComponent(jTextField423)
            .addComponent(jTextField424)
        );

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel85, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel87, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel89, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel90, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel91, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel92, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel93, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel94, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel96, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel97, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel98, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel99, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(jPanel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel88, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel90, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel93, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel94, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel96, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel97, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel98, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel99, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if(SubCount <1) {

            setPanelEnabled(jPanel97);
        }
        if(SubCount <2) {

            setPanelEnabled(jPanel98);
        }
        if(SubCount <3) {

            setPanelEnabled(jPanel99);
        }

        Passing.addTab("Defense", jPanel84);

        labelName6.setAlignment(java.awt.Label.CENTER);
        labelName6.setText("Name");

        label111.setText("Pass");

        label112.setText("Pass Completed");

        label113.setText("Short Pass");

        label114.setText("Long Pass");

        label115.setText("Key Pass");

        javax.swing.GroupLayout jPanel101Layout = new javax.swing.GroupLayout(jPanel101);
        jPanel101.setLayout(jPanel101Layout);
        jPanel101Layout.setHorizontalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel101Layout.createSequentialGroup()
                .addComponent(labelName6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label111, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label112, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label113, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label114, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label115, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel101Layout.setVerticalGroup(
            jPanel101Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelName6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(label111, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label115, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        label116.setText(PlayerList.get(0));

        jTextField425.setText("0");

        jTextField426.setText("0");

        jTextField427.setText("0");

        jTextField428.setText("0");
        jTextField428.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField428ActionPerformed(evt);
            }
        });

        jTextField429.setText("0");
        jTextField429.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField429ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel102Layout = new javax.swing.GroupLayout(jPanel102);
        jPanel102.setLayout(jPanel102Layout);
        jPanel102Layout.setHorizontalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addComponent(label116, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField425, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField426, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField427, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField428, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField429, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel102Layout.setVerticalGroup(
            jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel102Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label116, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel102Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField427)
                        .addComponent(jTextField428)
                        .addComponent(jTextField429)
                        .addComponent(jTextField425)
                        .addComponent(jTextField426))))
        );

        label117.setText(PlayerList.get(1));

        jTextField430.setText("0");

        jTextField431.setText("0");
        jTextField431.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField431ActionPerformed(evt);
            }
        });

        jTextField432.setText("0");
        jTextField432.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField432ActionPerformed(evt);
            }
        });

        jTextField433.setText("0");
        jTextField433.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField433ActionPerformed(evt);
            }
        });

        jTextField434.setText("0");
        jTextField434.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField434ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel103Layout = new javax.swing.GroupLayout(jPanel103);
        jPanel103.setLayout(jPanel103Layout);
        jPanel103Layout.setHorizontalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel103Layout.createSequentialGroup()
                .addComponent(label117, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField430, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField431, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField432, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField433, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField434, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel103Layout.setVerticalGroup(
            jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel103Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField430)
                .addComponent(jTextField431)
                .addComponent(jTextField432)
                .addComponent(jTextField433)
                .addComponent(jTextField434))
        );

        label118.setText(PlayerList.get(2));

        jTextField435.setText("0");

        jTextField436.setText("0");

        jTextField437.setText("0");

        jTextField438.setText("0");

        jTextField439.setText("0");

        javax.swing.GroupLayout jPanel104Layout = new javax.swing.GroupLayout(jPanel104);
        jPanel104.setLayout(jPanel104Layout);
        jPanel104Layout.setHorizontalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel104Layout.createSequentialGroup()
                .addComponent(label118, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jTextField435, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField436, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField437, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField438, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField439, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel104Layout.setVerticalGroup(
            jPanel104Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField435)
            .addComponent(jTextField436)
            .addComponent(jTextField437)
            .addComponent(jTextField438)
            .addComponent(jTextField439)
        );

        label119.setText(PlayerList.get(3));

        jTextField440.setText("0");

        jTextField441.setText("0");

        jTextField442.setText("0");

        jTextField443.setText("0");

        jTextField444.setText("0");

        javax.swing.GroupLayout jPanel105Layout = new javax.swing.GroupLayout(jPanel105);
        jPanel105.setLayout(jPanel105Layout);
        jPanel105Layout.setHorizontalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel105Layout.createSequentialGroup()
                .addComponent(label119, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField440, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField441, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField442, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField444, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jTextField443, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel105Layout.setVerticalGroup(
            jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField440, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(jTextField441)
            .addGroup(jPanel105Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField442)
                .addComponent(jTextField443))
            .addComponent(jTextField444)
        );

        label120.setText(PlayerList.get(4));

        jTextField445.setText("0");

        jTextField446.setText("0");

        jTextField447.setText("0");

        jTextField448.setText("0");

        jTextField449.setText("0");

        javax.swing.GroupLayout jPanel106Layout = new javax.swing.GroupLayout(jPanel106);
        jPanel106.setLayout(jPanel106Layout);
        jPanel106Layout.setHorizontalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel106Layout.createSequentialGroup()
                .addComponent(label120, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jTextField445, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField446, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField447, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField448, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField449, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel106Layout.setVerticalGroup(
            jPanel106Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField445)
            .addComponent(jTextField446)
            .addComponent(jTextField447)
            .addComponent(jTextField448)
            .addComponent(jTextField449)
        );

        label121.setText(PlayerList.get(5));

        jTextField450.setText("0");

        jTextField451.setText("0");

        jTextField452.setText("0");

        jTextField453.setText("0");

        jTextField454.setText("0");

        javax.swing.GroupLayout jPanel107Layout = new javax.swing.GroupLayout(jPanel107);
        jPanel107.setLayout(jPanel107Layout);
        jPanel107Layout.setHorizontalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel107Layout.createSequentialGroup()
                .addComponent(label121, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField450, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField451, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField452, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField453, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField454, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel107Layout.setVerticalGroup(
            jPanel107Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField450)
            .addComponent(jTextField451)
            .addComponent(jTextField452)
            .addComponent(jTextField453)
            .addComponent(jTextField454)
        );

        label122.setText(PlayerList.get(6));

        jTextField455.setText("0");

        jTextField456.setText("0");

        jTextField457.setText("0");

        jTextField458.setText("0");

        jTextField459.setText("0");

        javax.swing.GroupLayout jPanel108Layout = new javax.swing.GroupLayout(jPanel108);
        jPanel108.setLayout(jPanel108Layout);
        jPanel108Layout.setHorizontalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel108Layout.createSequentialGroup()
                .addComponent(label122, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField455, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField456, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField457, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField458, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField459, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel108Layout.setVerticalGroup(
            jPanel108Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField455)
            .addComponent(jTextField456)
            .addComponent(jTextField457)
            .addComponent(jTextField458)
            .addComponent(jTextField459)
        );

        label123.setText(PlayerList.get(7));

        jTextField460.setText("0");

        jTextField461.setText("0");

        jTextField462.setText("0");

        jTextField463.setText("0");

        jTextField464.setText("0");

        javax.swing.GroupLayout jPanel109Layout = new javax.swing.GroupLayout(jPanel109);
        jPanel109.setLayout(jPanel109Layout);
        jPanel109Layout.setHorizontalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel109Layout.createSequentialGroup()
                .addComponent(label123, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField460, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField461, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField462, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField463, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField464, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel109Layout.setVerticalGroup(
            jPanel109Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField460)
            .addComponent(jTextField461)
            .addComponent(jTextField462)
            .addComponent(jTextField463)
            .addComponent(jTextField464)
        );

        label124.setText(PlayerList.get(8));

        jTextField465.setText("0");

        jTextField466.setText("0");

        jTextField467.setText("0");

        jTextField468.setText("0");

        jTextField469.setText("0");

        javax.swing.GroupLayout jPanel110Layout = new javax.swing.GroupLayout(jPanel110);
        jPanel110.setLayout(jPanel110Layout);
        jPanel110Layout.setHorizontalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel110Layout.createSequentialGroup()
                .addComponent(label124, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jTextField465, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField466, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField467, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField468, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField469, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel110Layout.setVerticalGroup(
            jPanel110Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField465)
            .addComponent(jTextField466)
            .addComponent(jTextField467)
            .addComponent(jTextField468)
            .addComponent(jTextField469)
        );

        label125.setText(PlayerList.get(9));

        jTextField470.setText("0");

        jTextField471.setText("0");

        jTextField472.setText("0");

        jTextField473.setText("0");

        jTextField474.setText("0");

        javax.swing.GroupLayout jPanel111Layout = new javax.swing.GroupLayout(jPanel111);
        jPanel111.setLayout(jPanel111Layout);
        jPanel111Layout.setHorizontalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel111Layout.createSequentialGroup()
                .addComponent(label125, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField470, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField471, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField472, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField473, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField474, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel111Layout.setVerticalGroup(
            jPanel111Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField470)
            .addComponent(jTextField471)
            .addComponent(jTextField472)
            .addComponent(jTextField473)
            .addComponent(jTextField474)
        );

        label126.setText(PlayerList.get(10));

        jTextField475.setText("0");

        jTextField476.setText("0");

        jTextField477.setText("0");

        jTextField478.setText("0");

        jTextField479.setText("0");

        javax.swing.GroupLayout jPanel112Layout = new javax.swing.GroupLayout(jPanel112);
        jPanel112.setLayout(jPanel112Layout);
        jPanel112Layout.setHorizontalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel112Layout.createSequentialGroup()
                .addComponent(label126, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField475, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField476, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField477, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField478, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField479, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel112Layout.setVerticalGroup(
            jPanel112Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField475)
            .addComponent(jTextField476)
            .addComponent(jTextField477)
            .addComponent(jTextField478)
            .addComponent(jTextField479)
        );

        if(SubCount < 1 ) this.setVisible(false);

        label127.setText(PlayerList.get(11));

        jTextField480.setText("0");

        jTextField481.setText("0");

        jTextField482.setText("0");

        jTextField483.setText("0");

        jTextField484.setText("0");

        javax.swing.GroupLayout jPanel113Layout = new javax.swing.GroupLayout(jPanel113);
        jPanel113.setLayout(jPanel113Layout);
        jPanel113Layout.setHorizontalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel113Layout.createSequentialGroup()
                .addComponent(label127, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jTextField480, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField481, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField482, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField483, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField484, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel113Layout.setVerticalGroup(
            jPanel113Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField480)
            .addComponent(jTextField481)
            .addComponent(jTextField482)
            .addComponent(jTextField483)
            .addComponent(jTextField484)
        );

        label128.setText(PlayerList.get(12));

        jTextField485.setText("0");

        jTextField486.setText("0");

        jTextField487.setText("0");

        jTextField488.setText("0");

        jTextField489.setText("0");

        javax.swing.GroupLayout jPanel114Layout = new javax.swing.GroupLayout(jPanel114);
        jPanel114.setLayout(jPanel114Layout);
        jPanel114Layout.setHorizontalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel114Layout.createSequentialGroup()
                .addComponent(label128, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jTextField485, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField486, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField487, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField488, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField489, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel114Layout.setVerticalGroup(
            jPanel114Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label128, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField485)
            .addComponent(jTextField486)
            .addComponent(jTextField487)
            .addComponent(jTextField488)
            .addComponent(jTextField489)
        );

        jLabel8.setText(PlayerList.get(13));

        jTextField490.setText("0");
        jTextField490.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField490ActionPerformed(evt);
            }
        });

        jTextField491.setText("0");
        jTextField491.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField491ActionPerformed(evt);
            }
        });

        jTextField492.setText("0");
        jTextField492.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField492ActionPerformed(evt);
            }
        });

        jTextField493.setText("0");
        jTextField493.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField493ActionPerformed(evt);
            }
        });

        jTextField494.setText("0");
        jTextField494.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField494ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel115Layout = new javax.swing.GroupLayout(jPanel115);
        jPanel115.setLayout(jPanel115Layout);
        jPanel115Layout.setHorizontalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel115Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField490, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jTextField491, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField492, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField493, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField494, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel115Layout.setVerticalGroup(
            jPanel115Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField490, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jTextField491)
            .addComponent(jTextField492)
            .addComponent(jTextField493)
            .addComponent(jTextField494)
        );

        javax.swing.GroupLayout jPanel100Layout = new javax.swing.GroupLayout(jPanel100);
        jPanel100.setLayout(jPanel100Layout);
        jPanel100Layout.setHorizontalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel101, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel102, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel103, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel106, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel108, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel109, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel111, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel114, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel104, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel115, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel100Layout.setVerticalGroup(
            jPanel100Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel100Layout.createSequentialGroup()
                .addComponent(jPanel101, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel102, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel103, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel104, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel105, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel108, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel115, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if(SubCount <1) {

            setPanelEnabled(jPanel113);
        }
        if(SubCount <2) {

            setPanelEnabled(jPanel114);
        }
        if(SubCount <3) {

            setPanelEnabled(jPanel115);
        }

        Passing.addTab("Passing", jPanel100);

        labelName7.setAlignment(java.awt.Label.CENTER);
        labelName7.setText("Name");

        label129.setText("Dribble");

        label130.setText("Dribble Completed");

        label131.setText("Cross");

        label132.setText("Cross Completed");

        label133.setText("Ball Lost");

        javax.swing.GroupLayout jPanel117Layout = new javax.swing.GroupLayout(jPanel117);
        jPanel117.setLayout(jPanel117Layout);
        jPanel117Layout.setHorizontalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel117Layout.createSequentialGroup()
                .addComponent(labelName7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label129, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label130, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label131, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label132, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label133, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel117Layout.setVerticalGroup(
            jPanel117Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelName7, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(label129, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label130, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label131, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        label134.setText(PlayerList.get(0));

        jTextField495.setText("0");

        jTextField496.setText("0");

        jTextField497.setText("0");

        jTextField498.setText("0");
        jTextField498.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField498ActionPerformed(evt);
            }
        });

        jTextField499.setText("0");
        jTextField499.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField499ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel118Layout = new javax.swing.GroupLayout(jPanel118);
        jPanel118.setLayout(jPanel118Layout);
        jPanel118Layout.setHorizontalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addComponent(label134, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField495, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField496, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField497, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField498, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField499, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel118Layout.setVerticalGroup(
            jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel118Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label134, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel118Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField497)
                        .addComponent(jTextField498)
                        .addComponent(jTextField499)
                        .addComponent(jTextField495)
                        .addComponent(jTextField496))))
        );

        label135.setText(PlayerList.get(1));

        jTextField500.setText("0");

        jTextField501.setText("0");
        jTextField501.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField501ActionPerformed(evt);
            }
        });

        jTextField502.setText("0");
        jTextField502.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField502ActionPerformed(evt);
            }
        });

        jTextField503.setText("0");
        jTextField503.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField503ActionPerformed(evt);
            }
        });

        jTextField504.setText("0");
        jTextField504.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField504ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel119Layout = new javax.swing.GroupLayout(jPanel119);
        jPanel119.setLayout(jPanel119Layout);
        jPanel119Layout.setHorizontalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel119Layout.createSequentialGroup()
                .addComponent(label135, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField500, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField501, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField502, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField503, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField504, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel119Layout.setVerticalGroup(
            jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel119Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField500)
                .addComponent(jTextField501)
                .addComponent(jTextField502)
                .addComponent(jTextField503)
                .addComponent(jTextField504))
        );

        label136.setText(PlayerList.get(2));

        jTextField505.setText("0");

        jTextField506.setText("0");

        jTextField507.setText("0");

        jTextField508.setText("0");

        jTextField509.setText("0");

        javax.swing.GroupLayout jPanel120Layout = new javax.swing.GroupLayout(jPanel120);
        jPanel120.setLayout(jPanel120Layout);
        jPanel120Layout.setHorizontalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel120Layout.createSequentialGroup()
                .addComponent(label136, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jTextField505, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField506, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField507, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField508, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField509, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel120Layout.setVerticalGroup(
            jPanel120Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField505)
            .addComponent(jTextField506)
            .addComponent(jTextField507)
            .addComponent(jTextField508)
            .addComponent(jTextField509)
        );

        label137.setText(PlayerList.get(3));

        jTextField510.setText("0");

        jTextField511.setText("0");

        jTextField512.setText("0");

        jTextField513.setText("0");

        jTextField514.setText("0");

        javax.swing.GroupLayout jPanel121Layout = new javax.swing.GroupLayout(jPanel121);
        jPanel121.setLayout(jPanel121Layout);
        jPanel121Layout.setHorizontalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel121Layout.createSequentialGroup()
                .addComponent(label137, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField510, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField511, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField512, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField514, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jTextField513, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel121Layout.setVerticalGroup(
            jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField510, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(jTextField511)
            .addGroup(jPanel121Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField512)
                .addComponent(jTextField513))
            .addComponent(jTextField514)
        );

        label138.setText(PlayerList.get(4));

        jTextField515.setText("0");

        jTextField516.setText("0");

        jTextField517.setText("0");

        jTextField518.setText("0");

        jTextField519.setText("0");

        javax.swing.GroupLayout jPanel122Layout = new javax.swing.GroupLayout(jPanel122);
        jPanel122.setLayout(jPanel122Layout);
        jPanel122Layout.setHorizontalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel122Layout.createSequentialGroup()
                .addComponent(label138, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jTextField515, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField516, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField517, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField518, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField519, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel122Layout.setVerticalGroup(
            jPanel122Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField515)
            .addComponent(jTextField516)
            .addComponent(jTextField517)
            .addComponent(jTextField518)
            .addComponent(jTextField519)
        );

        label139.setText(PlayerList.get(5));

        jTextField520.setText("0");

        jTextField521.setText("0");

        jTextField522.setText("0");

        jTextField523.setText("0");

        jTextField524.setText("0");

        javax.swing.GroupLayout jPanel123Layout = new javax.swing.GroupLayout(jPanel123);
        jPanel123.setLayout(jPanel123Layout);
        jPanel123Layout.setHorizontalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel123Layout.createSequentialGroup()
                .addComponent(label139, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField520, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField521, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField522, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField523, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField524, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel123Layout.setVerticalGroup(
            jPanel123Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField520)
            .addComponent(jTextField521)
            .addComponent(jTextField522)
            .addComponent(jTextField523)
            .addComponent(jTextField524)
        );

        label140.setText(PlayerList.get(6));

        jTextField525.setText("0");

        jTextField526.setText("0");

        jTextField527.setText("0");

        jTextField528.setText("0");

        jTextField529.setText("0");

        javax.swing.GroupLayout jPanel124Layout = new javax.swing.GroupLayout(jPanel124);
        jPanel124.setLayout(jPanel124Layout);
        jPanel124Layout.setHorizontalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel124Layout.createSequentialGroup()
                .addComponent(label140, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField525, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField526, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField527, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField528, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField529, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel124Layout.setVerticalGroup(
            jPanel124Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField525)
            .addComponent(jTextField526)
            .addComponent(jTextField527)
            .addComponent(jTextField528)
            .addComponent(jTextField529)
        );

        label141.setText(PlayerList.get(7));

        jTextField530.setText("0");

        jTextField531.setText("0");

        jTextField532.setText("0");

        jTextField533.setText("0");

        jTextField534.setText("0");

        javax.swing.GroupLayout jPanel125Layout = new javax.swing.GroupLayout(jPanel125);
        jPanel125.setLayout(jPanel125Layout);
        jPanel125Layout.setHorizontalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel125Layout.createSequentialGroup()
                .addComponent(label141, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField530, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField531, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField532, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField533, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField534, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel125Layout.setVerticalGroup(
            jPanel125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField530)
            .addComponent(jTextField531)
            .addComponent(jTextField532)
            .addComponent(jTextField533)
            .addComponent(jTextField534)
        );

        label142.setText(PlayerList.get(8));

        jTextField535.setText("0");

        jTextField536.setText("0");

        jTextField537.setText("0");

        jTextField538.setText("0");

        jTextField539.setText("0");

        javax.swing.GroupLayout jPanel126Layout = new javax.swing.GroupLayout(jPanel126);
        jPanel126.setLayout(jPanel126Layout);
        jPanel126Layout.setHorizontalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel126Layout.createSequentialGroup()
                .addComponent(label142, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jTextField535, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField536, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField537, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField538, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField539, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel126Layout.setVerticalGroup(
            jPanel126Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField535)
            .addComponent(jTextField536)
            .addComponent(jTextField537)
            .addComponent(jTextField538)
            .addComponent(jTextField539)
        );

        label143.setText(PlayerList.get(9));

        jTextField540.setText("0");

        jTextField541.setText("0");

        jTextField542.setText("0");

        jTextField543.setText("0");

        jTextField544.setText("0");

        javax.swing.GroupLayout jPanel127Layout = new javax.swing.GroupLayout(jPanel127);
        jPanel127.setLayout(jPanel127Layout);
        jPanel127Layout.setHorizontalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel127Layout.createSequentialGroup()
                .addComponent(label143, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField540, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField541, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField542, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField543, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField544, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel127Layout.setVerticalGroup(
            jPanel127Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField540)
            .addComponent(jTextField541)
            .addComponent(jTextField542)
            .addComponent(jTextField543)
            .addComponent(jTextField544)
        );

        label144.setText(PlayerList.get(10));

        jTextField545.setText("0");

        jTextField546.setText("0");

        jTextField547.setText("0");

        jTextField548.setText("0");

        jTextField549.setText("0");

        javax.swing.GroupLayout jPanel128Layout = new javax.swing.GroupLayout(jPanel128);
        jPanel128.setLayout(jPanel128Layout);
        jPanel128Layout.setHorizontalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel128Layout.createSequentialGroup()
                .addComponent(label144, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField545, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField546, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField547, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField548, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField549, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel128Layout.setVerticalGroup(
            jPanel128Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField545)
            .addComponent(jTextField546)
            .addComponent(jTextField547)
            .addComponent(jTextField548)
            .addComponent(jTextField549)
        );

        if(SubCount < 1 ) this.setVisible(false);

        label145.setText(PlayerList.get(11));

        jTextField550.setText("0");

        jTextField551.setText("0");

        jTextField552.setText("0");

        jTextField553.setText("0");

        jTextField554.setText("0");

        javax.swing.GroupLayout jPanel129Layout = new javax.swing.GroupLayout(jPanel129);
        jPanel129.setLayout(jPanel129Layout);
        jPanel129Layout.setHorizontalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel129Layout.createSequentialGroup()
                .addComponent(label145, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jTextField550, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField551, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField552, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField553, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField554, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel129Layout.setVerticalGroup(
            jPanel129Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField550)
            .addComponent(jTextField551)
            .addComponent(jTextField552)
            .addComponent(jTextField553)
            .addComponent(jTextField554)
        );

        label146.setText(PlayerList.get(12));

        jTextField555.setText("0");

        jTextField556.setText("0");

        jTextField557.setText("0");

        jTextField558.setText("0");

        jTextField559.setText("0");

        javax.swing.GroupLayout jPanel130Layout = new javax.swing.GroupLayout(jPanel130);
        jPanel130.setLayout(jPanel130Layout);
        jPanel130Layout.setHorizontalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel130Layout.createSequentialGroup()
                .addComponent(label146, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jTextField555, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField556, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField557, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField558, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField559, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel130Layout.setVerticalGroup(
            jPanel130Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField555)
            .addComponent(jTextField556)
            .addComponent(jTextField557)
            .addComponent(jTextField558)
            .addComponent(jTextField559)
        );

        jLabel9.setText(PlayerList.get(13));

        jTextField560.setText("0");
        jTextField560.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField560ActionPerformed(evt);
            }
        });

        jTextField561.setText("0");
        jTextField561.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField561ActionPerformed(evt);
            }
        });

        jTextField562.setText("0");
        jTextField562.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField562ActionPerformed(evt);
            }
        });

        jTextField563.setText("0");
        jTextField563.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField563ActionPerformed(evt);
            }
        });

        jTextField564.setText("0");
        jTextField564.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField564ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel131Layout = new javax.swing.GroupLayout(jPanel131);
        jPanel131.setLayout(jPanel131Layout);
        jPanel131Layout.setHorizontalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel131Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField560, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jTextField561, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField562, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField563, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField564, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel131Layout.setVerticalGroup(
            jPanel131Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField560, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jTextField561)
            .addComponent(jTextField562)
            .addComponent(jTextField563)
            .addComponent(jTextField564)
        );

        javax.swing.GroupLayout jPanel116Layout = new javax.swing.GroupLayout(jPanel116);
        jPanel116.setLayout(jPanel116Layout);
        jPanel116Layout.setHorizontalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel118, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel121, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel124, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel126, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel127, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel128, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel129, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel130, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel120, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel131, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel116Layout.setVerticalGroup(
            jPanel116Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel116Layout.createSequentialGroup()
                .addComponent(jPanel117, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel118, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel119, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel120, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel121, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel122, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel123, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel124, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel126, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel127, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel128, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel129, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel130, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel131, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if(SubCount <1) {

            setPanelEnabled(jPanel129);
        }
        if(SubCount <2) {

            setPanelEnabled(jPanel130);
        }
        if(SubCount <3) {

            setPanelEnabled(jPanel131);
        }

        Passing.addTab("Transistion", jPanel116);

        labelName8.setAlignment(java.awt.Label.CENTER);
        labelName8.setText("Name");

        label147.setText("Shot");

        label148.setText("Shot on Target");

        label149.setText("Long Shot");

        label150.setText("Header");

        label151.setText("FK");

        javax.swing.GroupLayout jPanel133Layout = new javax.swing.GroupLayout(jPanel133);
        jPanel133.setLayout(jPanel133Layout);
        jPanel133Layout.setHorizontalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel133Layout.createSequentialGroup()
                .addComponent(labelName8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label147, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label148, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label149, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label150, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label151, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel133Layout.setVerticalGroup(
            jPanel133Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelName8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(label147, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label148, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label149, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label150, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label151, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        label152.setText(PlayerList.get(0));

        jTextField565.setText("0");

        jTextField566.setText("0");

        jTextField567.setText("0");

        jTextField568.setText("0");
        jTextField568.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField568ActionPerformed(evt);
            }
        });

        jTextField569.setText("0");
        jTextField569.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField569ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel134Layout = new javax.swing.GroupLayout(jPanel134);
        jPanel134.setLayout(jPanel134Layout);
        jPanel134Layout.setHorizontalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addComponent(label152, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField565, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField566, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField567, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField568, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField569, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel134Layout.setVerticalGroup(
            jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel134Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label152, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel134Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField567)
                        .addComponent(jTextField568)
                        .addComponent(jTextField569)
                        .addComponent(jTextField565)
                        .addComponent(jTextField566))))
        );

        label153.setText(PlayerList.get(1));

        jTextField570.setText("0");

        jTextField571.setText("0");
        jTextField571.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField571ActionPerformed(evt);
            }
        });

        jTextField572.setText("0");
        jTextField572.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField572ActionPerformed(evt);
            }
        });

        jTextField573.setText("0");
        jTextField573.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField573ActionPerformed(evt);
            }
        });

        jTextField574.setText("0");
        jTextField574.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField574ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel135Layout = new javax.swing.GroupLayout(jPanel135);
        jPanel135.setLayout(jPanel135Layout);
        jPanel135Layout.setHorizontalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel135Layout.createSequentialGroup()
                .addComponent(label153, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField570, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField571, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField572, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField573, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField574, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel135Layout.setVerticalGroup(
            jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label153, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel135Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField570)
                .addComponent(jTextField571)
                .addComponent(jTextField572)
                .addComponent(jTextField573)
                .addComponent(jTextField574))
        );

        label154.setText(PlayerList.get(2));

        jTextField575.setText("0");

        jTextField576.setText("0");

        jTextField577.setText("0");

        jTextField578.setText("0");

        jTextField579.setText("0");

        javax.swing.GroupLayout jPanel136Layout = new javax.swing.GroupLayout(jPanel136);
        jPanel136.setLayout(jPanel136Layout);
        jPanel136Layout.setHorizontalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel136Layout.createSequentialGroup()
                .addComponent(label154, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jTextField575, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField576, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField577, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField578, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField579, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel136Layout.setVerticalGroup(
            jPanel136Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label154, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField575)
            .addComponent(jTextField576)
            .addComponent(jTextField577)
            .addComponent(jTextField578)
            .addComponent(jTextField579)
        );

        label155.setText(PlayerList.get(3));

        jTextField580.setText("0");

        jTextField581.setText("0");

        jTextField582.setText("0");

        jTextField583.setText("0");

        jTextField584.setText("0");

        javax.swing.GroupLayout jPanel137Layout = new javax.swing.GroupLayout(jPanel137);
        jPanel137.setLayout(jPanel137Layout);
        jPanel137Layout.setHorizontalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel137Layout.createSequentialGroup()
                .addComponent(label155, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField580, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField581, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField582, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField584, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jTextField583, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel137Layout.setVerticalGroup(
            jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label155, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField580, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
            .addComponent(jTextField581)
            .addGroup(jPanel137Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField582)
                .addComponent(jTextField583))
            .addComponent(jTextField584)
        );

        label156.setText(PlayerList.get(4));

        jTextField585.setText("0");

        jTextField586.setText("0");

        jTextField587.setText("0");

        jTextField588.setText("0");

        jTextField589.setText("0");

        javax.swing.GroupLayout jPanel138Layout = new javax.swing.GroupLayout(jPanel138);
        jPanel138.setLayout(jPanel138Layout);
        jPanel138Layout.setHorizontalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel138Layout.createSequentialGroup()
                .addComponent(label156, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jTextField585, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField586, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField587, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField588, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField589, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel138Layout.setVerticalGroup(
            jPanel138Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label156, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField585)
            .addComponent(jTextField586)
            .addComponent(jTextField587)
            .addComponent(jTextField588)
            .addComponent(jTextField589)
        );

        label157.setText(PlayerList.get(5));

        jTextField590.setText("0");

        jTextField591.setText("0");

        jTextField592.setText("0");

        jTextField593.setText("0");

        jTextField594.setText("0");

        javax.swing.GroupLayout jPanel139Layout = new javax.swing.GroupLayout(jPanel139);
        jPanel139.setLayout(jPanel139Layout);
        jPanel139Layout.setHorizontalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel139Layout.createSequentialGroup()
                .addComponent(label157, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField590, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jTextField591, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField592, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField593, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField594, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel139Layout.setVerticalGroup(
            jPanel139Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label157, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField590)
            .addComponent(jTextField591)
            .addComponent(jTextField592)
            .addComponent(jTextField593)
            .addComponent(jTextField594)
        );

        label158.setText(PlayerList.get(6));

        jTextField595.setText("0");

        jTextField596.setText("0");

        jTextField597.setText("0");

        jTextField598.setText("0");

        jTextField599.setText("0");

        javax.swing.GroupLayout jPanel140Layout = new javax.swing.GroupLayout(jPanel140);
        jPanel140.setLayout(jPanel140Layout);
        jPanel140Layout.setHorizontalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel140Layout.createSequentialGroup()
                .addComponent(label158, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jTextField595, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jTextField596, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField597, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField598, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField599, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel140Layout.setVerticalGroup(
            jPanel140Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label158, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField595)
            .addComponent(jTextField596)
            .addComponent(jTextField597)
            .addComponent(jTextField598)
            .addComponent(jTextField599)
        );

        label159.setText(PlayerList.get(7));

        jTextField600.setText("0");

        jTextField601.setText("0");

        jTextField602.setText("0");

        jTextField603.setText("0");

        jTextField604.setText("0");

        javax.swing.GroupLayout jPanel141Layout = new javax.swing.GroupLayout(jPanel141);
        jPanel141.setLayout(jPanel141Layout);
        jPanel141Layout.setHorizontalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel141Layout.createSequentialGroup()
                .addComponent(label159, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jTextField600, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField601, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField602, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField603, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField604, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel141Layout.setVerticalGroup(
            jPanel141Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label159, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField600)
            .addComponent(jTextField601)
            .addComponent(jTextField602)
            .addComponent(jTextField603)
            .addComponent(jTextField604)
        );

        label160.setText(PlayerList.get(8));

        jTextField605.setText("0");

        jTextField606.setText("0");

        jTextField607.setText("0");

        jTextField608.setText("0");

        jTextField609.setText("0");

        javax.swing.GroupLayout jPanel142Layout = new javax.swing.GroupLayout(jPanel142);
        jPanel142.setLayout(jPanel142Layout);
        jPanel142Layout.setHorizontalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel142Layout.createSequentialGroup()
                .addComponent(label160, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jTextField605, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField606, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField607, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField608, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField609, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel142Layout.setVerticalGroup(
            jPanel142Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label160, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField605)
            .addComponent(jTextField606)
            .addComponent(jTextField607)
            .addComponent(jTextField608)
            .addComponent(jTextField609)
        );

        label161.setText(PlayerList.get(9));

        jTextField610.setText("0");

        jTextField611.setText("0");

        jTextField612.setText("0");

        jTextField613.setText("0");

        jTextField614.setText("0");

        javax.swing.GroupLayout jPanel143Layout = new javax.swing.GroupLayout(jPanel143);
        jPanel143.setLayout(jPanel143Layout);
        jPanel143Layout.setHorizontalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel143Layout.createSequentialGroup()
                .addComponent(label161, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField610, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField611, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField612, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField613, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField614, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel143Layout.setVerticalGroup(
            jPanel143Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label161, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField610)
            .addComponent(jTextField611)
            .addComponent(jTextField612)
            .addComponent(jTextField613)
            .addComponent(jTextField614)
        );

        label162.setText(PlayerList.get(10));

        jTextField615.setText("0");

        jTextField616.setText("0");

        jTextField617.setText("0");

        jTextField618.setText("0");

        jTextField619.setText("0");

        javax.swing.GroupLayout jPanel144Layout = new javax.swing.GroupLayout(jPanel144);
        jPanel144.setLayout(jPanel144Layout);
        jPanel144Layout.setHorizontalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel144Layout.createSequentialGroup()
                .addComponent(label162, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField615, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jTextField616, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jTextField617, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField618, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField619, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel144Layout.setVerticalGroup(
            jPanel144Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label162, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField615)
            .addComponent(jTextField616)
            .addComponent(jTextField617)
            .addComponent(jTextField618)
            .addComponent(jTextField619)
        );

        if(SubCount < 1 ) this.setVisible(false);

        label163.setText(PlayerList.get(11));

        jTextField620.setText("0");

        jTextField621.setText("0");

        jTextField622.setText("0");

        jTextField623.setText("0");

        jTextField624.setText("0");

        javax.swing.GroupLayout jPanel145Layout = new javax.swing.GroupLayout(jPanel145);
        jPanel145.setLayout(jPanel145Layout);
        jPanel145Layout.setHorizontalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel145Layout.createSequentialGroup()
                .addComponent(label163, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jTextField620, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField621, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField622, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField623, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField624, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel145Layout.setVerticalGroup(
            jPanel145Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label163, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField620)
            .addComponent(jTextField621)
            .addComponent(jTextField622)
            .addComponent(jTextField623)
            .addComponent(jTextField624)
        );

        label164.setText(PlayerList.get(12));

        jTextField625.setText("0");

        jTextField626.setText("0");

        jTextField627.setText("0");

        jTextField628.setText("0");

        jTextField629.setText("0");

        javax.swing.GroupLayout jPanel146Layout = new javax.swing.GroupLayout(jPanel146);
        jPanel146.setLayout(jPanel146Layout);
        jPanel146Layout.setHorizontalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel146Layout.createSequentialGroup()
                .addComponent(label164, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jTextField625, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTextField626, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField627, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField628, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField629, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel146Layout.setVerticalGroup(
            jPanel146Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label164, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField625)
            .addComponent(jTextField626)
            .addComponent(jTextField627)
            .addComponent(jTextField628)
            .addComponent(jTextField629)
        );

        jLabel10.setText(PlayerList.get(13));

        jTextField630.setText("0");
        jTextField630.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField630ActionPerformed(evt);
            }
        });

        jTextField631.setText("0");
        jTextField631.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField631ActionPerformed(evt);
            }
        });

        jTextField632.setText("0");
        jTextField632.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField632ActionPerformed(evt);
            }
        });

        jTextField633.setText("0");
        jTextField633.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField633ActionPerformed(evt);
            }
        });

        jTextField634.setText("0");
        jTextField634.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField634ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel147Layout = new javax.swing.GroupLayout(jPanel147);
        jPanel147.setLayout(jPanel147Layout);
        jPanel147Layout.setHorizontalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel147Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jTextField630, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jTextField631, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jTextField632, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField633, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField634, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel147Layout.setVerticalGroup(
            jPanel147Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTextField630, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jTextField631)
            .addComponent(jTextField632)
            .addComponent(jTextField633)
            .addComponent(jTextField634)
        );

        javax.swing.GroupLayout jPanel132Layout = new javax.swing.GroupLayout(jPanel132);
        jPanel132.setLayout(jPanel132Layout);
        jPanel132Layout.setHorizontalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel137, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel139, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel141, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel143, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel144, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel145, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel146, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel147, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel132Layout.setVerticalGroup(
            jPanel132Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel132Layout.createSequentialGroup()
                .addComponent(jPanel133, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel134, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel135, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel136, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel137, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel138, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel139, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel140, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel141, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel142, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel143, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel144, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel145, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel146, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel147, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        if(SubCount <1) {

            setPanelEnabled(jPanel145);
        }
        if(SubCount <2) {

            setPanelEnabled(jPanel146);
        }
        if(SubCount <3) {

            setPanelEnabled(jPanel147);
        }

        Passing.addTab("Attacking", jPanel132);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Passing)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Passing, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GetGoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetGoalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GetGoalActionPerformed

    private void GoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GoalActionPerformed

    private void YellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YellowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YellowActionPerformed

    private void jTextField81ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField81ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField81ActionPerformed

    private void Yellow14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Yellow14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Yellow14ActionPerformed

    private void Assist14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Assist14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Assist14ActionPerformed

    private void Goal14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Goal14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Goal14ActionPerformed

    private void Rating14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating14ActionPerformed

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void Yellow2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Yellow2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Yellow2ActionPerformed

    private void Assist2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Assist2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Assist2ActionPerformed

    private void Goal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Goal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Goal2ActionPerformed

    private void Red1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Red1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Red1ActionPerformed

    private void Yellow1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Yellow1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Yellow1ActionPerformed

    private void jTextField358ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField358ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField358ActionPerformed

    private void jTextField359ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField359ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField359ActionPerformed

    private void jTextField361ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField361ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField361ActionPerformed

    private void jTextField362ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField362ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField362ActionPerformed

    private void jTextField363ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField363ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField363ActionPerformed

    private void jTextField364ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField364ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField364ActionPerformed

    private void jTextField420ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField420ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField420ActionPerformed

    private void jTextField421ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField421ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField421ActionPerformed

    private void jTextField422ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField422ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField422ActionPerformed

    private void jTextField423ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField423ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField423ActionPerformed

    private void jTextField424ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField424ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField424ActionPerformed

    private void jTextField428ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField428ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField428ActionPerformed

    private void jTextField429ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField429ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField429ActionPerformed

    private void jTextField431ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField431ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField431ActionPerformed

    private void jTextField432ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField432ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField432ActionPerformed

    private void jTextField433ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField433ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField433ActionPerformed

    private void jTextField434ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField434ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField434ActionPerformed

    private void jTextField490ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField490ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField490ActionPerformed

    private void jTextField491ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField491ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField491ActionPerformed

    private void jTextField492ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField492ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField492ActionPerformed

    private void jTextField493ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField493ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField493ActionPerformed

    private void jTextField494ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField494ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField494ActionPerformed

    private void jTextField498ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField498ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField498ActionPerformed

    private void jTextField499ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField499ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField499ActionPerformed

    private void jTextField501ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField501ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField501ActionPerformed

    private void jTextField502ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField502ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField502ActionPerformed

    private void jTextField503ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField503ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField503ActionPerformed

    private void jTextField504ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField504ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField504ActionPerformed

    private void jTextField560ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField560ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField560ActionPerformed

    private void jTextField561ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField561ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField561ActionPerformed

    private void jTextField562ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField562ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField562ActionPerformed

    private void jTextField563ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField563ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField563ActionPerformed

    private void jTextField564ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField564ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField564ActionPerformed

    private void jTextField568ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField568ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField568ActionPerformed

    private void jTextField569ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField569ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField569ActionPerformed

    private void jTextField571ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField571ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField571ActionPerformed

    private void jTextField572ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField572ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField572ActionPerformed

    private void jTextField573ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField573ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField573ActionPerformed

    private void jTextField574ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField574ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField574ActionPerformed

    private void jTextField630ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField630ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField630ActionPerformed

    private void jTextField631ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField631ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField631ActionPerformed

    private void jTextField632ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField632ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField632ActionPerformed

    private void jTextField633ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField633ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField633ActionPerformed

    private void jTextField634ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField634ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField634ActionPerformed

    private void Rating6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating6ActionPerformed

    private void Rating7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rating7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Rating7ActionPerformed

    private void Yellow12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Yellow12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Yellow12ActionPerformed

    private void jTextField355ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField355ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField355ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"Success");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MatchReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatchReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatchReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatchReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new MatchReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Assist1;
    private javax.swing.JTextField Assist10;
    private javax.swing.JTextField Assist11;
    private javax.swing.JTextField Assist12;
    private javax.swing.JTextField Assist13;
    private javax.swing.JTextField Assist14;
    private javax.swing.JTextField Assist2;
    private javax.swing.JTextField Assist3;
    private javax.swing.JTextField Assist4;
    private javax.swing.JTextField Assist5;
    private javax.swing.JTextField Assist6;
    private javax.swing.JTextField Assist7;
    private javax.swing.JTextField Assist8;
    private javax.swing.JTextField Assist9;
    private javax.swing.JTextField GetGoal;
    private javax.swing.JTextField Goal;
    private javax.swing.JTextField Goal1;
    private javax.swing.JTextField Goal10;
    private javax.swing.JTextField Goal11;
    private javax.swing.JTextField Goal12;
    private javax.swing.JTextField Goal13;
    private javax.swing.JTextField Goal14;
    private javax.swing.JTextField Goal2;
    private javax.swing.JTextField Goal3;
    private javax.swing.JTextField Goal4;
    private javax.swing.JTextField Goal5;
    private javax.swing.JTextField Goal6;
    private javax.swing.JTextField Goal7;
    private javax.swing.JTextField Goal8;
    private javax.swing.JTextField Goal9;
    private javax.swing.JTabbedPane Passing;
    private javax.swing.JTextField Rating1;
    private javax.swing.JTextField Rating10;
    private javax.swing.JTextField Rating11;
    private javax.swing.JTextField Rating12;
    private javax.swing.JTextField Rating13;
    private javax.swing.JTextField Rating14;
    private javax.swing.JTextField Rating2;
    private javax.swing.JTextField Rating3;
    private javax.swing.JTextField Rating4;
    private javax.swing.JTextField Rating5;
    private javax.swing.JTextField Rating6;
    private javax.swing.JTextField Rating7;
    private javax.swing.JTextField Rating8;
    private javax.swing.JTextField Rating9;
    private javax.swing.JTextField Red;
    private javax.swing.JTextField Red1;
    private javax.swing.JTextField Yellow;
    private javax.swing.JTextField Yellow1;
    private javax.swing.JTextField Yellow10;
    private javax.swing.JTextField Yellow11;
    private javax.swing.JTextField Yellow12;
    private javax.swing.JTextField Yellow13;
    private javax.swing.JTextField Yellow14;
    private javax.swing.JTextField Yellow2;
    private javax.swing.JTextField Yellow3;
    private javax.swing.JTextField Yellow4;
    private javax.swing.JTextField Yellow5;
    private javax.swing.JTextField Yellow6;
    private javax.swing.JTextField Yellow7;
    private javax.swing.JTextField Yellow8;
    private javax.swing.JTextField Yellow9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel100;
    private javax.swing.JPanel jPanel101;
    private javax.swing.JPanel jPanel102;
    private javax.swing.JPanel jPanel103;
    private javax.swing.JPanel jPanel104;
    private javax.swing.JPanel jPanel105;
    private javax.swing.JPanel jPanel106;
    private javax.swing.JPanel jPanel107;
    private javax.swing.JPanel jPanel108;
    private javax.swing.JPanel jPanel109;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel110;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel114;
    private javax.swing.JPanel jPanel115;
    private javax.swing.JPanel jPanel116;
    private javax.swing.JPanel jPanel117;
    private javax.swing.JPanel jPanel118;
    private javax.swing.JPanel jPanel119;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel120;
    private javax.swing.JPanel jPanel121;
    private javax.swing.JPanel jPanel122;
    private javax.swing.JPanel jPanel123;
    private javax.swing.JPanel jPanel124;
    private javax.swing.JPanel jPanel125;
    private javax.swing.JPanel jPanel126;
    private javax.swing.JPanel jPanel127;
    private javax.swing.JPanel jPanel128;
    private javax.swing.JPanel jPanel129;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel130;
    private javax.swing.JPanel jPanel131;
    private javax.swing.JPanel jPanel132;
    private javax.swing.JPanel jPanel133;
    private javax.swing.JPanel jPanel134;
    private javax.swing.JPanel jPanel135;
    private javax.swing.JPanel jPanel136;
    private javax.swing.JPanel jPanel137;
    private javax.swing.JPanel jPanel138;
    private javax.swing.JPanel jPanel139;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel140;
    private javax.swing.JPanel jPanel141;
    private javax.swing.JPanel jPanel142;
    private javax.swing.JPanel jPanel143;
    private javax.swing.JPanel jPanel144;
    private javax.swing.JPanel jPanel145;
    private javax.swing.JPanel jPanel146;
    private javax.swing.JPanel jPanel147;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel89;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel90;
    private javax.swing.JPanel jPanel91;
    private javax.swing.JPanel jPanel92;
    private javax.swing.JPanel jPanel93;
    private javax.swing.JPanel jPanel94;
    private javax.swing.JPanel jPanel95;
    private javax.swing.JPanel jPanel96;
    private javax.swing.JPanel jPanel97;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField355;
    private javax.swing.JTextField jTextField356;
    private javax.swing.JTextField jTextField357;
    private javax.swing.JTextField jTextField358;
    private javax.swing.JTextField jTextField359;
    private javax.swing.JTextField jTextField360;
    private javax.swing.JTextField jTextField361;
    private javax.swing.JTextField jTextField362;
    private javax.swing.JTextField jTextField363;
    private javax.swing.JTextField jTextField364;
    private javax.swing.JTextField jTextField365;
    private javax.swing.JTextField jTextField366;
    private javax.swing.JTextField jTextField367;
    private javax.swing.JTextField jTextField368;
    private javax.swing.JTextField jTextField369;
    private javax.swing.JTextField jTextField370;
    private javax.swing.JTextField jTextField371;
    private javax.swing.JTextField jTextField372;
    private javax.swing.JTextField jTextField373;
    private javax.swing.JTextField jTextField374;
    private javax.swing.JTextField jTextField375;
    private javax.swing.JTextField jTextField376;
    private javax.swing.JTextField jTextField377;
    private javax.swing.JTextField jTextField378;
    private javax.swing.JTextField jTextField379;
    private javax.swing.JTextField jTextField380;
    private javax.swing.JTextField jTextField381;
    private javax.swing.JTextField jTextField382;
    private javax.swing.JTextField jTextField383;
    private javax.swing.JTextField jTextField384;
    private javax.swing.JTextField jTextField385;
    private javax.swing.JTextField jTextField386;
    private javax.swing.JTextField jTextField387;
    private javax.swing.JTextField jTextField388;
    private javax.swing.JTextField jTextField389;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField390;
    private javax.swing.JTextField jTextField391;
    private javax.swing.JTextField jTextField392;
    private javax.swing.JTextField jTextField393;
    private javax.swing.JTextField jTextField394;
    private javax.swing.JTextField jTextField395;
    private javax.swing.JTextField jTextField396;
    private javax.swing.JTextField jTextField397;
    private javax.swing.JTextField jTextField398;
    private javax.swing.JTextField jTextField399;
    private javax.swing.JTextField jTextField400;
    private javax.swing.JTextField jTextField401;
    private javax.swing.JTextField jTextField402;
    private javax.swing.JTextField jTextField403;
    private javax.swing.JTextField jTextField404;
    private javax.swing.JTextField jTextField405;
    private javax.swing.JTextField jTextField406;
    private javax.swing.JTextField jTextField407;
    private javax.swing.JTextField jTextField408;
    private javax.swing.JTextField jTextField409;
    private javax.swing.JTextField jTextField410;
    private javax.swing.JTextField jTextField411;
    private javax.swing.JTextField jTextField412;
    private javax.swing.JTextField jTextField413;
    private javax.swing.JTextField jTextField414;
    private javax.swing.JTextField jTextField415;
    private javax.swing.JTextField jTextField416;
    private javax.swing.JTextField jTextField417;
    private javax.swing.JTextField jTextField418;
    private javax.swing.JTextField jTextField419;
    private javax.swing.JTextField jTextField420;
    private javax.swing.JTextField jTextField421;
    private javax.swing.JTextField jTextField422;
    private javax.swing.JTextField jTextField423;
    private javax.swing.JTextField jTextField424;
    private javax.swing.JTextField jTextField425;
    private javax.swing.JTextField jTextField426;
    private javax.swing.JTextField jTextField427;
    private javax.swing.JTextField jTextField428;
    private javax.swing.JTextField jTextField429;
    private javax.swing.JTextField jTextField430;
    private javax.swing.JTextField jTextField431;
    private javax.swing.JTextField jTextField432;
    private javax.swing.JTextField jTextField433;
    private javax.swing.JTextField jTextField434;
    private javax.swing.JTextField jTextField435;
    private javax.swing.JTextField jTextField436;
    private javax.swing.JTextField jTextField437;
    private javax.swing.JTextField jTextField438;
    private javax.swing.JTextField jTextField439;
    private javax.swing.JTextField jTextField440;
    private javax.swing.JTextField jTextField441;
    private javax.swing.JTextField jTextField442;
    private javax.swing.JTextField jTextField443;
    private javax.swing.JTextField jTextField444;
    private javax.swing.JTextField jTextField445;
    private javax.swing.JTextField jTextField446;
    private javax.swing.JTextField jTextField447;
    private javax.swing.JTextField jTextField448;
    private javax.swing.JTextField jTextField449;
    private javax.swing.JTextField jTextField450;
    private javax.swing.JTextField jTextField451;
    private javax.swing.JTextField jTextField452;
    private javax.swing.JTextField jTextField453;
    private javax.swing.JTextField jTextField454;
    private javax.swing.JTextField jTextField455;
    private javax.swing.JTextField jTextField456;
    private javax.swing.JTextField jTextField457;
    private javax.swing.JTextField jTextField458;
    private javax.swing.JTextField jTextField459;
    private javax.swing.JTextField jTextField460;
    private javax.swing.JTextField jTextField461;
    private javax.swing.JTextField jTextField462;
    private javax.swing.JTextField jTextField463;
    private javax.swing.JTextField jTextField464;
    private javax.swing.JTextField jTextField465;
    private javax.swing.JTextField jTextField466;
    private javax.swing.JTextField jTextField467;
    private javax.swing.JTextField jTextField468;
    private javax.swing.JTextField jTextField469;
    private javax.swing.JTextField jTextField470;
    private javax.swing.JTextField jTextField471;
    private javax.swing.JTextField jTextField472;
    private javax.swing.JTextField jTextField473;
    private javax.swing.JTextField jTextField474;
    private javax.swing.JTextField jTextField475;
    private javax.swing.JTextField jTextField476;
    private javax.swing.JTextField jTextField477;
    private javax.swing.JTextField jTextField478;
    private javax.swing.JTextField jTextField479;
    private javax.swing.JTextField jTextField480;
    private javax.swing.JTextField jTextField481;
    private javax.swing.JTextField jTextField482;
    private javax.swing.JTextField jTextField483;
    private javax.swing.JTextField jTextField484;
    private javax.swing.JTextField jTextField485;
    private javax.swing.JTextField jTextField486;
    private javax.swing.JTextField jTextField487;
    private javax.swing.JTextField jTextField488;
    private javax.swing.JTextField jTextField489;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField490;
    private javax.swing.JTextField jTextField491;
    private javax.swing.JTextField jTextField492;
    private javax.swing.JTextField jTextField493;
    private javax.swing.JTextField jTextField494;
    private javax.swing.JTextField jTextField495;
    private javax.swing.JTextField jTextField496;
    private javax.swing.JTextField jTextField497;
    private javax.swing.JTextField jTextField498;
    private javax.swing.JTextField jTextField499;
    private javax.swing.JTextField jTextField500;
    private javax.swing.JTextField jTextField501;
    private javax.swing.JTextField jTextField502;
    private javax.swing.JTextField jTextField503;
    private javax.swing.JTextField jTextField504;
    private javax.swing.JTextField jTextField505;
    private javax.swing.JTextField jTextField506;
    private javax.swing.JTextField jTextField507;
    private javax.swing.JTextField jTextField508;
    private javax.swing.JTextField jTextField509;
    private javax.swing.JTextField jTextField510;
    private javax.swing.JTextField jTextField511;
    private javax.swing.JTextField jTextField512;
    private javax.swing.JTextField jTextField513;
    private javax.swing.JTextField jTextField514;
    private javax.swing.JTextField jTextField515;
    private javax.swing.JTextField jTextField516;
    private javax.swing.JTextField jTextField517;
    private javax.swing.JTextField jTextField518;
    private javax.swing.JTextField jTextField519;
    private javax.swing.JTextField jTextField520;
    private javax.swing.JTextField jTextField521;
    private javax.swing.JTextField jTextField522;
    private javax.swing.JTextField jTextField523;
    private javax.swing.JTextField jTextField524;
    private javax.swing.JTextField jTextField525;
    private javax.swing.JTextField jTextField526;
    private javax.swing.JTextField jTextField527;
    private javax.swing.JTextField jTextField528;
    private javax.swing.JTextField jTextField529;
    private javax.swing.JTextField jTextField530;
    private javax.swing.JTextField jTextField531;
    private javax.swing.JTextField jTextField532;
    private javax.swing.JTextField jTextField533;
    private javax.swing.JTextField jTextField534;
    private javax.swing.JTextField jTextField535;
    private javax.swing.JTextField jTextField536;
    private javax.swing.JTextField jTextField537;
    private javax.swing.JTextField jTextField538;
    private javax.swing.JTextField jTextField539;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField540;
    private javax.swing.JTextField jTextField541;
    private javax.swing.JTextField jTextField542;
    private javax.swing.JTextField jTextField543;
    private javax.swing.JTextField jTextField544;
    private javax.swing.JTextField jTextField545;
    private javax.swing.JTextField jTextField546;
    private javax.swing.JTextField jTextField547;
    private javax.swing.JTextField jTextField548;
    private javax.swing.JTextField jTextField549;
    private javax.swing.JTextField jTextField550;
    private javax.swing.JTextField jTextField551;
    private javax.swing.JTextField jTextField552;
    private javax.swing.JTextField jTextField553;
    private javax.swing.JTextField jTextField554;
    private javax.swing.JTextField jTextField555;
    private javax.swing.JTextField jTextField556;
    private javax.swing.JTextField jTextField557;
    private javax.swing.JTextField jTextField558;
    private javax.swing.JTextField jTextField559;
    private javax.swing.JTextField jTextField560;
    private javax.swing.JTextField jTextField561;
    private javax.swing.JTextField jTextField562;
    private javax.swing.JTextField jTextField563;
    private javax.swing.JTextField jTextField564;
    private javax.swing.JTextField jTextField565;
    private javax.swing.JTextField jTextField566;
    private javax.swing.JTextField jTextField567;
    private javax.swing.JTextField jTextField568;
    private javax.swing.JTextField jTextField569;
    private javax.swing.JTextField jTextField570;
    private javax.swing.JTextField jTextField571;
    private javax.swing.JTextField jTextField572;
    private javax.swing.JTextField jTextField573;
    private javax.swing.JTextField jTextField574;
    private javax.swing.JTextField jTextField575;
    private javax.swing.JTextField jTextField576;
    private javax.swing.JTextField jTextField577;
    private javax.swing.JTextField jTextField578;
    private javax.swing.JTextField jTextField579;
    private javax.swing.JTextField jTextField580;
    private javax.swing.JTextField jTextField581;
    private javax.swing.JTextField jTextField582;
    private javax.swing.JTextField jTextField583;
    private javax.swing.JTextField jTextField584;
    private javax.swing.JTextField jTextField585;
    private javax.swing.JTextField jTextField586;
    private javax.swing.JTextField jTextField587;
    private javax.swing.JTextField jTextField588;
    private javax.swing.JTextField jTextField589;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField590;
    private javax.swing.JTextField jTextField591;
    private javax.swing.JTextField jTextField592;
    private javax.swing.JTextField jTextField593;
    private javax.swing.JTextField jTextField594;
    private javax.swing.JTextField jTextField595;
    private javax.swing.JTextField jTextField596;
    private javax.swing.JTextField jTextField597;
    private javax.swing.JTextField jTextField598;
    private javax.swing.JTextField jTextField599;
    private javax.swing.JTextField jTextField600;
    private javax.swing.JTextField jTextField601;
    private javax.swing.JTextField jTextField602;
    private javax.swing.JTextField jTextField603;
    private javax.swing.JTextField jTextField604;
    private javax.swing.JTextField jTextField605;
    private javax.swing.JTextField jTextField606;
    private javax.swing.JTextField jTextField607;
    private javax.swing.JTextField jTextField608;
    private javax.swing.JTextField jTextField609;
    private javax.swing.JTextField jTextField610;
    private javax.swing.JTextField jTextField611;
    private javax.swing.JTextField jTextField612;
    private javax.swing.JTextField jTextField613;
    private javax.swing.JTextField jTextField614;
    private javax.swing.JTextField jTextField615;
    private javax.swing.JTextField jTextField616;
    private javax.swing.JTextField jTextField617;
    private javax.swing.JTextField jTextField618;
    private javax.swing.JTextField jTextField619;
    private javax.swing.JTextField jTextField620;
    private javax.swing.JTextField jTextField621;
    private javax.swing.JTextField jTextField622;
    private javax.swing.JTextField jTextField623;
    private javax.swing.JTextField jTextField624;
    private javax.swing.JTextField jTextField625;
    private javax.swing.JTextField jTextField626;
    private javax.swing.JTextField jTextField627;
    private javax.swing.JTextField jTextField628;
    private javax.swing.JTextField jTextField629;
    private javax.swing.JTextField jTextField630;
    private javax.swing.JTextField jTextField631;
    private javax.swing.JTextField jTextField632;
    private javax.swing.JTextField jTextField633;
    private javax.swing.JTextField jTextField634;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField69;
    private javax.swing.JTextField jTextField74;
    private javax.swing.JTextField jTextField81;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label100;
    private java.awt.Label label101;
    private java.awt.Label label102;
    private java.awt.Label label103;
    private java.awt.Label label104;
    private java.awt.Label label105;
    private java.awt.Label label106;
    private java.awt.Label label107;
    private java.awt.Label label108;
    private java.awt.Label label109;
    private java.awt.Label label11;
    private java.awt.Label label110;
    private java.awt.Label label111;
    private java.awt.Label label112;
    private java.awt.Label label113;
    private java.awt.Label label114;
    private java.awt.Label label115;
    private java.awt.Label label116;
    private java.awt.Label label117;
    private java.awt.Label label118;
    private java.awt.Label label119;
    private java.awt.Label label12;
    private java.awt.Label label120;
    private java.awt.Label label121;
    private java.awt.Label label122;
    private java.awt.Label label123;
    private java.awt.Label label124;
    private java.awt.Label label125;
    private java.awt.Label label126;
    private java.awt.Label label127;
    private java.awt.Label label128;
    private java.awt.Label label129;
    private java.awt.Label label13;
    private java.awt.Label label130;
    private java.awt.Label label131;
    private java.awt.Label label132;
    private java.awt.Label label133;
    private java.awt.Label label134;
    private java.awt.Label label135;
    private java.awt.Label label136;
    private java.awt.Label label137;
    private java.awt.Label label138;
    private java.awt.Label label139;
    private java.awt.Label label14;
    private java.awt.Label label140;
    private java.awt.Label label141;
    private java.awt.Label label142;
    private java.awt.Label label143;
    private java.awt.Label label144;
    private java.awt.Label label145;
    private java.awt.Label label146;
    private java.awt.Label label147;
    private java.awt.Label label148;
    private java.awt.Label label149;
    private java.awt.Label label15;
    private java.awt.Label label150;
    private java.awt.Label label151;
    private java.awt.Label label152;
    private java.awt.Label label153;
    private java.awt.Label label154;
    private java.awt.Label label155;
    private java.awt.Label label156;
    private java.awt.Label label157;
    private java.awt.Label label158;
    private java.awt.Label label159;
    private java.awt.Label label16;
    private java.awt.Label label160;
    private java.awt.Label label161;
    private java.awt.Label label162;
    private java.awt.Label label163;
    private java.awt.Label label164;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label label2;
    private java.awt.Label label20;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.Label label93;
    private java.awt.Label label94;
    private java.awt.Label label95;
    private java.awt.Label label96;
    private java.awt.Label label97;
    private java.awt.Label label98;
    private java.awt.Label label99;
    private java.awt.Label labelName;
    private java.awt.Label labelName5;
    private java.awt.Label labelName6;
    private java.awt.Label labelName7;
    private java.awt.Label labelName8;
    // End of variables declaration//GEN-END:variables
}
