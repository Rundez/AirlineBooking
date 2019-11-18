package Classes;

import java.io.Serializable;

public class Customer implements Serializable {
    private int personID;
    private int firstName;
    private int lastName;
    private int money;
    private String dob;
    private int phoneNumber;
    private String email;
    private String password;
    private int accountMoney;


    public int getAccountMoney() {
        return accountMoney;
    }

    public Customer(){

    }

    public int getMoney() {
        return money;
    }
    public int getPersonID() {
        return personID;
    }

    public void setAccountMoney(int accountMoney) {
        this.accountMoney = accountMoney;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getFirstName() {
        return firstName;
    }

    public void setFirstName(int firstName) {
        this.firstName = firstName;
    }

    public int getLastName() {
        return lastName;
    }

    public void setLastName(int lastName) {
        this.lastName = lastName;
    }
}