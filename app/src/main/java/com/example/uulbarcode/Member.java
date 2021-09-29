package com.example.uulbarcode;

public class Member {
    String NAME;
    int ID;
    String DEPARTMENT;
    String EMAIL;
    String Phone_No;
    String Blood_G;
    String Skills;
    String ReasonToJoin;
    String T_ShirtSize;


    public Member(String NAME, int ID, String DEPARTMENT, String EMAIL, String phone_No, String blood_G, String skills, String reasonToJoin, String t_ShirtSize) {
        this.NAME = NAME;
        this.ID = ID;
        this.DEPARTMENT = DEPARTMENT;
        this.EMAIL = EMAIL;
        Phone_No = phone_No;
        Blood_G = blood_G;
        Skills = skills;
        ReasonToJoin = reasonToJoin;
        T_ShirtSize = t_ShirtSize;
    }
}
