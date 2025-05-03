import java.time.format.SignStyle;
import java.util.HashMap;

public class TransactionHandler {
    HashMap<String,Integer> originaMap;
    HashMap<String,Integer> tempMap;
    public TransactionHandler() {
        this.originaMap = new HashMap<>();
        this.tempMap = new HashMap<>();
    }
    public void set(String var,int value){
        if(tempMap.containsKey(var)){
            tempMap.put(var, value);
            return;
        }
        tempMap.put(var, value);
    }
    public int get(String var){
        if(!tempMap.containsKey(var)){
            return -1;
        }
        return tempMap.get(var);
    }
    public void update(String var, int val){
        if(tempMap.containsKey(var)){
            tempMap.put(var, val);
            return;
        }
        System.out.println("No variable name "+var);
    }
    public int count(int val){
        int count = 0;
        for (var entry : tempMap.entrySet()) {
            if(entry.getValue() == val){
                count++;
            }
        }
        return count;
    }
    public void unset(String var){
        if(tempMap.containsKey(var)){
            tempMap.remove(var);
            return;
        }
        System.out.println("There is No Variable Available in "+var);
    }
    public void rollBack(){
        tempMap = new HashMap<>();
        for (var entry : originaMap.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
    }
    public void commit(){
        for (var entry : tempMap.entrySet()) {
            originaMap.put(entry.getKey(), entry.getValue());
        }
    }
    public void begin(){
        tempMap = new HashMap<>();
        originaMap = new HashMap<>();
    }

}
