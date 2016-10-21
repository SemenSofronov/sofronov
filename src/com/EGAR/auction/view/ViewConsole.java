package com.EGAR.auction.view;

import com.EGAR.auction.controller.Controller;
import com.EGAR.auction.models.Goods.Bet;
import com.EGAR.auction.models.Goods.Lot;
import com.EGAR.auction.models.Users.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Семён on 20.10.2016.
 */
public class ViewConsole {
    private Scanner scanner;
    private User currentUser;

    public ViewConsole(){
        scanner = new Scanner(System.in);
        startMenu();
    }

    public void startMenu() {
        String login;
        String pass;
        String answer;
        boolean flagStart = true;
        while (flagStart) {
        System.out.print("Welcome to the auction!\n");
        System.out.print("Do you want to be a user instead of being a guest? Please, enter 1(yes) or 0(no)\n");
        answer = scanner.next();

            switch (answer) {
                case "1":
                    System.out.print("Please, enter your login\n");
                    login = scanner.next();
                    System.out.print("Please, enter your password\n");
                    pass = scanner.next();
                    if ((login.equals("admin"))&&(pass.equals("password"))){
                        currentUser = new Admin(login, pass);
                        flagStart = false;
                    }
                    else {
                        currentUser = new Client(login, pass);
                        flagStart = false;
                    }
                    System.out.println("Hello, " + currentUser.toString() + " !");
                    break;
                case "0":
                    currentUser = new Guest();
                    flagStart = false;
                    break;
                default:
                    System.out.print("Please, enter 1(yes) or 0(no)\n");

            }
        }

        mainMenu();
    }

    private void mainMenu() {
        String ans;
        String answer;
        boolean flagMain = true;
        while(flagMain) {
        System.out.print("\nMain menu!\n");
        System.out.print("1 - Show lots by category\n");
        System.out.print("2 - Show bets by lot\n");
        System.out.print("3 - Show your lots and its' bets\n");
        System.out.print("4 - Show statistic of user (only admin)\n");
        System.out.print("5 - Exit\n");
        answer = scanner.next();

            switch (answer) {
                case "1":
                    System.out.print("Please, enter category: ");
                    ans = scanner.next();
                    //Controller
                    showLotsByCategory(ans);
                    break;
                case "2":
                    if (currentUser instanceof Guest) {
                        System.out.print("You have no rights!\n");
                    }
                    else {
                        System.out.print("Please, enter name of lot: ");
                        ans = scanner.next();
                        //Controller
                        showBetsByLot(Controller.searchLotByName(ans));
                    }
                    break;
                case "3":
                    if (currentUser instanceof Guest) {
                        System.out.print("You have no rights!\n");
                    }
                    else {
                        if (currentUser instanceof Client) {
                            //Controller
                            showLotsAndBetsForUser(Controller.showingLotsByUser(((Client) currentUser).getLogin()));
                        }
                    }
                    break;
                case "4":
                    if (currentUser instanceof Admin) {
                        System.out.print("Please, enter name of user: ");
                        ans = scanner.next();
                        //Controller
                        showStatistic(Controller.showingLotsByUser(ans), Controller.showingBetsByUser(ans));
                    }
                    else {
                        System.out.print("You have no rights!\n");
                    }
                    break;
                case "5":
                    flagMain = false;
                    break;

            }
        }

    }

    private void showLotsByCategory(String category) {
        ArrayList<Lot> lotsByCategory = Controller.listOfLotsByCategory(category);
        System.out.print("\nName\tCount\tStartPrice\tMaxPrice\n");
        for (int i = 0; i < lotsByCategory.size(); i++) {
            System.out.print("Lot number "+i+"\n");
            System.out.print(lotsByCategory.get(i).getName() + "\t" + lotsByCategory.get(i).getCount() + "\t" + lotsByCategory.get(i).getStartPrice() + "\t" + lotsByCategory.get(i).getMaxPrice() + "\n");
        }
    }

    private void showBetsByLot(Lot lot){
        System.out.print("\nOwner\tPrice\n");
        for (int i = 0; i < lot.listOfBets.size(); i++){
            System.out.print("Bet number "+i+"\n");
            System.out.print(lot.listOfBets.get(i).getOwner() + "\t" + lot.listOfBets.get(i).getPrice() + "\n");
        }
    }

    private static void showLotsAndBetsForUser(ArrayList<Lot> lotsForUser){

        for (int i = 0; i < lotsForUser.size(); i++){
            System.out.print("\nName\tCount\tStartPrice\tMaxPrice\n");
            System.out.print("Lot number "+i+"\n");
            System.out.print(lotsForUser.get(i).getName() + "\t" + lotsForUser.get(i).getCount() + "\t" + lotsForUser.get(i).getStartPrice() + "\t" + lotsForUser.get(i).getMaxPrice() + "\n");
            for (int j = 0; j < lotsForUser.get(i).listOfBets.size(); j++) {
                System.out.print("\nOwner\tPrice\n");
                System.out.print("Bet number "+j+"\n");
                System.out.print(lotsForUser.get(i).listOfBets.get(j).getOwner() + "\t" + lotsForUser.get(i).listOfBets.get(j).getPrice() + "\n");
            }
        }
    }

    private static void showStatistic(ArrayList<Lot> lotsForUser, ArrayList<Bet> betsForUser) {
        System.out.print("\nName\tCount\tStartPrice\tMaxPrice\n");
        for (int i = 0; i < lotsForUser.size(); i++) {
            System.out.print("Lot number "+i+"\n");
            System.out.print(lotsForUser.get(i).getName() + "\t" + lotsForUser.get(i).getCount() + "\t" + lotsForUser.get(i).getStartPrice() + "\t" + lotsForUser.get(i).getMaxPrice() + "\n");
        }
        for (int i = 0; i < betsForUser.size(); i++) {
            System.out.print("Bet number " + i + "\n");
            System.out.print("Name of lot: " + betsForUser.get(i).getLot().getName() + "\t" + "Bet: " + betsForUser.get(i).getPrice() + "\n");
        }

    }


}
