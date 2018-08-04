package com.example.moizzahid.classtest;

public class ListItem {
    private String head;
    private String phone;
    private String pass;
    private String email;


    public ListItem(String head, String phone, String pass, String email) {
        this.head = head;
        this.phone = phone;
        this.pass = pass;
        this.email = email;
    }

    public String getNum() {
        return head;
    }

    public String getPhone() {
        return phone;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() { return email; }
}
