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
public class SuperVilain extends Vilain{

    public SuperVilain(String name, int healthPoints) {
        super(name, healthPoints);
        this.setAttack(3);
        this.setCoins(500);
    }
    
}
