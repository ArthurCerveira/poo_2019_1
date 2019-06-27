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

    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public void useItem(Hero hero) {
        hero.setHealthPoints(hero.getHealthPoints() + healthPoints);
    }
    
    
}
