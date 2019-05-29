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
    GO("go"), QUIT("quit"), HELP("help"),ATTACK("attack"), UNKNOWN("?"), PICK("pick"), DROP("drop");
    
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
