/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

/**
 *
 * @author aluno
 */
public enum CommandWord {    
    GO("sail"), QUIT("quit"), HELP("help"), FIGHT("fight"), UNKNOWN("?"),
    PICK("pick"), DROP("drop"), STATUS("status"), USE("use"), SHOP("shop");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    @Override
    public String toString()
    {
        return commandString;
    }
}
