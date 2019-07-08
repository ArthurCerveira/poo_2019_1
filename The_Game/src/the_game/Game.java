/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import character.CharacterGame;
import character.Hero;
import character.Vilain;
import character.BattleSimulator;
import character.Merchant;
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
    
    public Game(String name) {
        createRooms();
        parser = new Parser();
        hero = new Hero(name, 10, 1, 10);
        battleSimulator = new BattleSimulator();
        gameOver = false;
    }
    
    public void createRooms() {
        Room niihau, kauahi, oahu, molokai, lanai, maui, kahoolawe,kawaihe, hawai, treasureRoom;
        CharacterGame scientist, bartender, actor, boss, merchant;
        Item normalPotion, sword, superPotion, HPplus;
        
        //cria as salas
        niihau = new Room("on the island of Ni'ihau");
        kauahi = new Room("on the island of Kaua'l");
        oahu = new Room("on the island of O'ahu");
        molokai = new Room("on the island of Moloka'i");
        lanai = new Room("on the island of Lãna'i");
        maui = new Room("on the island of Maui");
        kahoolawe = new Room("on the island of Kaho'olawe");
        kawaihe = new Room("on the island of Kawaihae");
        hawai = new Room("on the island of Hawai'i");
        treasureRoom = new Room("in a room with a treasure");
        
        //cria as saidas
        niihau.setExit("east", kauahi);
        
        kauahi.setExit("west", niihau);
        kauahi.setExit("east", oahu);

        oahu.setExit("west", kauahi);
        oahu.setExit("east", molokai);

        molokai.setExit("west", oahu);
        molokai.setExit("east", maui);
        molokai.setExit("south", lanai);

        lanai.setExit("north", molokai);
        lanai.setExit("east", kahoolawe);

        maui.setExit("west", molokai);
        maui.setExit("south", kahoolawe);
        
        kahoolawe.setExit("west",lanai);
        kahoolawe.setExit("north",maui);
        kahoolawe.setExit("south",kawaihe);
        
        kawaihe.setExit("north", kahoolawe);
        kawaihe.setExit("south", hawai);
        
        hawai.setExit("north", kawaihe);
        
        treasureRoom.setExit("west", kahoolawe);
        
        /*cria inimigos
        scientist = new Vilain("scientist", 5);
        bartender = new Vilain("bartender", 5);
        actor  = new Vilain("actor", 5);
        boss  = new Vilain("boss", 5);
        
        //cria o mercador
        merchant = new Merchant("merchant");
        
        //coloca os inimigos nas salas
        theatre.setCharacters(actor);
        pub.setCharacters(bartender);
        lab.setCharacters(scientist);
        office.setCharacters(boss);
        
        //coloca o mercador na sala
        pub.setCharacters(merchant);
        
        //cria os itens do mercador
        superPotion = new Potion("super potion", 2, 10, 200);
        
        //coloca os items no shop
        merchant.insertItemInventory(superPotion);
        
        //cria os itens
        normalPotion = new Potion("potion", 1, 5);        
        sword = new Sword("sword", 2, 3, 10);
        
        //coloca o item na sala
        theatre.setItems(normalPotion.getName(), normalPotion);
        lab.setItems(sword.getName(), sword);*/
        
        
        currentRoom = niihau; 
    }
    
    public void menu() {
        Scanner menuReader = new Scanner(System.in);
        int option;
        
        System.out.println("\nMENU");
        System.out.println("1 - New Game");
        System.out.println("2 - Quit\n");
        
        option = menuReader.nextInt();
        
        switch (option){
            case 1:
                play();
                break;
            case 2:
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
        System.out.println("You are a pirate on the Archipelago of Hawaii.");
        System.out.println("You were given a hint that there could be a hidden treasure east of Kohoolawe");
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
            case SHOP:
                shop();
            default:
                break;
        }
            
        // else command not recognised.
        return wantToQuit;
    }
    
    private void printHelp() 
    {
        System.out.println(currentRoom.getLongDescription());
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
        
        CharacterGame vilain = currentRoom.getCharacter(enemy);
        
        if (vilain != null ) {
            if(vilain.isAttackable()){
                battleSimulator.simulate(hero, vilain);

                if(vilain.getHealthPoints() == 0)
                    currentRoom.removeCharacter(enemy);            

                if(hero.getHealthPoints() == 0){
                    System.out.println("\nGame Over.");
                    return true;
                }
            } else System.out.println("You can't fight with " + enemy + "!"); 
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
            if(hero.insertItemInventory(item)) //se pegar o item retorna verdadeiro
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
    
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else return true;  // signal that we want to quit
        
    }
    
    private void shop(){
        CharacterGame merchant = currentRoom.getCharacter("merchant");
        Scanner menuShop = new Scanner(System.in);
        String itemName = null;
        
        //se houver um mercador na sala
        if(merchant != null) {
            while(merchant.getStringInventory() != null && !itemName.equals("back")) {
                System.out.print("Welcome to my shop!\n" +
                                 merchant.getStringInventory() +
                                 "Type the name of the item you want to buy " + 
                                 "or 'back' to return\n");

                System.out.print("> ");    
                itemName = menuShop.nextLine();

                Item item = merchant.getItem(itemName);

                switch(itemName){
                    case "back":
                        break;
                    default:
                        if (item != null )
                            merchant.sellItem(itemName, hero);
                        else System.out.println("I don't sell any item called " + itemName + "!");
                }
            } 
            
            if(merchant.getStringInventory() == null)
                System.out.println("I don't have anything to sell right now");
        } else System.out.println("There's no merchant in this room");
    }

    
}
