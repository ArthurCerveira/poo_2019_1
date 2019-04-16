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
public class Time {
    private int seconds;
    private int minutes;
    private int hours;
    
    public Time(int s, int m, int h)
    {
        seconds = s;
        minutes = m;
        hours = h;
    }
    
    public int getSeconds()
    {
        return seconds;
    }
    
    public int getMinutes()
    {
        return minutes;
    }
     
      public int getHours()
    {
        return hours;
    }
}
