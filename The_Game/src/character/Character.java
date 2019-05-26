/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import java.util.Random;

/**
 *
 * @author aluno
 */
public class Character {
    private String name;
    private int healthPoints;

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
    
    int luck() {
        System.out.println("Throwing the dice...");
        Random dados = new Random();
        int resultado = dados.nextInt(6) + 1;
        System.out.println(name + " got a " + resultado);
        return resultado;
    }
    
        
    void increment(){
        if(healthPoints < 10)
            healthPoints++;
    }
    
    void decrement() {
        if(healthPoints >= 0)
            healthPoints--;
        else if(healthPoints <= 0)
            System.out.println(name + " has fainted.");
        else
            System.out.println(name + " is already unable to fight.");
    }
    
    void printInfo() {
        String str;
        str = ("#####################\n# Nome: " + name + "\n# Energia: " + healthPoints +"\n#####################");
        System.out.println(str);
    }
}


