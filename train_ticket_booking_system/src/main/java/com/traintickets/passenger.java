package com.traintickets;

public class passenger {
    String passengerId;
    String name;
    int age;
    String gender;
    String ticketId;
    String bedPrefference;
    String allotedBed;
    public passenger(String passengerId, String name, int age, String gender, String ticketId, String bedPrefference,
            String allotedBed) {
        this.passengerId = passengerId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ticketId = ticketId;
        this.bedPrefference = bedPrefference;
        this.allotedBed = allotedBed;
    }
    @Override
    public String toString() {
        return "passengerId=" + passengerId + ", name=" + name + ", age=" + age + ", gender=" + gender
                + ", ticketId=" + ticketId + ", allotedBed=" + allotedBed;
    }
    

}
