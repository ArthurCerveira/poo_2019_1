/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import character.Hero;
import character.Vilain;
import character.BattleSimulator;
import item.Item;
import item.Potion;
import item.Sword;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Game {
    private Parser parser;
    private Room currentRoom;
    private Hero hero;
    private BattleSimulator battleSimulator;
    private boolean gameOver;
    
    public Game(String name) 
    {
        createRooms();
        parser = new Parser();
        hero = new Hero(name, 10, 1, 10, false);
        battleSimulator = new BattleSimulator();
        gameOver = false;
    }
    
    public void createRooms() {
        Room outside, theatre, pub, lab, office;
        Vilain scientist, bartender, actor, boss;
        
        //cria as salas
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        //cria as saidas
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        
        //cria inimigos
        scientist = new Vilain("scientist", 5, true);
        bartender = new Vilain("bartender", 5, true);
        actor  = new Vilain("actor", 5, true);
        boss  = new Vilain("boss", 5, true);
        
        //coloca os inimigos nas salas
        theatre.setCharacters(actor.getName(), actor);
        pub.setCharacters(bartender.getName(), bartender);
        lab.setCharacters(scientist.getName(), scientist);
        office.setCharacters(boss.getName(), boss);
        
        //cria os itens
        Potion normalPotion = new Potion("potion", 1, 5);        
        Sword sword = new Sword("sword", 2, 3);
        
        //coloca o item na sala
        theatre.setItems(normalPotion.getName(), normalPotion);
        lab.setItems(sword.getName(), sword);
        
        
        currentRoom = outside; 
    }
    
    public void menu() {
        Scanner menuReader = new Scanner(System.in);
        int option;
        
        System.out.println("\nMENU");
        System.out.println("1 - New Game");
        System.out.println("2 - Load Game");
        System.out.println("3 - Quit\n");
        
        option = menuReader.nextInt();
        
        switch (option){
            case 1:
                play();
                break;
            case 3:
                System.out.println("Thank you for playing.  Good bye.");
                break;
        }
        
        if(gameOver){ //se gameOver for verdadeiro, abre o menu novamente
            gameOver = false;
            menu();
        }
    }
    
    public void play() {            
        printWelcome();
        
        boolean finished = false;
        while (!(finished) && !(gameOver)) {
            Command command = parser.getCommand();
            finished = processCommand(command);            
        }
        if(!gameOver) //se gameOver for falso, o jogador quitou do jogo
            System.out.println("Thank you for playing.  Good bye.");
    }
    
    public void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the Game!");
        System.out.println("The Game is an adaptation of tyhe game World of Zuul.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }
    
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
        
        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord != null) switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            case FIGHT:
                if(fightEnemy(command)) //se fight enemy retornar true, o heroi perdeu a batalha
                    gameOver = true;
                break;
            case PICK:
                pickItem(command);
                break;
            case DROP:
                dropItem(command);
                break;
            case STATUS:
                status();
                break;
            case USE:
                useItem(command);
                break;
            default:
                break;
        }
            
        // else command not recognised.
        return wantToQuit;
    }
    
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }
        
        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
            System.out.println("There is no door!");
        
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    //Se o heroi perder, retorna true e volta ao menu
    private boolean fightEnemy(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know who to attack...
            System.out.println("Attack who?");
            return false;
        }
        
        String enemy = command.getSecondWord();
        
        Vilain vilain = currentRoom.getCharacter(enemy);
        
        if (vilain != null ) {
            battleSimulator.simulate(hero, vilain);
            if(vilain.getHealthPoints() == 0){
                //System.out.println(enemy + " is no longer in the room");
                currentRoom.removeCharacter(enemy);
            }
            
            if(hero.getHealthPoints() == 0){
                System.out.println("\nGame Over.");
                return true;
            }
        } else System.out.println("There is no enemy called " + enemy + "!"); 
        
        return false;
    }
    
    private void pickItem(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Pick what?");
            return;
        }
        
        String name = command.getSecondWord();
        
        Item item = currentRoom.getItem(name);
        
        if (item != null ){
            if(hero.insertItemInventory(name, item)) //se pegar o item retorna verdadeiro
                currentRoom.removeItem(name);
            else System.out.println("You don't have enough space in your inventory!");
        } else System.out.println("There is no item called " + name + "!");
            
    }
    
    private void dropItem(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Drop what?");
            return;
        }
        
        String name = command.getSecondWord();
        
        Item item = hero.getItem(name);
        
        if (item != null ){
            hero.removeItem(name);
            currentRoom.setItems(name, item);
        } else System.out.println("You don't have an item called " + name + "!");
            
    }
    
    private void useItem(Command command){
        if(!command.hasSecondWord()) {
            System.out.println("Use what?");
            return;
        }
        
        String name = command.getSecondWord();
        
        Item item = hero.getItem(name);

        if (item != null ){
            item.useItem(hero);
            hero.removeItem(name);
        } else System.out.println("You don't have an item called " + name + "!");
    }
    
    private void status() {
        System.out.println(hero.heroInfo());
    }
    
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    
}
