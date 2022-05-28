package com.example.a191132_saraalsaud;

public class Student {

    private String ID;
    private String name;
    private String surname;
    private String father;
    private String national;
    private String bday;
    private String gender;

    private String key;

    public Student(){}

    public Student(String ID, String name, String surname, String father, String national, String bday, String gender) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.father = father;
        this.national = national;
        this.bday = bday;
        this.gender = gender;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }
}
