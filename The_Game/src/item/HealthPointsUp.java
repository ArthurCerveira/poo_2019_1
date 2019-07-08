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
public class HealthPointsUp extends Item{
    private int extraHP;
    
    
    public HealthPointsUp(String name, int weight, int price, int extraHP) {
        super(name, weight, price);
        this.extraHP = extraHP;
        
    }
    
    @Override
    public boolean useItem(Hero hero) {
        hero.setCurrentWeight(hero.getCurrentWeight() - this.getWeight());
        hero.setMaxHP(hero.getMaxHP() + extraHP);
        hero.setHealthPoints(hero.getMaxHP());
        return true;
    }
    
}
