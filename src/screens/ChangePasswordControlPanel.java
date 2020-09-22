package screens;
import commands.Hash;
import connectionbd.ConnectionModule;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author willi
 */
public class ChangePasswordControlPanel extends javax.swing.JFrame {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form ChangePasswordControlPanel
     */
    public ChangePasswordControlPanel() {
        initComponents();
        ConnectionModule connect = new ConnectionModule();
        connection = connect.getConnectionMySQL();
        URL adress = getClass().getResource("/images/icon.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(adress);
        this.setIconImage(icon);
    }
    boolean hasPassword;
    int x = 0;
    public void checkIfHasPassword(){
        String sql ="select * from access_control_panel";
        try {
            pst=connection.prepareStatement(sql);
            rs= pst.executeQuery();
            if(rs.next()){
                hasPassword=true;
            }
            else{
                hasPassword=false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void getOldPassword(){
        String sqlnome = "select passwors from access_control_panel where passwors = MD5(MD5(MD5(?)))";
        try {
            Hash hash = new Hash();
            pst = connection.prepareStatement(sqlnome);
            pst.setString(1,hash.DoHash(inputOldPassword.getText()));
            rs = pst.executeQuery();
            if (rs.next()) {
                updatePassword();
            }
            else{
                JOptionPane.showMessageDialog(null,"SENHA ANTIGA INCORRETA");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void addPassword(){
        String sql = "insert into access_control_panel(id,passwors)values(1,MD5(MD5(MD5(?))))";
        try {
            Hash hash = new Hash();
            pst = connection.prepareStatement(sql);
            pst.setString(1,hash.DoHash(inputNewPassword.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"SENHA ATUALIZADA COM SUCESSO");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void updatePassword(){
        String sql = "update access_control_panel set passwors=MD5(MD5(MD5(?))) where id=1";
        try {
            Hash hash = new Hash();
            pst=connection.prepareStatement(sql);
            pst.setString(1,hash.DoHash(inputNewPassword.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"SENHA ATUALIZADA COM SUCESSO");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
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

        txtChangePassword = new javax.swing.JLabel();
        txtOldPassword = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JLabel();
        inputOldPassword = new javax.swing.JPasswordField();
        inputNewPassword = new javax.swing.JPasswordField();
        inputConfirmPassword = new javax.swing.JPasswordField();
        buttonSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mudar Senha do Paínel de Controle");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtChangePassword.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtChangePassword.setText("MUDAR SENHA");

        txtOldPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtOldPassword.setText("SENHA ANTIGA");

        txtNewPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtNewPassword.setText("NOVA SENHA");

        txtConfirmPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        txtConfirmPassword.setText("CONFIRMAR SENHA");

        inputOldPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputOldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputOldPasswordKeyPressed(evt);
            }
        });

        inputNewPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputNewPasswordKeyPressed(evt);
            }
        });

        inputConfirmPassword.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        inputConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputConfirmPasswordKeyPressed(evt);
            }
        });

        buttonSave.setText("SALVAR");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });
        buttonSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonSaveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtChangePassword)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSave)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNewPassword)
                            .addComponent(txtOldPassword)
                            .addComponent(txtConfirmPassword))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputOldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(inputNewPassword)
                            .addComponent(inputConfirmPassword))
                        .addGap(54, 54, 54))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtChangePassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOldPassword)
                    .addComponent(inputOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNewPassword)
                    .addComponent(inputNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmPassword)
                    .addComponent(inputConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(buttonSave)
                .addGap(26, 26, 26))
        );

        setSize(new java.awt.Dimension(463, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(x==0){
            x++;
            checkIfHasPassword();
        }
    }//GEN-LAST:event_formWindowActivated

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        if(inputOldPassword.getText().equals("")||inputNewPassword.getText().equals("")||inputConfirmPassword.getText().equals("")){
            JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
        }
        else if(hasPassword==false&&(inputOldPassword.getText().equals("admin")||inputOldPassword.getText().equals("ADMIN"))){
            addPassword();
        }
        else if(hasPassword==true){
            getOldPassword();
        }
        else{
            JOptionPane.showMessageDialog(null, "SENHA ANTIGA INCORRETA");
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void inputOldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputOldPasswordKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            inputNewPassword.requestFocus();
        }
    }//GEN-LAST:event_inputOldPasswordKeyPressed

    private void inputNewPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputNewPasswordKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            inputConfirmPassword.requestFocus();
        }
    }//GEN-LAST:event_inputNewPasswordKeyPressed

    private void inputConfirmPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputConfirmPasswordKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(inputOldPassword.getText().equals("")||inputNewPassword.getText().equals("")||inputConfirmPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
            }
            else if(hasPassword==false&&(inputOldPassword.getText().equals("admin")||inputOldPassword.getText().equals("ADMIN"))){
                addPassword();
            }
            else if(hasPassword==true){
                getOldPassword();
            }
            else{
                JOptionPane.showMessageDialog(null, "SENHA ANTIGA INCORRETA");
            }
        }
    }//GEN-LAST:event_inputConfirmPasswordKeyPressed

    private void buttonSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonSaveKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(inputOldPassword.getText().equals("")||inputNewPassword.getText().equals("")||inputConfirmPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS");
            }
            else if(hasPassword==false&&(inputOldPassword.getText().equals("admin")||inputOldPassword.getText().equals("ADMIN"))){
                addPassword();
            }
            else if(hasPassword==true){
                getOldPassword();
            }
            else{
                JOptionPane.showMessageDialog(null, "SENHA ANTIGA INCORRETA");
            }
        }
    }//GEN-LAST:event_buttonSaveKeyPressed

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
            java.util.logging.Logger.getLogger(ChangePasswordControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePasswordControlPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePasswordControlPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JPasswordField inputConfirmPassword;
    private javax.swing.JPasswordField inputNewPassword;
    private javax.swing.JPasswordField inputOldPassword;
    private javax.swing.JLabel txtChangePassword;
    private javax.swing.JLabel txtConfirmPassword;
    private javax.swing.JLabel txtNewPassword;
    private javax.swing.JLabel txtOldPassword;
    // End of variables declaration//GEN-END:variables
}
