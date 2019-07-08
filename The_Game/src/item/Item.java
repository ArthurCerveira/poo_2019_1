/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package item;

import character.Hero;

/**
 *
 * @author arthur
 */
public abstract class Item {
    private String name;
    private int weight;
    private int price;
    
    //construtor para itens na sala
    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    //construtor para itens que serao vendidos
    public Item(String name, int weight, int price){
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }
    
    public abstract boolean useItem(Hero hero);

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
