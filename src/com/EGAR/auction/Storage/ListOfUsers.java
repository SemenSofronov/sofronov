package com.EGAR.auction.Storage;

import com.EGAR.auction.controller.ControllerAdd;
import com.EGAR.auction.models.Users.Admin;
import com.EGAR.auction.models.Users.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Семён on 21.10.2016.
 */
public class ListOfUsers {
    private static List<Client> listOfClients = new ArrayList<>();
    private static List<Admin> listOfAdmins = new ArrayList<>();

    public ListOfUsers() {
        ControllerAdd.addNewUser(new Client("Dmitriy","123"));
        ControllerAdd.addNewUser(new Client("Ivan","123"));
        ControllerAdd.addNewUser(new Client("July","123"));
        ControllerAdd.addNewUser(new Admin("admin","password"));
    }

    public static List<Client> getListOfClients() {
        return listOfClients;
    }

    public static List<Admin> getListOfAdmins() {
        return listOfAdmins;
    }


    private boolean isRepeat(Object user) {
        if (user instanceof Client) {
            for (Client listOfClient : listOfClients) {
                if (((Client) user).getLogin().equals(listOfClient.getLogin())) {
                    return true;
                }
            }
            return false;
        }
        if (user instanceof Admin) {
            for (Admin listOfAdmin : listOfAdmins) {
                if (((Admin) user).getLogin().equals(listOfAdmin.getLogin())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

}
