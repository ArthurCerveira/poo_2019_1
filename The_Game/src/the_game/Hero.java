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
    
    void aliment() {
        increment();
        increment();
    }
    
    void fight(Vilain enemy) {
        // Throw the dice
        if(enemy.luck() > this.luck()) {
            this.decrement();
            enemy.increment();
        }
        else if (enemy.luck() < this.luck()) {
            enemy.decrement();
            this.increment();
        }
        else {
            this.decrement();
            enemy.decrement();
        }
    }
}
