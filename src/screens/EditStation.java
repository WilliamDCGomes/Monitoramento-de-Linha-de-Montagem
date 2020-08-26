/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

/**
 *
 * @author willi
 */
public class EditStation extends javax.swing.JFrame {

    /**
     * Creates new form EditStation
     */
    public EditStation() {
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

        txtNumberOfStation = new javax.swing.JLabel();
        txtLogin = new javax.swing.JLabel();
        txtPassword = new javax.swing.JLabel();
        inputNumberOfStation = new javax.swing.JTextField();
        inputLogin = new javax.swing.JTextField();
        txtConfirmPassword = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        inputConfirmPassword = new javax.swing.JPasswordField();
        txtNewStation = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        buttonLocale = new javax.swing.JButton();
        txtOldPassword = new javax.swing.JLabel();
        inputOldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Estação");

        txtNumberOfStation.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtNumberOfStation.setText("NÚMERO DA ESTAÇÃO");

        txtLogin.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtLogin.setText("LOGIN");

        txtPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtPassword.setText("SENHA");

        inputNumberOfStation.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        inputLogin.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        txtConfirmPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtConfirmPassword.setText("CONFIRMAR SENHA");

        inputPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        inputConfirmPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        txtNewStation.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtNewStation.setText("EDITAR ESTAÇÃO");

        buttonSave.setText("SALVAR");

        buttonLocale.setText("LOCALIZAR");

        txtOldPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtOldPassword.setText("ANTIGA SENHA");

        inputOldPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNewStation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLocale)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonSave)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLogin)
                                        .addComponent(txtNumberOfStation, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtPassword)
                                        .addComponent(txtConfirmPassword))
                                    .addComponent(txtOldPassword))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inputPassword)
                                    .addComponent(inputLogin)
                                    .addComponent(inputConfirmPassword)
                                    .addComponent(inputNumberOfStation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(inputOldPassword, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(txtNewStation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumberOfStation)
                    .addComponent(inputNumberOfStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLocale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin)
                    .addComponent(inputLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOldPassword)
                    .addComponent(inputOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmPassword)
                    .addComponent(inputConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(buttonSave)
                .addGap(45, 45, 45))
        );

        setSize(new java.awt.Dimension(416, 476));
        setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(EditStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLocale;
    private javax.swing.JButton buttonSave;
    private javax.swing.JPasswordField inputConfirmPassword;
    private javax.swing.JTextField inputLogin;
    private javax.swing.JTextField inputNumberOfStation;
    private javax.swing.JPasswordField inputOldPassword;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JLabel txtConfirmPassword;
    private javax.swing.JLabel txtLogin;
    private javax.swing.JLabel txtNewStation;
    private javax.swing.JLabel txtNumberOfStation;
    private javax.swing.JLabel txtOldPassword;
    private javax.swing.JLabel txtPassword;
    // End of variables declaration//GEN-END:variables
}
