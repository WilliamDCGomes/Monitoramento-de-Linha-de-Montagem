package functions;
public class HourDefault {
    public String getHour(int shotting){
        if(shotting==1){
            return "08:00/09:00";
        }
        else if(shotting==2){
            return "09:00/10:00";
        }
        else if(shotting==3){
            return "10:00/11:00";
        }
        else if(shotting==4){
            return "11:00/12:00";
        }
        else if(shotting==5){
            return "13:00/14:00";
        }
        else if(shotting==6){
            return "14:00/15:00";
        }
        else if(shotting==7){
            return "15:00/16:00";
        }
        else if(shotting==8){
            return "16:00/17:00";
        }
        else{
            return "17:00/18:00";
        }
    }
}
