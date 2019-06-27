/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import character.Vilain;
import java.util.HashMap;
import java.util.Set;
import item.Item;

/**
 *
 * @author arthur
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Vilain> characters;
    private HashMap<String, Item> items;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        characters = new HashMap<>();
        items = new HashMap<>();
    }
    
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }
    
    public void setCharacters(String name, Vilain character){
        characters.put(name, character);
    }
    
    public void setItems(String name, Item item) {
        items.put(name, item);
    }
    
    public String getShortDescription() {
        return description;
    }
    
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString() + getEnemyString() + getItemString();
    }
    
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    public String getEnemyString() {
        //enemies recebes todos os nomes de personagens da sala
        Set<String> enemies = characters.keySet();
        String returnString = "";
        
        //caso existam inimigos
        if (!characters.isEmpty()) {
            returnString= "\nEnemies:";
            //este for itera pelos nomes e imprime
            for (String name : enemies)
                returnString += " " + name;
        }
        
        return returnString;
    }
    
    public String getItemString() {
        Set<String> itemsRoom = items.keySet();
        String returnString = "";
        
        if(!items.isEmpty()) {
            returnString= "\nItems:";
            
            for (String name : itemsRoom)
                returnString += " " + name;
        }
        
        return returnString;
    }
    
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    public Vilain getCharacter(String name) {
        return characters.get(name);
    }
    
    public void removeCharacter(String name){
        characters.remove(name);
    }
    
    public Item getItem(String name) {
        return items.get(name);
    }
    
    public void removeItem(String name) {
        items.remove(name);
    }
}
