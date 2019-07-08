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
public class Sword extends Item{
    private int attackBonus;
    
    public Sword(String name, int weight, int attackBonus) {
        super(name, weight);
        this.attackBonus = attackBonus;
    }

    @Override
    public void useItem(Hero hero) {
        hero.setCurrentWeight(hero.getCurrentWeight() - this.getWeight());
        hero.insertEquippedItem(this);
        hero.setAttack(attackBonus);
    }
    
}
