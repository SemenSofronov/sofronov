package com.EGAR.auction.Storage;

import com.EGAR.auction.controller.ControllerAdd;
import com.EGAR.auction.models.Goods.Bet;

import java.util.ArrayList;

/**
 * Created by Admin on 23.10.2016.
 */
public class ListOfBets {

    private static ArrayList<Bet> listOfBets = new ArrayList<>();

    public ListOfBets() {
        ControllerAdd.addNewBet(new Bet(ListOfGoods.getListOfGoods().get(0), 50000, ListOfUsers.getListOfClients().get(2)));
        ControllerAdd.addNewBet(new Bet(ListOfGoods.getListOfGoods().get(0), 60000, ListOfUsers.getListOfClients().get(0)));
        ControllerAdd.addNewBet(new Bet(ListOfGoods.getListOfGoods().get(1), 70000, ListOfUsers.getListOfClients().get(1)));
    }

    public static ArrayList<Bet> getListOfBets() {
        return listOfBets;
    }

    private boolean isRepeat (Bet bet) {
        for (int i = 0; i < ListOfBets.getListOfBets().size(); i++) {
            if (bet.equals(ListOfBets.getListOfBets().get(i))) {
                return true;
            }
        }
        return false;
    }

}
