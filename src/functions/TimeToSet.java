package functions;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import conexaobd.ModuloConexao;
import java.awt.Color;
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
    public int shotting;
    public TimeToSet(WorkerScreen worker){
        conexao = ModuloConexao.conector();
        workerScreen = worker;
    }
    public void timeSet(int shot){
        shotting = shot;
        int delay = 100;   // tempo de espera antes da 1ª execução da tarefa.
        int interval = 60000;  // intervalo no qual a tarefa será executada.
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if(workerScreen.x==1){
                    workerScreen.x=2;
                    timer.cancel();
                }
                if(workerScreen.informMoreShots==true){
                    workerScreen.outputBarTime.setValue(0);
                    workerScreen.outputTime.setForeground(Color.green);
                    workerScreen.outputTime.setText("00:00");
                    timer.cancel();
                }
                if(getShot()!=shot){
                    setTime();
                    workerScreen.groupWorkFinish.clearSelection();
                    workerScreen.groupDelay.clearSelection();
                    workerScreen.outputShot.setText(Integer.toString(getShot()));
                    workerScreen.open();
                    timer.cancel();
                }
                else if(stationWorking.hasStation()==false){
                    startShotting.keepProduction(getShot()+1, getHour.informHour());
                    setTime();
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
    private void setTime(){
        TimeDifference timeDifference = new TimeDifference();
        BeginProdution beginProdution = new BeginProdution();
        BarProgress barProgress = new BarProgress(workerScreen);
        GetBeginOfDelay getBeginOfDelay = new GetBeginOfDelay();
        String endTime2 = getBeginOfDelay.getBegin(getShot());
        String difference = timeDifference.getDifference(getHour.informHour(), endTime2);
        if(timeDifference.delay=="true"){
            workerScreen.outputTime.setForeground(Color.red);
            workerScreen.outputTime.setText(difference);
            workerScreen.outputBarTime.setValue(100);
        }
        else{
            workerScreen.outputTime.setForeground(Color.black);
            workerScreen.outputTime.setText(difference);
            barProgress.setBar(beginProdution.getProduction(getShot()), endTime2);
        }
    }
}
