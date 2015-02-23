/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.presentation;

/**
 *
 * @author Sammy
 */
public class InvoicePanel extends javax.swing.JPanel {

	/**
	 * Creates new form invoicePanel
	 */
	public InvoicePanel() {
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

        itemLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        unitPriceLabel = new javax.swing.JLabel();
        extendedPriceLabel = new javax.swing.JLabel();
        invoiceSceollPane = new javax.swing.JScrollPane();
        invoiceTextArea = new javax.swing.JTextArea();
        totalLabel = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();

        itemLabel.setText("ITEM");

        quantityLabel.setText("QTY");

        unitPriceLabel.setText("UNIT_PRICE");

        extendedPriceLabel.setText("EXTENDED_PRICE");

        invoiceTextArea.setColumns(20);
        invoiceTextArea.setRows(5);
        invoiceSceollPane.setViewportView(invoiceTextArea);

        totalLabel.setText("TOTAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invoiceSceollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(itemLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                        .addComponent(quantityLabel)
                        .addGap(18, 18, 18)
                        .addComponent(unitPriceLabel)
                        .addGap(18, 18, 18)
                        .addComponent(extendedPriceLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totalLabel)
                        .addGap(84, 84, 84)
                        .addComponent(totalPriceLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemLabel)
                    .addComponent(quantityLabel)
                    .addComponent(unitPriceLabel)
                    .addComponent(extendedPriceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoiceSceollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalLabel)
                    .addComponent(totalPriceLabel))
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel extendedPriceLabel;
    private javax.swing.JScrollPane invoiceSceollPane;
    private javax.swing.JTextArea invoiceTextArea;
    private javax.swing.JLabel itemLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JLabel unitPriceLabel;
    // End of variables declaration//GEN-END:variables
}
