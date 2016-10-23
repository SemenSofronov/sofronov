package com.EGAR.auction.models.Goods;

import com.EGAR.auction.Storage.ListOfGoods;
import com.EGAR.auction.models.Users.*;

import java.util.ArrayList;

/**
 * Created by Семён on 16.10.2016.
 */
public class Lot {
    private int id;
    private Client owner;
    private String category;
    private String name;
    private int count;
    private int startPrice;
    private int maxPrice;

    public ArrayList<Bet> listOfBets = new ArrayList<>();

    public Lot(Client owner, String category, String name, int count, int startPrice, int maxPrice) {
        this.owner = owner;
        this.category = category;
        this.name = name;
        this.count = count;
        this.startPrice = startPrice;
        this.maxPrice = maxPrice;
    }

    public Lot() {
        this.owner = new Client("","");
        this.category = "";
        this.name = "";
        this.count = 0;
        this.startPrice = 0;
        this.maxPrice = 0;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getStartPrice() {
        return startPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public Client getOwner() {
        return owner;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setStartPrice(int startPrice) {
        this.startPrice = startPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Bet> getListOfBets() {
        return listOfBets;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lot lot = (Lot) o;

        return id == lot.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
