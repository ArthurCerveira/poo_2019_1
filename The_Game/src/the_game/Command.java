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
public class Command {
    private CommandWord commandWord;
    private String secondWord;

    public Command(CommandWord commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    public CommandWord getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }
    
    public boolean isUnknown() {
        return (commandWord == CommandWord.UNKNOWN);
    }
    
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
