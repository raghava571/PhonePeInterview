package models;

public class User {
    String user;
    String phoneNumber;

    User(String user, String phoneNumber){
        this.phoneNumber = phoneNumber;
        this.user = user;
    }
    String getUser(){
        return user;
    }
}
