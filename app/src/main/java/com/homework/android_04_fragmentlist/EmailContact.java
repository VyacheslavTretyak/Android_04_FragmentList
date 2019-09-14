package com.homework.android_04_fragmentlist;

class EmailContact
{
    public String lastName;
    public String firstName;
    public String email;
    public EmailContact(String lastName, String firstName, String email){
        this.lastName   = lastName;
        this.firstName   = firstName;
        this.email      = email;
    }
    @Override
    public String toString(){
        return "Last Name: " + lastName + "\n" + "First Name: " + firstName + "\n" + "Email: " + email;
    }
}
