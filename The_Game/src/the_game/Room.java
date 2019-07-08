/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import character.CharacterGame;
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
    private HashMap<String, CharacterGame> characters;
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
    
    public void setCharacters(CharacterGame character){
        characters.put(character.getName(), character);
    }
    
    public void setItems(String name, Item item) {
        items.put(name, item);
    }
    
    public String getShortDescription() {
        return description;
    }
    
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString() + 
                getCharacterString() + getItemString();
    }
    
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    public String getCharacterString() {
        //enemies recebes todos os nomes de personagens da sala
        Set<String> enemies = characters.keySet();
        String returnString = "";
        
        //caso existam inimigos
        if (!characters.isEmpty()) {
            returnString= "\nCharacters:";
            //este for itera pelos nomes e imprime
            int i = 0;
            for (String name : enemies) {
                if(i != 0)
                    returnString += ",";
                returnString += " " + name;
                i++;
            }
        }
        
        return returnString;
    }
    
    public String getItemString() {
        Set<String> itemsRoom = items.keySet();
        String returnString = "";
        
        if(!items.isEmpty()) {
            returnString= "\nItems:";
            
            int i = 0;
            for (String name : itemsRoom) {
                if(i != 0)
                    returnString += ",";
                returnString += " " + name;
                i++;
            }
        }
        
        return returnString;
    }
    
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    public CharacterGame getCharacter(String name) {
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
