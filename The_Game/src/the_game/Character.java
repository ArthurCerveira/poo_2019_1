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
public class Character {
    String name;
    int healthPoints;

    public Character(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }    

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    
    
}


