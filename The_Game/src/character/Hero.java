/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import character.Character;

/**
 *
 * @author aluno
 */
public class Hero extends Character{
    public Hero(String name, int healthPoints) {
        super(name, healthPoints);
    }
    
    void aliment() {
        increment();
        increment();
    }
    
    void fight(Vilain enemy) {
        // Throw the dice
        int enemyLuck = enemy.luck();
        int heroLuck = this.luck();
        if(enemyLuck > heroLuck) {
            this.decrement();
            enemy.increment();
        }
        else { 
            if (enemyLuck < heroLuck) {
                enemy.decrement();
                this.increment();
            }
            else {
                this.decrement();
                enemy.decrement();
            }
        }
    }
}
