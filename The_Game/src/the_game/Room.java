/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author arthur
 */
public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    
    public void setExit(String direction, Room neighbor){
        exits.put(direction, neighbor);
    }
    
    public String getShortDescription() {
        return description;
    }
    
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}
