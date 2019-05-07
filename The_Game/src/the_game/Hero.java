/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import java.util.Random;
/**
 *
 * @author aluno
 */
public class Hero extends Character{
    public Hero(String name, int healthPoints) {
        super(name, healthPoints);
    }
    
    void increment(){
        if(healthPoints < 10)
            healthPoints++;
    }
    
    void decrement() {
        healthPoints--;
        if(healthPoints >= 0)
            System.out.println("Game Over");
    }
    
    void aliment() {
        increment();
        increment();
    }
    
    int luck() {
        Random dados = new Random();
        return dados.nextInt(6) + 1;
    }
    
    void printInfo() {
        String str;
        str = ("#####################\n# Nome: " + name + "\n# Energia: " + healthPoints +"\n#####################");
        System.out.println(str);
    }
}
