package com.EGAR.auction;

import com.EGAR.auction.Storage.*;
import com.EGAR.auction.controller.ControllerAll;
import com.EGAR.auction.view.ViewConsole;

/**
 * Created by Семён on 16.10.2016.
 */
public class Main {
    public static void main(String args[]) {
        new ControllerAll();
        new ListOfUsers();
        new ListOfGoods();
        new ListOfBets();
        new ViewConsole();
    }
}
