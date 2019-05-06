/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

/**
 *
 * @author aluno
 */
public class Hero extends Character{
    public Hero(String name, int healthPoints) {
        super(name, healthPoints);
    }
    
    void increment(){
        if(healthPoints <= 10)
            healthPoints++;
    }
}
