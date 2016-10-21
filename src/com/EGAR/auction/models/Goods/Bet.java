package com.EGAR.auction.models.Goods;

import com.EGAR.auction.models.Users.Client;

/**
 * Created by Семён on 16.10.2016.
 */
public class Bet {
    private Lot lot;
    private int price;
    private Client owner;

    public Bet(Lot lot, int price, String owner) {
        this.lot = lot;
        this.price = price;
        this.owner = owner;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public int getPrice() {
        return price;
    }

    public String getOwner() {
        return owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
