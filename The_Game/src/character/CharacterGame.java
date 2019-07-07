/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import item.Item;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author aluno
 */
public abstract class CharacterGame {
    private String name;
    private int maxHP;
    private int healthPoints;
    protected int coins;
    private int attack;
    private boolean attackable;
    private HashMap<String, Item> inventory;

    public CharacterGame(String name, int healthPoints, int attack) {
        this.name = name;
        this.maxHP = healthPoints;
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.inventory = new HashMap<>();
    }    

    public HashMap<String, Item> getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    
    public int getMaxHP() {
        return maxHP;
    }
    
      public void setHealthPoints(int healthPoints) {
        if(healthPoints < maxHP)
          this.healthPoints = healthPoints;
        else this.healthPoints = maxHP;
    }
    
    int luck() {
        System.out.println("Throwing the dice...");
        Random dados = new Random();
        int resultado = dados.nextInt(6) + 1;
        System.out.println(name + " got a " + resultado);
        return resultado;
    }
    
        
    void increment(){
        if(healthPoints < maxHP)
            healthPoints++;
    }
    
    void decrement(int HP) {
        if(healthPoints >= 0)
            healthPoints -= HP;
        else if(healthPoints <= 0)
            System.out.println(name + " has fainted.");
        else
            System.out.println(name + " is already unable to fight.");
    }
    
    void printInfo() {
        String str;
        if(healthPoints < 0)
            healthPoints = 0;
        str = ("#####################\n# Nome: " + name + 
               "\n# Energia: " + healthPoints +"\n#####################");
        System.out.println(str);
    }
    
    int getCoins(){
        return coins;
    }
    
    void setCoins(int coins){
        this.coins = coins;
    }
    
    public int getAttack(){
        return attack;
    }
    
    public void setAttack(int attack){
        this.attack = attack;
    }

    public boolean isAttackable() {
        return attackable;
    }
    
    public void setAttackable(boolean attackable){
        this.attackable = attackable;
    }
    
    public abstract boolean insertItemInventory(Item item);
    
    public abstract String getStringInventory();
    
    public Item getItem(String name) {
        return inventory.get(name);
    }
    
    public Item removeItem(String name) {
        Item item = getInventory().get(name);
        getInventory().remove(name);
        return item;
    }
}


