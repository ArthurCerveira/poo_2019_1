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
public class Elevador {
    private int andarAtual;
    private int andarMax;
    private int pessoasAtual;
    private int pessoasMax;
    
    public Elevador(int andarMax, int pessoasMax){
        this.andarMax = andarMax;
        this.pessoasMax = pessoasMax;
        
        andarAtual = 0;
        pessoasAtual = 0;
    }
    
    public boolean Entra(){
        if(pessoasAtual < pessoasMax){
            pessoasAtual++;
            return true;
        }
        return false;
    }
    
    public boolean Sai(){
        if(pessoasAtual > 0){
            pessoasAtual--;
            return true;
        }
        return false;
    }
    
    public boolean Sobe(){
        if(andarAtual < andarMax){
            andarAtual++;
            return true;
        }
        return false;
    }
    
    public boolean Desce(){
        if(andarAtual > 0){
            andarAtual--;
            return true;
        }
        return false;
    }
            
}
