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
          
}
