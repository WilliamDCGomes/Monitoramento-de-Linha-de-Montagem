package functions;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexaobd.ModuloConexao;
import screens.WorkerScreen;

public class TimeToSet {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    StationWorking stationWorking = new StationWorking();
    StartShotting startShotting = new StartShotting();
    WorkerScreen workerScreen;
    GetHour getHour = new GetHour();
    GetDate getDate = new GetDate();
    public TimeToSet(WorkerScreen worker){
        conexao = ModuloConexao.conector();
        workerScreen = worker;
    }
    public void timeSet(int shot){
        int delay = 100;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 60000;  // intervalo no qual a tarefa será executada.
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                JOptionPane.showMessageDialog(null, "1");
                if(getShot()!=shot){
                    JOptionPane.showMessageDialog(null, "2");
                    workerScreen.setTime();
                    workerScreen.groupWorkFinish.clearSelection();
                    workerScreen.groupDelay.clearSelection();
                    workerScreen.outputShot.setText(Integer.toString(getShot()));
                    workerScreen.open();
                    timer.cancel();
                }
                else if(stationWorking.hasStation()==false){
                    JOptionPane.showMessageDialog(null, "3");
                    startShotting.keepProduction(getShot()+1, getHour.informHour());
                    workerScreen.setTime();
                    workerScreen.groupWorkFinish.clearSelection();
                    workerScreen.groupDelay.clearSelection();
                    workerScreen.outputShot.setText(Integer.toString(getShot()));
                    workerScreen.open();
                    timer.cancel();
                }
            }
        }, delay, interval);
    }
    private int getShot(){
        String sql ="select max(shot) from presentShotting where dats = ?";
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, getDate.informDate());
            rs= pst.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return -1;
    }
}
