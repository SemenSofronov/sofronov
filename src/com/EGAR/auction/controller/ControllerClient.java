package com.EGAR.auction.controller;

import com.EGAR.auction.Storage.ListOfBets;
import com.EGAR.auction.Storage.ListOfGoods;
import com.EGAR.auction.models.Goods.Bet;
import com.EGAR.auction.models.Goods.Lot;
import com.EGAR.auction.models.Users.Client;

import java.util.ArrayList;

/**
 * Created by Admin on 23.10.2016.
 */
public class ControllerClient implements Controller {

    public ControllerClient() {

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

    public static ArrayList<Bet> listOfBetsByLotsByUser (ArrayList<Lot> listOfLotsByUser) {
        ArrayList<Bet> listOfBets = new ArrayList<>();
        for (int i = 0; i < listOfLotsByUser.size(); i++) {
            for (int j = 0; j < ListOfBets.getListOfBets().size(); j++) {
                if (ListOfBets.getListOfBets().get(j).getLot().equals(listOfLotsByUser.get(i))) {
                    listOfBets.add(ListOfBets.getListOfBets().get(j));
                }
            }
        }
        return listOfBets;
    }

}
