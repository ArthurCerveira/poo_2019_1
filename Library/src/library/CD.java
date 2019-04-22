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
public class CD extends DigitalMedia{
    private String artist;
    private int tracks;
    
    public CD(String itemTitle, boolean itemGotIt, String itemComment, Time dmPlayTime, String cdArtist, int cdTracks)
    {
        super(itemTitle, itemGotIt, itemComment, dmPlayTime);
        artist = cdArtist;
        tracks = cdTracks;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }
         
    @Override
    public String toString() {
        String str = "Title: " + getTitle();
        
        if(isGotIt())
            str += " (*)";                    
        
        str +="\nArtist: " + getArtist() +
              "\nNumber of Tracks: " + getTracks() +
              "\nPlayTime: " + getPlayTime();
        
        return str;
    }
}
