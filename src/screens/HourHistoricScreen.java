package screens;

import functions.GetDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connectionbd.ConnectionModule;
import functions.AfterDate;
import functions.BeforeDate;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author willi
 */
public class HourHistoricScreen extends javax.swing.JFrame {
    Connection connection = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int x=0;
    int selects=0;
    ArrayList<String> begins = new ArrayList<String>();
    ArrayList<String> ends = new ArrayList<String>();
    
    public HourHistoricScreen() {
        initComponents();
        ConnectionModule connect = new ConnectionModule();
        connection = connect.getConnectionMySQL();
        URL adress = getClass().getResource("/images/icon.png");
        Image icon = Toolkit.getDefaultToolkit().getImage(adress);
        this.setIconImage(icon);
    }
    private void filter(){
        clearTable();
        begins.clear();
        ends.clear();
        getBegin();
        getEnd();
        insertInTable();
    }
    private void clearTable(){
        DefaultTableModel table = (DefaultTableModel) tablePlanning.getModel();
        for(int i=table.getRowCount()-1; i >= 0; i--){
            table.removeRow(i);
        }
    }
    private void insertInTable(){
        DefaultTableModel table = (DefaultTableModel) tablePlanning.getModel();
        int aux = 0;
        while(true){
            if(aux<begins.size()&&aux<ends.size()){
                String[] data = {Integer.toString(aux+1), begins.get(aux), ends.get(aux)};
                table.addRow(data);
            }
            else if(aux<begins.size()){
                String[] data = {Integer.toString(aux+1), begins.get(aux)};
                table.addRow(data);
            }
            else{
                break;
            }
            aux++;
        }
    }
    private void getBegin(){
        selects=0;
        String sqlnome = "select min(beginning) from presentshotting where dats = ? group by shot";
        try {
            pst = connection.prepareStatement(sqlnome);
            pst.setString(1,inputDateFilter.getText());
            rs = pst.executeQuery();
            while (rs.next()) {
                begins.add(rs.getString(1));
                selects++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    private void getEnd(){
        selects=0;
        String sqlnome = "select max(ending) from workfinish where dats = ? group by shot";
        try {
            pst = connection.prepareStatement(sqlnome);
            pst.setString(1,inputDateFilter.getText());
            rs = pst.executeQuery();
            while (rs.next()) {
                ends.add(rs.getString(1));
                selects++;
            }
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

        txtShotHistoric = new javax.swing.JLabel();
        imageBefore = new javax.swing.JLabel();
        imageAfter = new javax.swing.JLabel();
        inputDateFilter = new javax.swing.JFormattedTextField();
        buttonFilter = new javax.swing.JButton();
        tableExistingPlan = new javax.swing.JScrollPane();
        tablePlanning = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Rodagens");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtShotHistoric.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        txtShotHistoric.setText("HISTÓRICO DE RODAGENS");

        imageBefore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LeftArrow.png"))); // NOI18N
        imageBefore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageBeforeMouseClicked(evt);
            }
        });

        imageAfter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/RightArrow.png"))); // NOI18N
        imageAfter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAfterMouseClicked(evt);
            }
        });

        try {
            inputDateFilter.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        inputDateFilter.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inputDateFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputDateFilterKeyPressed(evt);
            }
        });

        buttonFilter.setText("FILTRAR");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });
        buttonFilter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buttonFilterKeyPressed(evt);
            }
        });

        tablePlanning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rodagem", "Começo", "Fim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableExistingPlan.setViewportView(tablePlanning);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtShotHistoric)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(imageBefore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputDateFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageAfter)
                .addGap(56, 56, 56)
                .addComponent(buttonFilter)
                .addGap(15, 377, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableExistingPlan)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtShotHistoric)
                .addGap(18, 18, 18)
                .addComponent(tableExistingPlan, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonFilter, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imageBefore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputDateFilter)
                        .addComponent(imageAfter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        setSize(new java.awt.Dimension(777, 506));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inputDateFilterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputDateFilterKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(inputDateFilter.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR, INSIRA UMA DATA!");
            }
            else{
                filter();
            }
        }
    }//GEN-LAST:event_inputDateFilterKeyPressed

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed
        if(inputDateFilter.getText().equals("")){
            JOptionPane.showMessageDialog(null, "POR FAVOR, INSIRA UMA DATA!");
        }
        else{
            filter();
        }
    }//GEN-LAST:event_buttonFilterActionPerformed

    private void buttonFilterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonFilterKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            if(inputDateFilter.getText().equals("")){
                JOptionPane.showMessageDialog(null, "POR FAVOR, INSIRA UMA DATA!");
            }
            else{
                filter();
            }
        }
    }//GEN-LAST:event_buttonFilterKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if(x==0){
            x++;
            GetDate getDate = new GetDate();
            inputDateFilter.setText(getDate.informDate());
            getBegin();
            getEnd();
            insertInTable();
        }
    }//GEN-LAST:event_formWindowActivated

    private void imageBeforeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageBeforeMouseClicked
        if(inputDateFilter.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "POR FAVOR, INSIRA UMA DATA!");
        }
        else if(inputDateFilter.getText().length()<10){
            JOptionPane.showMessageDialog(null, "POR FAVOR, INSIRA UMA DATA CORRETA!");
        }
        else{
            BeforeDate beforeDate = new BeforeDate();
            try {
                inputDateFilter.setText(beforeDate.informDate(inputDateFilter.getText()));
                filter();
            } catch (ParseException ex) {
                Logger.getLogger(HourHistoricScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_imageBeforeMouseClicked

    private void imageAfterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAfterMouseClicked
        if(inputDateFilter.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "POR FAVOR, INSIRA UMA DATA!");
        }
        else if(inputDateFilter.getText().length()<10){
            JOptionPane.showMessageDialog(null, "POR FAVOR, INSIRA UMA DATA CORRETA!");
        }
        else{
            AfterDate afterDate = new AfterDate();
            try {
                inputDateFilter.setText(afterDate.informDate(inputDateFilter.getText()));
                filter();
            } catch (ParseException ex) {
                Logger.getLogger(HourHistoricScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_imageAfterMouseClicked

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
            java.util.logging.Logger.getLogger(HourHistoricScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HourHistoricScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HourHistoricScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HourHistoricScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HourHistoricScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFilter;
    private javax.swing.JLabel imageAfter;
    private javax.swing.JLabel imageBefore;
    private javax.swing.JFormattedTextField inputDateFilter;
    private javax.swing.JScrollPane tableExistingPlan;
    private javax.swing.JTable tablePlanning;
    private javax.swing.JLabel txtShotHistoric;
    // End of variables declaration//GEN-END:variables
}
