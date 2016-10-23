package com.EGAR.auction.controller;

import com.EGAR.auction.Storage.ListOfBets;
import com.EGAR.auction.Storage.ListOfGoods;
import com.EGAR.auction.Storage.ListOfUsers;
import com.EGAR.auction.models.Goods.Bet;
import com.EGAR.auction.models.Goods.Lot;
import com.EGAR.auction.models.Users.Admin;
import com.EGAR.auction.models.Users.Client;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Семён on 20.10.2016.
 */
//разделить контроллер
public class ControllerAll {

    public ControllerAll() {
    }

    public static void addNewLot(Lot lot) {
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

    public static ArrayList<Lot> listOfLotsByCategory(String category){
        return ListOfGoods.getListOfGoods().stream().filter(listOfLot -> listOfLot.getCategory().equals(category)).collect(Collectors.toCollection(ArrayList::new));
    }

    public static Lot searchLotByName (String name) {
        Lot lotByName = new Lot();
        for (Lot listOfLot : listOfLots) {
            if (listOfLot.getName().equals(name)) {
                lotByName = listOfLot;
                break;
            }
        }
        return lotByName;
    }


    public static ArrayList<Lot> listOfLotsByUser(String owner) {
        return listOfLots.stream().filter(listOfLot -> listOfLot.getOwner().equals(owner)).collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<Bet> showingBetsByUser(String owner) {
        ArrayList<Bet> betsForUser = new ArrayList<>();
        for (Lot listOfLot : listOfLots) {
            for (int j = 0; j < listOfLot.listOfBets.size(); j++) {
                if (listOfLot.listOfBets.get(j).getOwner().equals(owner)) {
                    betsForUser.add(listOfLot.listOfBets.get(j));
                }
            }
        }
        return betsForUser;
    }
}
