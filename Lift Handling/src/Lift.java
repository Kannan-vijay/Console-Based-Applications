import java.util.*;
public class Lift {
    int liftId;
    int liftPosition;
    String liftDirection;
    ArrayList<Integer> liftStops;
    public Lift(int liftId) {
        this.liftId = liftId;
        this.liftPosition = 0;
        this.liftDirection = "UP";
        this.liftStops = new ArrayList<>();
    }
    public void addStops(int[] stops){
        for (int i : stops) {
            liftStops.add(i);
        }
    }
    public boolean checkStop(int from,int to){
        return liftStops.contains(from) && liftStops.contains(to);
    }
    public int calculateStops(int from,int to){
        int stop = 0;
        if(to - from < 0){
            for (int i = from; i >= to; i--) {
                if(liftStops.contains(i))
                    stop++;
            }
            return stop;
        }
        for (int i = from; i < to; i++) {
            if (liftStops.contains(i)) {
                stop++;
            }
        }
        return stop;
    }
}
