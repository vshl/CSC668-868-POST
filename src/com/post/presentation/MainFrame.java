/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.post.presentation;

import com.post.controllers.FrameController;
import com.post.client.Post;
import com.post.transport.rmi.PostManager;
import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnmarshalException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Sammy
 */
public class MainFrame extends javax.swing.JFrame {
        private PostManager store;
        private FrameController mediator;
        
                
                
    
	/**
	 * Creates new form MainFrame
	 */
	public MainFrame() throws RemoteException {
		initComponents();
		this.setTitle("POST terminal");
		TitledBorder product, invoice, payment;
		product = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Product", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
		invoice = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Invoice", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
		payment = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Payment", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER);
		productPanel.setBorder(product);
		invoicePanel.setBorder(invoice);
		paymentPanel.setBorder(payment);
                
                // if RMI registry is connected properly, pass remote reference
                // to Mediator
                if(initRmi())
                {
                    Post post = new Post(store);
                    mediator = new FrameController(post);
                }    
                else
                    mediator = new FrameController(null);
                
                mediator.registerCustomerController(customerPanel);
                //mediator.registerDateController(datePanel);
                mediator.registerInvoiceController(invoicePanel);
                mediator.registerPaymentController(paymentPanel);
                mediator.registerProductController(productPanel);
                
                
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        productPanel = new com.post.presentation.ProductPanel();
        customerPanel = new com.post.presentation.CustomerPanel();
        invoicePanel = new com.post.presentation.InvoicePanel();
        paymentPanel = new com.post.presentation.PaymentPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(customerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
                try {
                    new MainFrame().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.post.presentation.CustomerPanel customerPanel;
    private com.post.presentation.InvoicePanel invoicePanel;
    private com.post.presentation.PaymentPanel paymentPanel;
    private com.post.presentation.ProductPanel productPanel;
    // End of variables declaration//GEN-END:variables

    private boolean initRmi() {
        if(System.getSecurityManager() == null)
            System.setSecurityManager(new SecurityManager());
            
        //System.setProperty("java.security.policy","file:./permission.policy");
        
        try{
            System.out.println("Finding Registry");
            Registry rmtReg = LocateRegistry.getRegistry();
            
            System.out.println("Binding remote reference to StoreInterface");
             this.store = (PostManager)rmtReg.lookup("postManagerServer");
           
        }
        catch(RemoteException ex)
        {
            ex.printStackTrace();
            return false;
        }catch(NotBoundException ex)
        {
            ex.printStackTrace();
            return false;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        
        return true;
        
    }


}
