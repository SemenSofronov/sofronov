package com.EGAR.auction.Storage;

import com.EGAR.auction.controller.Controller;
import com.EGAR.auction.models.Goods.Lot;

import java.util.List;

import static com.EGAR.auction.controller.Controller.addNewLot;

/**
 * Created by Семён on 21.10.2016.
 */
public class ListOfGoods {

    private static List<Lot> listOfGoods;

    ListOfGoods() {
        addNewLot(new Lot("Dmitriy", "Computers", "Mac-Book-987", 1, 50000, 75000));
        addNewLot(new Lot("Dmitriy", "Computers", "Mac-Book-2000", 1, 70000, 750000));
        addNewLot(new Lot("Ivan", "Food", "Eggs", 10, 50, 60));
        addNewLot(new Lot("July", "Paper", "Paper-Hearts", 999, 20000, 75000));
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
