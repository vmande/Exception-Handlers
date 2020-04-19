/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InsuranceFinanceRole;

import Business.Enterprise.Enterprise;
import Business.Organization.InsuranceFinanceOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.GovernmentFundRequest;
import Business.WorkQueue.InsuranceWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lionel
 */
public class InsuranceFinanceWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private InsuranceFinanceOrganization insuranceFinanceOrganization;
    private Enterprise enterprise;

    /**
     * Creates new form InsuranceFinanceWorkAreaJPanel
     */
    public InsuranceFinanceWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, InsuranceFinanceOrganization insuranceFinanceOrganization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.insuranceFinanceOrganization = insuranceFinanceOrganization;
        this.enterprise = enterprise;
        populateTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFinance = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
        processRequestBtn2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Insurance Finance Work Area");

        tblFinance.setBackground(new java.awt.Color(0, 153, 255));
        tblFinance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Policy Number", "Policy Name", "Coverage%", "Claim Amount", "Bill Amount", "Insurance Claim Status", "Requesting HealthCenter ", "Finance Manager"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFinance);

        btnAssign.setBackground(new java.awt.Color(0, 153, 255));
        btnAssign.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAssign.setText("Assign To Me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        processRequestBtn2.setBackground(new java.awt.Color(0, 153, 255));
        processRequestBtn2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        processRequestBtn2.setText("Process Request");
        processRequestBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processRequestBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(264, 264, 264)
                                .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(processRequestBtn2)))
                        .addGap(0, 303, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(processRequestBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(268, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        int selectedRow = tblFinance.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first from the table to view details");
            return;
        } else {
            WorkRequest request = (InsuranceWorkRequest) tblFinance.getValueAt(selectedRow, 0);
            if (request.getStatus().equals("Sent To Finance Department")) {
                request.setReceiver(userAccount);
                request.setStatus("Pending on " + request.getReceiver().getEmployee().getName());
                populateTable();
                JOptionPane.showMessageDialog(null, "Success !! Request is assigned to you");
            } else {
                JOptionPane.showMessageDialog(null, "Can't assign this work request, as the work request is in " + request.getStatus() + " status", "Warning!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void processRequestBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processRequestBtn2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFinance.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row first from the table to view details");
            return;
        } else {

            InsuranceWorkRequest insuranceWorkRequest = (InsuranceWorkRequest) tblFinance.getValueAt(selectedRow, 0);
            if (insuranceWorkRequest.getStatus().equalsIgnoreCase("Sent To Finance Department")) {
                JOptionPane.showMessageDialog(null, "Assign the request first");
                return;
            }
            if (insuranceWorkRequest.getStatus().equalsIgnoreCase("Insurance Claim Approved")) {
                JOptionPane.showMessageDialog(null, "Request already Completed", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!userAccount.equals(insuranceWorkRequest.getReceiver())) {
                JOptionPane.showMessageDialog(null, "Not Authorized", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!userAccount.getEmployee().equals(insuranceWorkRequest.getReceiver().getEmployee())) {
                JOptionPane.showMessageDialog(null, "Request assigned to other Officer", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (insuranceWorkRequest.getStatus().equals("Insurance Claim Rejected")) {
                JOptionPane.showMessageDialog(null, "Cannot process a Rejected Request", "Warning!", JOptionPane.WARNING_MESSAGE);
                return;
            } else {

                InsuranceFinanceProcessRequest panel = new InsuranceFinanceProcessRequest(userProcessContainer, userAccount, insuranceWorkRequest, enterprise);
                userProcessContainer.add("OfficerProcessWorkRequestJPanel", panel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);

            }
        }
    }//GEN-LAST:event_processRequestBtn2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processRequestBtn2;
    private javax.swing.JTable tblFinance;
    // End of variables declaration//GEN-END:variables

    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) tblFinance.getModel();
        model.setRowCount(0);

        for (WorkRequest workRequest : insuranceFinanceOrganization.getWorkQueue().getWorkRequests()) {
            InsuranceWorkRequest insuranceworkRequest = ((InsuranceWorkRequest) workRequest);
            Object[] row = new Object[8];
            row[0] = insuranceworkRequest;
            row[1] = insuranceworkRequest.getPolicyName();
            row[2] = insuranceworkRequest.getInsuranceCustomer().getInsurance().getCoverage();
            row[3] = insuranceworkRequest.getClaimAmount();
            row[4] = insuranceworkRequest.getBillAmount();
            row[5] = insuranceworkRequest.getStatus();
            row[6] = insuranceworkRequest.getInsuranceCompany();
            row[7] = insuranceworkRequest.getReceiver() == null?"": insuranceworkRequest.getReceiver().getEmployee().getName();

            model.addRow(row);
        }
    }

}
