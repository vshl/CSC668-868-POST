/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.presentation;

import com.post.controllers.ProductController;
import com.post.transport.rmi.ProductSpecification;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Sammy
 */
public class ProductPanel extends javax.swing.JPanel {
        ProductController controller;
	/**
	 * Creates new form ProductPanel
	 */
	public ProductPanel() {
		initComponents();
	}
        
        public void registerController(ProductController controller)
        {
            this.controller = controller;
        }
        
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        upcLabel = new javax.swing.JLabel();
        upcComboBox = new javax.swing.JComboBox();
        quantityLabel = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        enterButton = new javax.swing.JButton();

        upcLabel.setText("UPC");

        upcComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        upcComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcComboBoxActionPerformed(evt);
            }
        });

        quantityLabel.setText("Quantity");

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        enterButton.setText("ENTER");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(upcLabel)
                        .addGap(18, 18, 18)
                        .addComponent(upcComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(quantityLabel)
                        .addGap(18, 18, 18)
                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(enterButton)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upcLabel)
                    .addComponent(upcComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabel)
                    .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(enterButton)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void upcComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcComboBoxActionPerformed
        System.out.println("Other Thing Happened");
    }//GEN-LAST:event_upcComboBoxActionPerformed

    private void enterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterButtonActionPerformed
        String upc = (String)upcComboBox.getSelectedItem();
        Integer quantity = (Integer)quantitySpinner.getValue();
            try {
                controller.addLineItem(upc,quantity);
            } catch (RemoteException ex) {
                Logger.getLogger(ProductPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_enterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enterButton;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JComboBox upcComboBox;
    private javax.swing.JLabel upcLabel;
    // End of variables declaration//GEN-END:variables

    //TitledBorder product;
    //product = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);

    public void populateUpc(List<ProductSpecification> allProducts) throws RemoteException {
        upcComboBox.removeAllItems();
        for (ProductSpecification ps : allProducts)
            upcComboBox.addItem(ps.getUpc());
    }
}
