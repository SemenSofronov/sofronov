package com.EGAR.auction.Storage;

import com.EGAR.auction.models.Users.Admin;
import com.EGAR.auction.models.Users.Client;
import com.EGAR.auction.models.Users.User;

import java.util.List;

/**
 * Created by Семён on 21.10.2016.
 */
public class ListOfUsers {
    private List<Client> listOfClients;
    private List<Admin> listOfAdmins;

    ListOfUsers() {
        addNewUser(new Client("Dmitriy","123"));
        addNewUser(new Client("Ivan","123"));
        addNewUser(new Client("July","123"));
        addNewUser(new Admin("admin","password"));
    }

    public List<Client> getListOfClients() {
        return listOfClients;
    }

    public List<Admin> getListOfAdmins() {
        return listOfAdmins;
    }

    private void addNewUser(Object user) {
        if (user instanceof Client) {
            listOfClients.add(new Client(((Client) user).getLogin(),((Client) user).getPass()));
        }
        if (user instanceof Admin) {
            listOfAdmins.add(new Admin(((Admin) user).getLogin(), ((Admin) user).getPass()));
        }
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
