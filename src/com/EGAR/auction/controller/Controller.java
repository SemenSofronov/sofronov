package com.EGAR.auction.controller;

import com.EGAR.auction.Storage.ListOfBets;
import com.EGAR.auction.Storage.ListOfGoods;
import com.EGAR.auction.models.Goods.Bet;
import com.EGAR.auction.models.Goods.Lot;

import java.util.ArrayList;

/**
 * Created by Admin on 23.10.2016.
 */
public interface Controller {

    static ArrayList<Lot> listOfLotsByCategory(String category){
        ArrayList<Lot> listOfLots = new ArrayList<>();
        for (int i = 0; i < ListOfGoods.getListOfGoods().size(); i++) {
            if (ListOfGoods.getListOfGoods().get(i).getCategory().equals(category)) {
                listOfLots.add(ListOfGoods.getListOfGoods().get(i));
            }
        }
        return listOfLots;
    }

    static ArrayList<Bet> listOfBetsByLot (Lot lot) {
        ArrayList<Bet> listOfBets = new ArrayList<>();
        for (int i = 0; i < ListOfBets.getListOfBets().size(); i++) {
            if (lot.equals(ListOfBets.getListOfBets().get(i).getLot())) {
                listOfBets.add(ListOfBets.getListOfBets().get(i));
            }
        }
        return listOfBets;
    }

}
