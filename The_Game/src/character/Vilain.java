/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import character.CharacterGame;
import item.Item;

import java.util.Random;

/**
 *
 * @author aluno
 */
public class Vilain extends CharacterGame{
    public Vilain(String name, int healthPoints) {
        super(name, healthPoints, 1);
        Random randomCoins = new Random();
        this.coins = randomCoins.nextInt(200);
        this.setAttackable(true);
    }

    @Override
    public boolean insertItemInventory(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getStringInventory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
