/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import character.Hero;
import character.Vilain;
import character.BattleSimulator;
import character.Item;

/**
 *
 * @author aluno
 */
public class Game {
    private Parser parser;
    private Room currentRoom;
    private Hero hero;
    private BattleSimulator battleSimulator;
    
    public Game(String name) 
    {
        createRooms();
        parser = new Parser();
        hero = new Hero(name, 10, 10);
        battleSimulator = new BattleSimulator();
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
        scientist = new Vilain("scientist", 5);
        bartender = new Vilain("bartender", 5);
        actor  = new Vilain("actor", 5);
        boss  = new Vilain("boss", 5);
        
        //coloca os inimigos nas salas
        theatre.setCharacters(actor.getName(), actor);
        pub.setCharacters(bartender.getName(), bartender);
        lab.setCharacters(scientist.getName(), scientist);
        office.setCharacters(boss.getName(), boss);
        
        currentRoom = outside; 
    }
    
    public void play() {            
        printWelcome();
        
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
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
            case ATTACK:
                attackEnemy(command);
                break;
            case PICK:
                pickItem(command);
            case DROP:
                dropItem(command);
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
            currentRoom.printEnemies();
        }
    }
    
    private void attackEnemy(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know who to attack...
            System.out.println("Attack who?");
            return;
        }
        
        String enemy = command.getSecondWord();
        
        Vilain vilain = currentRoom.getCharacter(enemy);
        
        if (vilain != null )            
            battleSimulator.simulate(hero, vilain);
        else System.out.println("There is no enemy called " + enemy + "!");        
    }
    
    private void pickItem(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know who to attack...
            System.out.println("Pick what?");
            return;
        }
        
        String name = command.getSecondWord();
        
        Item item = currentRoom.getItem(name);
        
        if (item != null ){
            hero.insertItem(name, item);
            currentRoom.removeItem(name);
        } else System.out.println("There is no item called " + name + "!");
            
    }
    
    private void dropItem(Command command){
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know who to attack...
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
