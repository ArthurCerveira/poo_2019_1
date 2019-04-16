/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author arthur
 */
public class DigitalMedia extends Item{
    private Time playTime;
    
    public DigitalMedia(String dmTitle, boolean dmGotIt, String dmComment, Time dmPlayTime)
    {
        super(dmTitle, dmGotIt, dmComment);        
        playTime = dmPlayTime;
    }
}
