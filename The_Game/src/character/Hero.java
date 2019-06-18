/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import item.Item;
import character.Character;
import java.util.HashMap;

/**
 *
 * @author aluno
 */
public class Hero extends Character{
    private HashMap<String, Item> Inventory;
    private int weightLimit;
    private int currentWeight;
    
    public Hero(String name, int healthPoints, int weightLimit) {
        super(name, healthPoints);
        Inventory = new HashMap<>();
        this.weightLimit = weightLimit;
        currentWeight = 0;
    }
    
    void aliment() {
        increment();
        increment();
    }
    
    void fight(Vilain enemy) {
        // Throw the dice
        int enemyLuck = enemy.luck();
        int heroLuck = this.luck();
        if(enemyLuck > heroLuck) {
            this.decrement();
            enemy.increment();
        }
        else { 
            if (enemyLuck < heroLuck) {
                enemy.decrement();
                this.increment();
            }
            else {
                this.decrement();
                enemy.decrement();
            }
        }
    }
    
    //Inventory functions

    public boolean insertItem(String name, Item item) {
        if((item.getWeight() + currentWeight) <= weightLimit) {
            Inventory.put(name, item);
            currentWeight += item.getWeight();
            return true;
        }
        return false;
    }
    
    public Item getItem(String name) {
        return Inventory.get(name);
    }
    
    public Item removeItem(String name) {
        Item item = Inventory.get(name);
        Inventory.remove(name);
        return item;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }
}
