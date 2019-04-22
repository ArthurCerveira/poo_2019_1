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

    public void setSeconds(int seconds) {
        if(seconds >= 0 && seconds < 60)
            this.seconds = seconds;
    }

    public void setMinutes(int minutes) {
        if(minutes >= 0 && minutes < 24)
            this.minutes = minutes;
    }

    public void setHours(int hours) {
        if(hours >= 0 && hours <24)
            this.hours = hours;
    }
      
     
}
