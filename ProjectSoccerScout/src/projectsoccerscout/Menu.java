/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsoccerscout;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static projectsoccerscout.MatchPlayer.PlayerList;
import static projectsoccerscout.MatchReport.List;

/**
 *
 * @author oOo
 */



public class Menu extends javax.swing.JFrame {
    ArrayList<String> Player = new ArrayList<String>();
    ArrayList<Integer> Num = new ArrayList<Integer>();
    ArrayList<Integer> Age = new ArrayList<Integer>();
    ArrayList<String> Nation = new ArrayList<String>();
    ArrayList<ImageIcon> Image = new ArrayList<ImageIcon>();
    ArrayList<String> Position = new ArrayList();
    DefaultTableModel tablemodela = new DefaultTableModel();
    DefaultTableModel tablemodelb = new DefaultTableModel();
    ArrayList<String> Opp = new ArrayList<String>();
    ArrayList<String> Station = new ArrayList<String>();
    ArrayList<String> GameTime = new ArrayList<String>();
    ArrayList<Integer> Goal = new ArrayList<Integer>();
    ArrayList<Integer> Conceded = new ArrayList<Integer>();
  
    /**
     * Creates new form Menu
     */
    public int getAge(String d){
        LocalDate date =  LocalDate.parse(d);
        LocalDate dnow = LocalDate.now();
        LocalDate d2 = date.withYear(dnow.getYear());
        if (d2.isAfter(date)){
            return dnow.getYear() - date.getYear() - 1;
        }
        else{
            return dnow.getYear() - date.getYear();
        }
    }
    
    public Menu() throws IOException {
        initComponents();
        getPlayer();
        TablePlayer();
        getMatch();
        TableMatch();
        
    }
    public void getPlayer() throws IOException{
        tablemodela.setRowCount(0);
        Player.clear();
        Num.clear();
        Image.clear();
        Age.clear();
        Position.clear();
        PreparedStatement st = null;
         ResultSet rs = null;
         
        Connection con = MyConnection.getConnection();
        try{
           
            String query = "SELECT * FROM `playertable` ";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while(rs.next()!=false){
                String name = rs.getString("name");
                String num = String.valueOf(rs.getInt("num"));
                Blob img = rs.getBlob("image");
                String date = rs.getString("birthday");
                String pos = rs.getString("Position");
                Age.add(getAge(date));
                InputStream stream = img.getBinaryStream();
                BufferedImage buffImg = ImageIO.read(stream);
                ImageIcon icon = new ImageIcon(buffImg);
                Image.add(icon);
                Player.add(name);
                Num.add(Integer.parseInt(num));
                Position.add(pos);
            }   
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Something wrong");
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    public void TablePlayer(){
        ArrayList Row = new ArrayList();
        for(int i = 0;i<Player.size();i++){
            Row.add(Num.get(i));
            Row.add(Player.get(i));
            Row.add(Position.get(i));
            Row.add(Age.get(i));
            Row.add(Image.get(i));  
            tablemodela.addRow(Row.toArray());
            Row.clear();
        }
        jTable2.setModel(tablemodela);
        jTable2.setRowHeight(50);
    }
    public void TableMatch(){
        ArrayList Row = new ArrayList();
        for(int i = 0;i<Opp.size();i++){
            Row.add(Opp.get(i));
            Row.add(Station.get(i));
            Row.add(GameTime.get(i));
            Row.add(Goal.get(i));
            Row.add(Conceded.get(i));
            tablemodelb.addRow(Row.toArray());
            Row.clear();
        }
        jTable3.setModel(tablemodelb);
    }
  
  
    public void getMatch(){
        tablemodelb.setRowCount(0);
        Opp.clear();
        Station.clear();
        GameTime.clear();
        Goal.clear();
        Conceded.clear();
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = MyConnection.getConnection();
        try{
           
            String query = "SELECT * FROM `matchdatabase`";
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while(rs.next()!=false){
                String name = rs.getString("Opponent");
                int goal = rs.getInt("Goal");
                int goaled = rs.getInt("Goaled");
                String station = rs.getString("HomeAway");
                String date = rs.getString("Date");
               Opp.add(name);
               Station.add(station);
               GameTime.add(date);
               Goal.add(goal);
               Conceded.add(goaled);
               
            }   
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Something wrong");
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        String[] Title = {"Opponent","Home/Away","Date","Goal","Conceded"};
        jTable3.setAutoCreateRowSorter(true);
        tablemodelb = new DefaultTableModel(null,Title);
        panel1 = new java.awt.Panel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        String[] title = {"Num","Name","Position","Age","Image"};
        jTable2.setAutoCreateRowSorter(true);
        tablemodela = new DefaultTableModel(null,title){
            @Override
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        jTable2.setModel(tablemodela);
        jTable2.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable2);

        jTabbedPane1.addTab("Player", jScrollPane1);

        jTable3.setModel(tablemodelb);
        jScrollPane2.setViewportView(jTable3);

        jTabbedPane1.addTab("Match", jScrollPane2);

        jButton1.setText("Add a Player");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add a Match");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Player");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Match");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(99, 99, 99))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MatchPlayer add = null;
        try {
            add = new MatchPlayer();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        add.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       AddingPlayer add = new AddingPlayer();
       add.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Player p = new Player();
        p.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Match m = new Match();
        m.setVisible(true);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            // TODO add your handling code here:
            updatePlayer();
        } catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateMatch();
    }//GEN-LAST:event_jButton3ActionPerformed
    public void updatePlayer() throws IOException{
        getPlayer();
        TablePlayer();
    }
    public void updateMatch(){
        getMatch();
        TableMatch();
    }
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Menu().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
