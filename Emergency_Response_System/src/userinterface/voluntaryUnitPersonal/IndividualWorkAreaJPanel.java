/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.voluntaryUnitPersonal;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.BroadcastAlertRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author shivibhatt
 */
public class IndividualWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form IndividualWorkAreaJPanel
     */
    JPanel userProcessContainer;
    Enterprise enterprise;
    Network network;
    Organization organization;
    EcoSystem system;
    UserAccount account;
    public IndividualWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.network = network;
        this.system = system;
        populateAlerts();
    }
    
    public void populateAlerts() {
        
        JTextField txtField;
        JTextArea textArea;
        jPanel1.setLayout(new GridLayout(20, 1));
        int pos = 0;
        boolean showAlertMsg = false;
        
        ArrayList<BroadcastAlertRequest> bb = new ArrayList<>();
        for(WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if(wr instanceof BroadcastAlertRequest) {
                bb.add((BroadcastAlertRequest)wr);
            }
        }
        Collections.sort(bb, (o1, o2) -> o2.getRequestDate().compareTo(o1.getRequestDate()));
        
        for(BroadcastAlertRequest wr : bb) {
            if(wr instanceof BroadcastAlertRequest) {
                if(!((BroadcastAlertRequest) wr).isIsAlertSeen()) {
                    showAlertMsg = true;
                    ((BroadcastAlertRequest) wr).setIsAlertSeen(true);
                }
                txtField = new JTextField(wr.getRequestDate() + ": Broadcasted by: " + wr.getSender().getEmployee().getName());
                txtField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
                txtField.setEditable(false);
                txtField.setVisible(true);
                textArea = new JTextArea("Network: " + ((BroadcastAlertRequest) wr).getInNetwork().getName() + "\nAlert: " + ((BroadcastAlertRequest) wr).getAlertMessage());
                textArea.setEditable(false);
                textArea.setVisible(true);
                jPanel1.add(txtField,pos);
                jPanel1.add(textArea,++pos);
                ++pos;
            }
        }
        if(showAlertMsg) {
            JOptionPane.showMessageDialog(null, "You have a new alert broadcasted.");
        }
        /*
        
        jPanel1.removeAll();
      jPanel1.setLayout(new GridLayout(10, 4, 10, 10));
        ArrayList<String> sList= new ArrayList<>();
        sList.add("1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");sList.add("10afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        JTextField txtField;
       int count = 0;
       int pos = 0;
      for(String s : sList) {
          txtField = new JTextField(new Date() + "Written By ");
          jPanel1.add(txtField,pos);
      }
        //JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setPreferredSize(new Dimension(100, 100));
//alertsPanel.add(scrollPane);
        //alertsPanel.revalidate();
        
        //jScrollPane1.setVisible(true);

        /*ArrayList<String> sList= new ArrayList<>();
        sList.add("1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf1afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");sList.add("10afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        sList.add("afsfs asfasff asfasf");
        alertsPanel.removeAll();
        alertsPanel.revalidate();
       JScrollPane scroller = new JScrollPane(alertsPanel);
       setPreferredSize(new Dimension(450, 110));
       add(scroller, BorderLayout.CENTER);
       JTextArea textArea;
       JTextField txtField;
       int count = 0;
       int pos = 0;
           
        for(String s : sList)
        {
            //if(count<5)
            //{
            
            txtField = new JTextField(new Date() + "Written By ");
            txtField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
            txtField.setEditable(false);
            txtField.setVisible(true);
            textArea = new JTextArea(s);
            textArea.setEditable(false);
            textArea.setVisible(true);
            count++;
             
            alertsPanel.setLayout(new GridLayout(10, 10,10,10));
            
            alertsPanel.add(txtField,pos);
            alertsPanel.add(textArea,++pos);
            
            ++pos;
            //}
        }
        
        
        alertsPanel.revalidate();
        
        alertsPanel.setVisible(true);
        */
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        manageRequest = new javax.swing.JButton();
        manageScene = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Indvidual Work Area -Adminstrative Role");

        manageRequest.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        manageRequest.setText("Manage Requests ");
        manageRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRequestActionPerformed(evt);
            }
        });

        manageScene.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        manageScene.setText("Manage Scene");
        manageScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageSceneActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel1)
                .addContainerGap(272, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(manageRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageScene, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(manageRequest)
                        .addGap(41, 41, 41)
                        .addComponent(manageScene)))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("jjpanel");
    }// </editor-fold>//GEN-END:initComponents

    private void manageRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRequestActionPerformed
        //IndividualWorkRequestJPanel manageIndividualWorkRequest = new IndividualWorkRequestJPanel( userProcessContainer,  account,  organization,  enterprise,  network,  system);
        IndividualAdminWorkAreaJPanel manageIndividualWorkRequest = new IndividualAdminWorkAreaJPanel( userProcessContainer,  account,  organization,  enterprise,  network,  system);
        userProcessContainer.add("IndividualAdminWorkAreaJPanel", manageIndividualWorkRequest);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageRequestActionPerformed

    private void manageSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageSceneActionPerformed
        // TODO add your handling code here
        ManageIndividualSceneJPanel manageScene = new ManageIndividualSceneJPanel( userProcessContainer,  enterprise,  system,  organization,  network, account);
        userProcessContainer.add("ManageHospitalSceneJPanel", manageScene);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageSceneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageRequest;
    private javax.swing.JButton manageScene;
    // End of variables declaration//GEN-END:variables
}
