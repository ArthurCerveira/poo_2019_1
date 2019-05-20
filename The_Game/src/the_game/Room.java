/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import character.Vilain;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author arthur
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Vilain> characters;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
        characters = new HashMap<>();
    }
    
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }
    
    public void setCharacters(String name, Vilain character){
        characters.put(name, character);
    }
    
    public String getShortDescription() {
        return description;
    }
    
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }
    
    private String getExitString() {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    public Vilain getCharacter(String name) {
        return characters.get(name);
    }
    
    public void printEnemies() {
        //enemies recebes todos os nomes de personagens da sala
        Set<String> enemies = characters.keySet();
        
        //caso existam inimigos
        if (enemies != null) {
            System.out.print("Enemies: ");
            //este for itera pelos nomes e imprime
            for (String name : enemies)
                System.out.print(name + " ");
        }
        System.out.println();
    }
}
