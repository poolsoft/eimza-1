/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esignerclientjava.forms;

import esign.lib.ESignUtil;
import esignerclientjava.beans.SignFileBean;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sun.security.pkcs11.wrapper.PKCS11Exception;
import tr.gov.tubitak.uekae.esya.api.asn.x509.ECertificate;
import tr.gov.tubitak.uekae.esya.api.common.ESYAException;
import tr.gov.tubitak.uekae.esya.api.signature.SignatureException;
import tr.gov.tubitak.uekae.esya.api.smartcard.pkcs11.LoginException;

/**
 *
 * @author cihan
 */
public class SignForm extends javax.swing.JDialog {

    esign.lib.ESignUtil esignUtil;
    List<ECertificate> certificates;
    SignFileBean signFileBean;
    esignerclientjava.ws.WSFileManagerSoap fileManagerSoap;

    /**
     * Creates new form SignForm
     */
    public SignForm(java.awt.Frame parent, boolean modal, SignFileBean signFileBean, esignerclientjava.ws.WSFileManagerSoap fileManagerSoap) {
        super(parent, modal);
        try {
            initComponents();
            cmbSmartCards.removeAllItems();
            esignUtil = new ESignUtil();
            this.signFileBean = signFileBean;
            this.fileManagerSoap = fileManagerSoap;
            //ClassLoader classLoader = getClass().getClassLoader();
            InputStream isLicense = new FileInputStream("c:\\lisans\\lisans.xml"); //classLoader.getResourceAsStream("c:\\lisans\\lisans.xml");

            esignUtil.setLicenseXml(isLicense);
            esignUtil.configFile = "c:\\config\\esya-signature-config.xml";
            esignUtil.policyFile = "c:\\config\\certval-policy.xml";
            String[] terminals = esignUtil.getTerminals();
            for (int i = 0; i < terminals.length; i++) {
                cmbSmartCards.addItem(terminals[i]);
            }
        } catch (ESYAException | FileNotFoundException ex) {
            Logger.getLogger(SignForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
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

        cmbSmartCards = new javax.swing.JComboBox<>();
        cmbCertificates = new javax.swing.JComboBox<>();
        txtPinCode = new javax.swing.JPasswordField();
        btnSign = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbSmartCards.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSmartCardsİtemStateChanged(evt);
            }
        });

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("esignerclientjava/forms/messages"); // NOI18N
        btnSign.setText(bundle.getString("signFile")); // NOI18N
        btnSign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignActionPerformed(evt);
            }
        });

        jLabel1.setText(bundle.getString("smartCards")); // NOI18N

        jLabel2.setText(bundle.getString("certificates")); // NOI18N

        jLabel3.setText(bundle.getString("pinCode")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCertificates, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbSmartCards, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSign)
                            .addComponent(txtPinCode, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSmartCards, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCertificates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPinCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSign)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSmartCardsİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSmartCardsİtemStateChanged
        if (cmbSmartCards.getSelectedIndex() > -1) {
            String terminal = cmbSmartCards.getItemAt(cmbSmartCards.getSelectedIndex());
            if (!terminal.isEmpty()) {
                try {
                    certificates = esignUtil.getSignatureCertificates(terminal);
                    for (int i = 0; i < certificates.size(); i++) {
                        cmbCertificates.addItem(certificates.get(i).getSubject().toShortTitle());
                    }
                } catch (ESYAException ex) {
                    Logger.getLogger(SignForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PKCS11Exception ex) {
                    Logger.getLogger(SignForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SignForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_cmbSmartCardsİtemStateChanged

    private void btnSignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignActionPerformed
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("esignerclientjava/forms/messages");
        if (cmbSmartCards.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, bundle.getString("selectASmartCard"));
        }
        if (cmbCertificates.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, bundle.getString("selectACertificate"));
        }

        if (txtPinCode.getPassword().length == 0) {
            JOptionPane.showMessageDialog(rootPane, bundle.getString("enterPinCode"));
        }
        String pinCode = new String(txtPinCode.getPassword());
        String terminal = cmbSmartCards.getItemAt(cmbSmartCards.getSelectedIndex());
        byte[] fileBytes = fileManagerSoap.getFileBytes(signFileBean.getDocumentId(), signFileBean.getSessionID());
        Path currentRelativePath = Paths.get("");
        String tempPath = currentRelativePath.toAbsolutePath().toString().concat("\\tmp.pdf");
        try {
            File f = new File(tempPath);
            if (f.exists()) {
                f.delete();
            }
            try (FileOutputStream fileOutputStream = new FileOutputStream(f)) {
                fileOutputStream.write(fileBytes);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            byte[] signedBytes = esignUtil.signPdfWithSmartCard(terminal, certificates.get(cmbCertificates.getSelectedIndex()), pinCode, tempPath);
            if (fileManagerSoap.uploadSignedFile(signFileBean.getDocumentId(), signedBytes)) {
                JOptionPane.showMessageDialog(rootPane, bundle.getString("signedSuccess"));
            }
        } catch (LoginException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(SignForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException | PKCS11Exception | IOException | ESYAException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(SignForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSignActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSign;
    private javax.swing.JComboBox<String> cmbCertificates;
    private javax.swing.JComboBox<String> cmbSmartCards;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPinCode;
    // End of variables declaration//GEN-END:variables
}