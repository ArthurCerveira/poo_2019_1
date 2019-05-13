/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_game;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Parser {
    private CommandWords commands;
    private Scanner reader;
    
    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
    
    public Command getCommand() {
        String inputLine;   
        String word1 = null;
        String word2 = null;

        System.out.print("> ");    

        inputLine = reader.nextLine();
        
        // encontra as duas palavras da string
        Scanner tokenizer = new Scanner(inputLine);
        
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      
            if(tokenizer.hasNext()) 
                word2 = tokenizer.next();
        }
        
        return new Command(commands.getCommandWord(word1), word2);
    }
    
    public void showCommands() {
        commands.showAll();
    }
}   
