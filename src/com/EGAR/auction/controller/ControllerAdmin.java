package com.EGAR.auction.controller;

import com.EGAR.auction.Storage.ListOfBets;
import com.EGAR.auction.Storage.ListOfGoods;
import com.EGAR.auction.models.Goods.Bet;
import com.EGAR.auction.models.Goods.Lot;
import com.EGAR.auction.models.Users.Client;

import java.util.ArrayList;

/**
 * Created by Admin on 24.10.2016.
 */
public class ControllerAdmin implements Controller{

    public ControllerAdmin() {

    }

    public static ArrayList<Lot> listOfLotsByUser(Client owner) {
        ArrayList<Lot> listOfLots = new ArrayList<>();
        for (int i = 0; i < ListOfGoods.getListOfGoods().size(); i++) {
            if (ListOfGoods.getListOfGoods().get(i).getOwner().equals(owner)) {
                listOfLots.add(ListOfGoods.getListOfGoods().get(i));
            }
        }
        return listOfLots;
    }

    public static ArrayList<Bet> listOfBetsByUser(Client owner) {
        ArrayList<Bet> listOfBets = new ArrayList<>();
        for (int i = 0; i < ListOfBets.getListOfBets().size(); i++) {
            if (ListOfBets.getListOfBets().get(i).getOwner().equals(owner)) {
                listOfBets.add(ListOfBets.getListOfBets().get(i));
            }
        }
        return listOfBets;
    }

}
