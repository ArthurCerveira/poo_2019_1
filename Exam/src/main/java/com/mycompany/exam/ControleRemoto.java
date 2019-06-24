/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam;

/**
 *
 * @author arthur
 */
public class ControleRemoto {
    private Televisao tv;

    public ControleRemoto(Televisao tv) {
        this.tv = tv;
    }
    
    public boolean aumentarVolume(){
        if(tv.volume < 100){
            tv.volume++;
            return true;
        }
        return false;
    }
    
    public boolean diminuirVolume(){
        if(tv.volume > 0){
            tv.volume--;
            return true;
        }
        return false;
    }
    
    public boolean trocarCanal(int canal){
        if(canal > 0 && canal < tv.canalMax){
            tv.canalAtual = canal;
            return true;
        }
        return false;
    }
    
    public int getCanal(){
        return tv.canalAtual;
    }
    
    public int getVolume() {
        return tv.volume;
    }
}
