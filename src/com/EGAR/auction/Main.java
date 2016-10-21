package com.EGAR.auction;

import com.EGAR.auction.controller.Controller;
import com.EGAR.auction.models.Goods.Bet;
import com.EGAR.auction.models.Goods.Lot;
import com.EGAR.auction.models.Users.*;
import com.EGAR.auction.view.ViewConsole;

import java.util.Scanner;

/**
 * Created by Семён on 16.10.2016.
 */
public class Main {
    public static void main(String args[]) {
        new Controller();
        Controller.addNewLot("Dmitriy", "Computers", "Mac-Book-987", 1, 50000, 75000);
        Controller.addNewLot("Dmitriy", "Computers", "Mac-Book-2000", 1, 70000, 750000);
        Controller.addNewLot("Ivan", "Food", "Eggs", 10, 50, 60);
        Controller.addNewLot("July", "Paper", "Paper-Hearts", 999, 20000, 75000);
        Controller.addNewBet(Controller.listOfLots.get(0),50000, "July");
        Controller.addNewBet(Controller.listOfLots.get(0),60000, "Dmitriy");
        Controller.addNewBet(Controller.listOfLots.get(1),70000, "Ivan");
        new ViewConsole();
    }
}
