package functions;
public class HourToMinute {
    public int getMinute(String begin){
        String[] vet = begin.split(":");
        int minutes = (Integer.parseInt(vet[0])*60) + Integer.parseInt(vet[1]);
        return minutes;
    }
}
