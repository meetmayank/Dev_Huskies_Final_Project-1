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
import Business.WorkQueue.VolunteerSceneRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.GoogleMAP.OrganizationLocationJPanel;
import userinterface.IncidentUnitWorkArea.*;

/**
 *
 * @author Mayank
 */
public class ReportingAdminManageRequestsJPanel extends javax.swing.JPanel {
    
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
    public ReportingAdminManageRequestsJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system, Organization organization, Network network,UserAccount account) {
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
            
            if (wr instanceof VolunteerSceneRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = wr;
                row[1] = ((VolunteerSceneRequest) wr).getSceneName();
                row[2] = ((VolunteerSceneRequest) wr).getSceneZipcode();
                row[3] = ((VolunteerSceneRequest) wr).getSceneLocationPoint();
                row[4] = ((VolunteerSceneRequest) wr).getNoOfVictims();
                row[5] = ((VolunteerSceneRequest) wr).getEstimatedLoss();
                row[6] = ((VolunteerSceneRequest) wr).getStatus();
                row[7] = ((VolunteerSceneRequest) wr).getRequestDate();
                row[8] = ((VolunteerSceneRequest) wr).getMessage();
                model.addRow(row);
            }
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
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        sceneTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Scene #", "Scene Name", "Zip Code", "Location", "# of Victims", "Estimated Loss", "Status", "Created Date", "Additional Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sceneTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sceneTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sceneTable);

        jLabel1.setText("Scene Name");

        sceneName.setEditable(false);
        sceneName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sceneNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Zip Code");

        sceneZipCode.setEditable(false);

        noOfVictims.setEditable(false);

        jLabel4.setText("# of victims");

        estimatedLoss.setEditable(false);

        jLabel5.setText("Estimated Loss");

        createSceneBtn.setText("Approve");
        createSceneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createSceneBtnActionPerformed(evt);
            }
        });

        jLabel6.setText("Location Point");

        sceneLocation.setEditable(false);

        jLabel3.setText("Scene Image");

        jButton1.setText("Reject");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Picture will display here");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setPreferredSize(new java.awt.Dimension(460, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
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
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(estimatedLoss, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                            .addComponent(noOfVictims))
                                        .addGap(393, 393, 393))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(sceneLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(369, 369, 369)
                .addComponent(createSceneBtn)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(sceneLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createSceneBtn)
                    .addComponent(jButton1))
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sceneNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sceneNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sceneNameActionPerformed

    private void createSceneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createSceneBtnActionPerformed
        
        String msg = JOptionPane.showInputDialog("Additional Message");
        
        selectedWorkReq.setStatus("Forwarded to Disaster Team");
        selectedWorkReq.setMessage(msg);
        
        ReportingAdminSceneRequest sceneReq = new ReportingAdminSceneRequest();
        sceneReq.setSceneName(sceneName.getText());
        sceneReq.setSceneZipcode(sceneZipCode.getText());
        sceneReq.setNoOfVictims(Integer.parseInt(noOfVictims.getText()));
        sceneReq.setEstimatedLoss(estimatedLoss.getText());
        sceneReq.setSceneLocationPoint(selectedWorkReq.getSceneLocationPoint());
        sceneReq.setStatus("Requested");  
        sceneReq.setSender(account);
        //sceneReq.setSceneId("S"+(organization.getWorkQueue().getWorkRequestList().size()+1));
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
    VolunteerSceneRequest selectedWorkReq;
    private void sceneTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sceneTableMouseClicked
        //int selectedReq = sceneTable.rowAtPoint(evt.getPoint());
        
        int selectedReq = sceneTable.getSelectedRow();
        selectedWorkReq = (VolunteerSceneRequest)sceneTable.getValueAt(selectedReq, 0);
        sceneName.setText(selectedWorkReq.getSceneName());
        sceneZipCode.setText(selectedWorkReq.getSceneZipcode());
        noOfVictims.setText(selectedWorkReq.getNoOfVictims()+"");
        estimatedLoss.setText(selectedWorkReq.getEstimatedLoss());
        sceneLocation.setText(selectedWorkReq.getSceneLocationPoint()+"");
        sceneName.setText(selectedWorkReq.getSceneName());
        //displayImage(selectedWorkReq.getImagePath());
        System.out.println("/********/////");
        displayDImage(selectedWorkReq.getImagePath());
        /*String imgPath = selectedWorkReq.getImagePath();
        ImageIcon imgIcon = new ImageIcon(imgPath);  
        Image imgFit = imgIcon.getImage().getScaledInstance(460, 280, Image.SCALE_SMOOTH);
        jLabel7.setText("");
        jLabel7.setIcon(new ImageIcon(imgFit));*/
        //licenceInfo.setImagePath(imgPath); 
        
        
    }//GEN-LAST:event_sceneTableMouseClicked
    
    public void displayDImage(String bb) {
        String imgPath = bb;
        ImageIcon imgIcon = new ImageIcon(imgPath);  
        Image imgFit = imgIcon.getImage().getScaledInstance(460, 280, Image.SCALE_SMOOTH);
        jLabel7.setText("");
        jLabel7.setIcon(new ImageIcon(imgFit));
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String msg = JOptionPane.showInputDialog("Additional Message");
        selectedWorkReq.setStatus("Rejected");
        selectedWorkReq.setMessage(msg);
        populateSceneTable();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /*public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(460, 280, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    public void displayImage(String imgPath) {
        System.out.println("FILE PATH = " + imgPath);
        imageJPanel.removeAll();
        JLabel label = new JLabel(ResizeImage(imgPath));
        imageJPanel.add(label);
        imageJPanel.invalidate();
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createSceneBtn;
    private javax.swing.JTextField estimatedLoss;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField noOfVictims;
    private javax.swing.JTextField sceneLocation;
    private javax.swing.JTextField sceneName;
    private javax.swing.JTable sceneTable;
    private javax.swing.JTextField sceneZipCode;
    // End of variables declaration//GEN-END:variables
}