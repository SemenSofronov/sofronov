package com.EGAR.auction.Storage;

import com.EGAR.auction.controller.Controller;
import com.EGAR.auction.models.Goods.Lot;

import java.util.List;


/**
 * Created by Семён on 21.10.2016.
 */
public class ListOfGoods {

    private static List<Lot> listOfGoods;

    public ListOfGoods() {
        Controller.addNewLot(new Lot(ListOfUsers.getListOfClients().get(0), "Computers", "Mac-Book-987", 1, 50000, 75000));
        Controller.addNewLot(new Lot(ListOfUsers.getListOfClients().get(0), "Computers", "Mac-Book-2000", 1, 70000, 750000));
        Controller.addNewLot(new Lot(ListOfUsers.getListOfClients().get(1), "Food", "Eggs", 10, 50, 60));
        Controller.addNewLot(new Lot(ListOfUsers.getListOfClients().get(2), "Paper", "Paper-Hearts", 999, 20000, 75000));
    }

    public static List<Lot> getListOfGoods() {
        return listOfGoods;
    }


    private boolean isRepeat (Lot lot) {
        for (Lot listOfGood : listOfGoods) {
            if (lot.equals(listOfGood)) {
                return true;
            }
        }
        return false;
    }
}
