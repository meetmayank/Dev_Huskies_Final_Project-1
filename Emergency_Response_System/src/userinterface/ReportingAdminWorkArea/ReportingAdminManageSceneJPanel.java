/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ReportingAdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Location.LocationPoint;
import Business.Network.Network;
import Business.Organization.DisasterOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ReportingAdminSceneRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.GoogleMAP.OrganizationLocationJPanel;
import userinterface.IncidentUnitWorkArea.*;

/**
 *
 * @author Mayank
 */
public class ReportingAdminManageSceneJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Enterprise enterprise;
    EcoSystem system;
    Organization organization;
    Network network;
    private LocationPoint locationPoint;
    private UserAccount account;
    /**
     * Creates new form IncidentUnitManageScene
     */
    public ReportingAdminManageSceneJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system, Organization organization, Network network,UserAccount account) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        this.organization = organization;
        this.network = network;
        this.account = account;
        populateSceneTable();
    }
    
    private void populateSceneTable(){
        DefaultTableModel model = (DefaultTableModel) sceneTable.getModel();
        
        model.setRowCount(0);
        
        for (WorkRequest wr : account.getWorkQueue().getWorkRequestList()){
            
            if (wr instanceof ReportingAdminSceneRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = wr;
                row[1] = ((ReportingAdminSceneRequest) wr).getSceneName();
                row[2] = ((ReportingAdminSceneRequest) wr).getSceneZipcode();
                row[3] = ((ReportingAdminSceneRequest) wr).getSceneLocationPoint();
                row[4] = ((ReportingAdminSceneRequest) wr).getNoOfVictims();
                row[5] = ((ReportingAdminSceneRequest) wr).getEstimatedLoss();
                row[6] = ((ReportingAdminSceneRequest) wr).getStatus();
                //row[2] = org.getPosition();
                model.addRow(row);
            }
            
            
            /*Object[] row = new Object[2];
            row[0] = organization.getOrganizationID();
            row[1] = organization.getName();
            
            model.addRow(row);*/
        }
    }
    
    public void populateLongituteLatitude(LocationPoint locationPoint) {
        this.locationPoint = locationPoint;
        sceneLocation.setText(locationPoint.getLatitude() + ", " + locationPoint.getLongitude());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sceneTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sceneName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sceneZipCode = new javax.swing.JTextField();
        noOfVictims = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        estimatedLoss = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        createSceneBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        sceneLocation = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        sceneTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Scene #", "Scene Name", "Zip Code", "Location", "# of Victims", "Estimated Loss", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(sceneTable);

        jLabel1.setText("Scene Name");

        sceneName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sceneNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Zip Code");

        jLabel4.setText("# of victims");

        jLabel5.setText("Estimated Loss");

        createSceneBtn.setText("Create Scene");
        createSceneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSceneBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Location Point");

        jButton2.setText("Set Location");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(314, 314, 314)
                                .addComponent(createSceneBtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(66, 66, 66)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(sceneZipCode, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(sceneName, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6))
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(noOfVictims, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(estimatedLoss, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(sceneLocation))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sceneName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sceneZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(noOfVictims, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(estimatedLoss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sceneLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(39, 39, 39)
                .addComponent(createSceneBtn)
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sceneNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sceneNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sceneNameActionPerformed

    private void createSceneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSceneBtnActionPerformed
        ReportingAdminSceneRequest sceneReq = new ReportingAdminSceneRequest();
        sceneReq.setSceneName(sceneName.getText());
        sceneReq.setSceneZipcode(sceneZipCode.getText());
        sceneReq.setNoOfVictims(Integer.parseInt(noOfVictims.getText()));
        sceneReq.setEstimatedLoss(estimatedLoss.getText());
        sceneReq.setSceneLocationPoint(locationPoint);
        sceneReq.setStatus("Requested");  
        sceneReq.setSender(account);
        sceneReq.setSceneId("S"+(organization.getWorkQueue().getWorkRequestList().size()+1));
        sceneReq.setMessage("Waiting for disaster head to approve request");
       
        account.getWorkQueue().getWorkRequestList().add(sceneReq);
        
        //for (Network net : business.getNetworkList()) {
            for (Enterprise e : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                    if (o instanceof DisasterOrganization) {
                         o.getWorkQueue().getWorkRequestList().add(sceneReq);
                    }
                }
            }
            populateSceneTable();
        //}
    }//GEN-LAST:event_createSceneBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        OrganizationLocationJPanel muajp = new OrganizationLocationJPanel(userProcessContainer);
        userProcessContainer.add("OrganizationLocationJPanel", muajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createSceneBtn;
    private javax.swing.JTextField estimatedLoss;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField noOfVictims;
    private javax.swing.JTextField sceneLocation;
    private javax.swing.JTextField sceneName;
    private javax.swing.JTable sceneTable;
    private javax.swing.JTextField sceneZipCode;
    // End of variables declaration//GEN-END:variables
}
