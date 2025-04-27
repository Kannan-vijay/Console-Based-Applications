import java.util.HashMap;

public class calenderHandler {
    private  int Date;
    private  int Month;
    private  int Year;
    private HashMap<Integer,String> monthMap;
    

    public calenderHandler() {
        Date = 1;
        Month = 4;
        Year = 2025;
        monthMap = intitalizeHashMap();
    }
    public void setMonthYear(int month,int year){
        this.Month = month;
        this.Year = year;
    }
    public void increamentMonth(){
        Month++;
        if(Month > 12){
            Year++;
            Month = 1;
        }
    }
    public void decreamentMonth(){
        Month--;
        if(Month<1){
            Year--;
            Month = 12;
        }
    }
    public void displayCalender(){
        
        String startingDay = calculateDay(Date, Month, Year);
        int startingGap = calculateStatingGap(startingDay);
        int endDate = calculateEndDate();
        int date = 1;

        System.out.println("-------------------------------------------");
        System.out.println("|               CALENDER                  |");
        System.out.println("-------------------------------------------");
        System.out.println("|    Month = "+monthMap.get(Month)+"    Year = "+Year+"        |");
        System.out.println("-------------------------------------------");
        System.out.printf("|%5s|%5s|%5s|%5s|%5s|%5s|%5s|\n","Sun","Mon","Tue","Wed","Thurs","Fri","Sat");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.print("|");
            for (int j = 0; j < 7; j++) {
                if(startingGap>0 || date>endDate){
                    System.out.printf("%5s|"," ");
                    startingGap--;
                }
                else{
                    System.out.printf("%5s|",date++);
                }
            }
            System.out.println();
            System.out.println("-------------------------------------------");
        }
        if(date < endDate){
            System.out.print("|");
            for (int j = 0; j < 7; j++) {
                if(startingGap>0 || date>endDate){
                    System.out.printf("%5s|"," ");
                    startingGap--;
                }
                else{
                    System.out.printf("%5s|",date++);
                }
            }
            System.out.println();
            System.out.println("-------------------------------------------");
        }
        
    }


    public String calculateDay(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] mon = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
        if (isLeapYear(year) && (month == 1 || month == 2)) {
            mon[1] = 2;
            mon[0] = 6;
        }
        int centuryCode = calculateCenturyCode(year);
        int yearPart = year % 100;
        int leapYearCount = yearPart / 4;
        int idx = (day + mon[month - 1] + centuryCode + yearPart + leapYearCount) % 7;
        return days[idx];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int calculateCenturyCode(int year) {
        int century = year / 100;
        if (century % 4 == 0) return 6;
        if (century % 4 == 1) return 4;
        if (century % 4 == 2) return 2;
        return 0;
    }
    private int calculateEndDate(){
        int[] mon = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(isLeapYear(Year)){
            mon[1] = 29;
        }
        return mon[Month-1];
    }
    private int calculateStatingGap(String day){
        if(day.equals("Sunday")) return 0;
        if(day.equals("Monday")) return 1;
        if(day.equals("Tuesday")) return 2;
        if(day.equals("Wednesday")) return 3;
        if(day.equals("Thursday")) return 4;
        if(day.equals("Friday")) return 5;
        else return 6;
    }
    private HashMap<Integer,String> intitalizeHashMap(){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"January");
        map.put(2,"February");
        map.put(3,"March");
        map.put(4,"April");
        map.put(5,"May");
        map.put(6,"June");
        map.put(7,"July");
        map.put(8,"Auguest");
        map.put(9,"September");
        map.put(10,"October");
        map.put(11,"November");
        map.put(12,"December");
        return map;
    }
}
