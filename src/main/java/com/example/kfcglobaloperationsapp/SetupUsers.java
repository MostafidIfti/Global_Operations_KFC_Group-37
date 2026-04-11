package com.example.kfcglobaloperationsapp;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SetupUsers {
    public static void main(String[] args) {
        ArrayList<User> userList = new ArrayList<>();

        // 1. Abu Hanif's Users
        userList.add(new User("hanif_regional", "123", "Regional Manager"));
        userList.add(new User("hanif_outlet", "123", "Outlet Manager"));

        // 2. Your Users (Mostafid Ifti)
        userList.add(new User("ifti_supply", "123", "Supply Chain Manager"));
        userList.add(new User("ifti_finance", "123", "Finance Manager"));

        // 3. Uzair Ahmed Khan's Users
        userList.add(new User("uzairC", "123", "Cashier"));
        userList.add(new User("uzairK", "123", "Kitchen Supervisor"));

        // Saving them to the users.bin file
        try {
            FileOutputStream fileOut = new FileOutputStream("users.bin");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(userList);

            out.close();
            fileOut.close();
            System.out.println("Success! users.bin has been created with 6 users.");

        } catch (Exception e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }
}