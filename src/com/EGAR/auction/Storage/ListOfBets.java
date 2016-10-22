package com.EGAR.auction.Storage;

import com.EGAR.auction.controller.Controller;
import com.EGAR.auction.models.Goods.Bet;

import java.util.List;

/**
 * Created by Admin on 23.10.2016.
 */
public class ListOfBets {

    private static List<Bet> listOfBets;

    public ListOfBets() {
        Controller.addNewBet(new Bet(ListOfGoods.getListOfGoods().get(0), 50000, ListOfUsers.getListOfClients().get(2)));
        Controller.addNewBet(new Bet(ListOfGoods.getListOfGoods().get(0), 60000, ListOfUsers.getListOfClients().get(0)));
        Controller.addNewBet(new Bet(ListOfGoods.getListOfGoods().get(1), 70000, ListOfUsers.getListOfClients().get(1)));
    }

    public static List<Bet> getListOfBets() {
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
