package com.EGAR.auction.controller;

import com.EGAR.auction.Storage.ListOfBets;
import com.EGAR.auction.Storage.ListOfGoods;
import com.EGAR.auction.Storage.ListOfUsers;
import com.EGAR.auction.models.Goods.Bet;
import com.EGAR.auction.models.Goods.Lot;
import com.EGAR.auction.models.Users.Admin;
import com.EGAR.auction.models.Users.Client;


/**
 * Created by Семён on 20.10.2016.
 */
public class ControllerAdd {

    public ControllerAdd() {
    }

    public static void addNewLot(Lot lot) {
        int id = ListOfGoods.getListOfGoods().size();
        lot.setId(id);
        ListOfGoods.getListOfGoods().add(lot);
    }

    public static void addNewUser(Object user) {
        if (user instanceof Client) {
            ListOfUsers.getListOfClients().add((Client) user);
        }
        if (user instanceof Admin) {
            ListOfUsers.getListOfAdmins().add((Admin) user);
        }
    }

    public static void addNewBet (Bet bet) {
        ListOfBets.getListOfBets().add(bet);
    }
}
