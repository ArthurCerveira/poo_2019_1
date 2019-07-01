package character;

import item.Item;
import java.util.Random;
import java.util.Scanner;
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
        Scanner menuReader = new Scanner(System.in);
        String inputLine = null;
        boolean runaway = false;
        
        System.out.println("A battle started!\n" + 
                           "You are fighting " + vilain.getName() + 
                           " and he's carrying " + vilain.getCoins() + " coins.\n" +
                           "Your options are:");
             
        while(hero.getHealthPoints() != 0 && vilain.getHealthPoints() != 0) {
            System.out.println("- attack\n"
                             + "- item\n"
                             + "- run");
            
            System.out.print("> ");    
            inputLine = menuReader.nextLine();
            
            if (inputLine != null) switch (inputLine) {
                case "a":
                case "attack":
                    attack(hero, vilain);
                    break;     
                case "i":
                case "item":
                    items(hero);
                    break;
                case "r":
                case "run":
                    runaway = run(hero);
                    break;
                default:
                    System.out.println(inputLine + " is not a valid command");
            }
            
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            
            if(runaway)
                break;
        } 
        
        if(hero.getHealthPoints() == 0) 
            System.out.println(vilain.getName() + " won.");
        if(vilain.getHealthPoints() == 0) {
            System.out.println(hero.getName() + " won.\n" + vilain.getName() + 
                              " dropped " + vilain.getCoins() + " coins.");
            
            hero.setCoins(hero.getCoins() + vilain.getCoins());
        }
            
    }
    
    public void attack(Hero hero, Vilain vilain){
        hero.fight(vilain);            
        try {
            Thread.sleep(500);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        hero.printInfo();
        vilain.printInfo();
    }
    
    public void items(Hero hero){
        if(hero.getStringInventory() != null) {
            System.out.print(hero.getStringInventory() +
                             "\nType the item name to use it or 'return' to return\n> ");
        
            Scanner menuReader = new Scanner(System.in);
            String inputLine = null;

            inputLine = menuReader.nextLine();
            
            Item item = hero.getItem(inputLine);
            
            switch(inputLine){
                case "return":
                    return;
                default:
                    if (item != null ){
                        item.useItem(hero);
                        hero.removeItem(inputLine);
                    } else System.out.println("You don't have an item called " + inputLine + "!");
            }        
        } else System.out.println("You don't any items!");
        
    }
    
    public boolean run(Hero hero){ //possui 1/4 chance de escapar, se falhar o heroi perde 1HP
        Random dados = new Random();
        int resultado = dados.nextInt(4);
        if(resultado >= 3){
            System.out.println(hero.getName() + " ran away");
            return true;            
        }
        System.out.println(hero.getName() + " could not escape!\n" +
                           hero.getName() + " lost 1HP.");
        hero.decrement(1);
        return false;
    }
}
