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
public class Treasure extends Item{
      public Treasure(String name, int weight) {
        super(name, weight);
    }    
    
    @Override
    public boolean useItem(Hero hero) {
        System.out.println("You can't use that here");
        return false;
    }
    
}
