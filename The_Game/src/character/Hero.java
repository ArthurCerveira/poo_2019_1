/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import item.Item;
import character.Character;
import static java.lang.Math.floor;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author aluno
 */
public class Hero extends Character{
    private HashMap<String, Item> Inventory;
    private HashMap<String, Item> equippedItems;
    private int weightLimit;
    private int currentWeight;
    
    
    public Hero(String name, int healthPoints, int attack, int weightLimit, boolean attackable) {
        super(name, healthPoints, attack, attackable);
        Inventory = new HashMap<>();
        equippedItems = new HashMap<>();
        this.weightLimit = weightLimit;
        currentWeight = 0;
        coins = 0;
        
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
            this.decrement(enemy.getAttack());
            enemy.increment();
        }
        else { 
            if (enemyLuck < heroLuck) {
                enemy.decrement(this.getAttack());
                this.increment();
            }
            else {
                this.decrement(enemy.getAttack());
                enemy.decrement(this.getAttack());
            }
        }
    }
    
    //Inventory functions

    public boolean insertItemInventory(String name, Item item) {
        if((item.getWeight() + currentWeight) <= weightLimit) {
            Inventory.put(name, item);
            currentWeight += item.getWeight();
            return true;
        }
        return false;
    }
    
    public boolean insertEquippedItem(String name, Item item) {
        if((item.getWeight() + currentWeight) <= weightLimit) {
            equippedItems.put(name, item);
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
    
    public Item getEquippedItem(String name) {
        return equippedItems.get(name);
    }
    
    public Item removeEquippedItem(String name) {
        Item item = equippedItems.get(name);
        equippedItems.remove(name);
        return item;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }
    
    public void setCurrentWeight(int newWeight){
        currentWeight = newWeight;
    }
    
    public String getStringInventory(){
        String returnString = null;
        
        Set<String> items = Inventory.keySet();
        
        if(!Inventory.isEmpty()) {
            returnString = "Items:";
            
            for (String name : items)
                returnString += " " + name;
        }
        
        return returnString;
    }
    
    public String getStringEquippedItems(){
        String returnString = null;
        
        Set<String> items = equippedItems.keySet();
        
        if(!equippedItems.isEmpty()) {
            returnString = "Equipped items:";
            
            for (String name : items)
                returnString += " " + name;
        }
        
        return returnString;
    }
    
    public String heroInfo() {
        String returnString = "\nName: " + getName() +
                              "\nHP: " + getHealthPoints() + "/" + getMaxHP() +
                              "\nWeight: " + currentWeight + "/" + weightLimit +
                              "\nCoins: " + getCoins() +
                              "\nAttack: " + getAttack();
                              
        if(getStringInventory() != null)
            returnString += "\n" + getStringInventory();
        
        if(getStringEquippedItems() != null)
            returnString += "\n" + getStringEquippedItems();
        
        returnString += "\n";
               
        return returnString;
    }
    
    @Override
    public void setCoins(int coins){
        int weight = currentWeight;
        
        // diminui o valor anterior de peso das moedas
        int coinWeight = this.coins / 200;
        weight -= coinWeight;
        
        // aumenta com o peso atual
        coinWeight = coins / 200;
        weight += coinWeight;
        
        if(weight <= weightLimit ){
            //atualiza valor do peso
            currentWeight = weight;
            //atualiza valor da moeda
            this.coins = coins;
        }
    }
}
