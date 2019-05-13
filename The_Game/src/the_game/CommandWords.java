/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import java.util.HashMap;
/**
 *
 * @author aluno
 */
public class CommandWords {
    private HashMap<String, CommandWord> validCommands;
    
    public CommandWords() {
        validCommands = new HashMap<>();
        for(CommandWord command : CommandWord.values()) 
            if(command != CommandWord.UNKNOWN)
                validCommands.put(command.toString(), command);
    }
    
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) 
            return command;
        
        else 
            return CommandWord.UNKNOWN;
        
    }
    
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }
    
    public void showAll() {
        for(String command : validCommands.keySet())
            System.out.print(command + "  ");
        
        System.out.println();
    }
    
    
}
