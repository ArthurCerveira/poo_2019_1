package character;

import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class BattleSimulator {
    /* private Hero hero;
     private Vilain vilain;
    
    public BattleSimulator(String nameHero, String nameVilain, int healthPoints) {
        hero = new Hero(nameHero, healthPoints);
        vilain = new Vilain(nameVilain, healthPoints);
    }*/
    
    public void simulate(Hero hero, Vilain vilain){// throws InterruptedException {
        System.out.println("A battle started!\n" + 
                           "You are fighting " + vilain.getName() + 
                           " and he's carrying " + vilain.getCoins() + " coins");
        
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
             
        while(hero.getHealthPoints() != 0 && vilain.getHealthPoints() != 0) {
            hero.fight(vilain);
            
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            hero.printInfo();
            vilain.printInfo();
            
            try {
                Thread.sleep(2000);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        
        if(hero.getHealthPoints() == 0) 
            System.out.println(vilain.getName() + " won.");
        if(vilain.getHealthPoints() == 0) {
            System.out.println(hero.getName() + " won.\n" + vilain.getName() + 
                              " dropped " + vilain.getCoins() + " coins.");
            hero.setCoins(hero.getCoins() + vilain.getCoins());
        }
            
    }
}
