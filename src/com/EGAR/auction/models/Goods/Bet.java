package com.EGAR.auction.models.Goods;

import com.EGAR.auction.models.Users.Client;

/**
 * Created by Семён on 16.10.2016.
 */
public class Bet {
    private Lot lot;
    private int price;
    private Client owner;

    public Bet(Lot lot, int price, Client owner) {
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

    public Client getOwner() {
        return owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (price != bet.price) return false;
        return lot.equals(bet.lot);

    }

    @Override
    public int hashCode() {
        int result = lot.hashCode();
        result = 31 * result + price;
        return result;
    }
}
