/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

/**
 *
 * @author arthur
 */
public class Merchant extends CharacterGame{
    public Merchant(String name, int healthPoints, int attack) {
        super(name, healthPoints, attack);
        this.setAttackable(false);
    }
    
    
    
}
