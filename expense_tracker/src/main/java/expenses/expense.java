package expenses;

public class expense {
    int id;
    String date;
    int amount;
    String type;
    public expense(int id, int amount, String type, String date ) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("%-5d %-10s %-7d %-10s", id, date, amount, type);
    }
}
