package character;

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
    
    public void simulate(Hero hero, Vilain vilain) {
        while(hero.getHealthPoints() != 0 && vilain.getHealthPoints() != 0) {
            hero.fight(vilain);
            hero.printInfo();
            vilain.printInfo();
        }
        
        if(hero.getHealthPoints() == 0) 
            System.out.println(vilain.getName() + " won.");
        if(vilain.getHealthPoints() == 0)
            System.out.println(hero.getName() + " won.");   
    }
}
