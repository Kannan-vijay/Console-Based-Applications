package bank;

public class user {
    private int id;
    private String userName;
    private String password;
    private String place;
    private float balance;
    private static int automaticId=0;

    
    public user(String userName, String password, String place) {
        this.id = automaticId;
        this.userName = userName;
        this.password = password;
        this.balance = 0;
        this.place = place;
    }
    public int getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public float getBalance() {
        return balance;
    }
    public String getPlace() {
        return place;
    }
    public void withdraw(int amount){
        balance-=amount;
        System.out.println("\n Remaining Amount will be :"+balance);
    }
    public void addMoney(int amount){
        balance+=amount;
        System.out.println("\n Your Amount will be Added to Your Account sucessfully..");
    }
    public void displayDetails(){
        System.out.println("\nID\tUSER NAME \tPLACE\t BALANCE AMOUNT");
        System.out.println(id+"\t"+userName+"\t"+place+"\t"+balance);
    }
    @Override
    public String toString() {
        return "user [id=" + id + ", userName=" + userName + ", place=" + place + ", balance=" + balance + "]";
    }
}
