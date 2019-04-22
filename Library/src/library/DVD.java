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
public class DVD extends DigitalMedia{
    private String director;

    public DVD(String itemTitle, boolean itemGotIt, String itemComment, Time dmPlayTime, String dvdDirector)
    {
        super(itemTitle, itemGotIt, itemComment, dmPlayTime);
        director = dvdDirector;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    
    @Override
    public String toString() {
        String str = "Title: " + getTitle();
        
        if(isGotIt())
            str += " (*)";                    
        
        str +="\nDirector: " + getDirector() + 
              "\nPlayTime: " + getPlayTime();
        
        return str;
    }
}
