import java.util.ArrayList;

public class LiftHandler {
    ArrayList<Lift> lifts;
    public LiftHandler(){
        lifts = new ArrayList<>();
        assignLiftpossitions();
    }
    private void assignLiftpossitions(){
        for (int i = 1; i <= 5; i++) {
            Lift newLift = new Lift(i);
            if(i==1 || i==2){
                newLift.addStops(new int[]{0,1,2,3,4,5});
            }
            else if(i==3 || i==4){
                newLift.addStops(new int[]{0,6,7,8,9,10});
            }
            else{
                newLift.addStops(new int[]{0,1,2,3,4,5,6,7,8,9,10});
            }
            lifts.add(newLift);
        }
    }
    public void assignLift(int from,int to){
        String direction = (to-from < 0) ? "DOWN" : "UP";
        int minDist = Integer.MAX_VALUE;
        Lift selectedLift = null;
        for (Lift lift : lifts) {
            int dist = Math.abs(lift.liftPosition - from);
            if(lift.checkStop(from,to) && dist<minDist){
                selectedLift = lift;
                minDist = dist;
            }
            else if(lift.checkStop(from,to) && dist == minDist){
                if(direction.equals(lift.liftDirection) && (lift.calculateStops(from, to) < selectedLift.calculateStops(from, to))){
                    selectedLift = lift;
                }
            }
        }
        System.out.println("\n"+selectedLift.liftId + " Was Assigned");
        if (selectedLift.liftId==1 || selectedLift.liftId==2) {
            if(to == 5){
                selectedLift.liftDirection = "DOWN";
            }
            else if(to == 0){
                selectedLift.liftDirection = "UP";
            }
            selectedLift.liftPosition = to;
        }
        else{
            if (to == 10) {
                selectedLift.liftDirection = "DOWN";
            }
            else if(to == 0){
                selectedLift.liftDirection = "UP";
            }
            selectedLift.liftPosition = to;
        }
        displayLiftStatus();
    }
    public void displayLiftStatus(){
        System.out.print("\n\nLift  : ");
        for (Lift lift : lifts) {
            System.out.print("L"+lift.liftId +"\t");
        }
        System.out.println();
        System.out.print("Floor : ");
        for (Lift lift : lifts) {
            System.out.print(lift.liftPosition+"\t");
        }
    }
}
