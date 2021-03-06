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
public class Potion extends Item{
    private int healthPoints;
    
    public Potion(String name, int weight, int healthPoints) {
        super(name, weight);
        this.healthPoints = healthPoints;
    }
    
    public Potion(String name, int weight, int healthPoints, int price) {
        super(name, weight, price);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public boolean useItem(Hero hero) {
        if(hero.getHealthPoints() < hero.getMaxHP()){
            hero.setCurrentWeight(hero.getCurrentWeight() - this.getWeight());
            hero.setHealthPoints(hero.getHealthPoints() + healthPoints);
            return true;
        }
        
        System.out.println("You already have max HP");
        return false;
        
    }
    
    
}
