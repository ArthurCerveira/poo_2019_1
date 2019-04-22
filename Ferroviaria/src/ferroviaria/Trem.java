/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferroviaria;

/**
 *
 * @author arthur
 */
public class Trem {
    private int numeroTrem;
    private Data dataViagem;
    protected Boolean[] poltronas;
    protected int numeroVagas;

    public Trem(int numeroTrem, Data dataViagem) {
        this.numeroTrem = numeroTrem;
        this.dataViagem = dataViagem;
        numeroVagas = 300;
        poltronas = new Boolean[300];
        for(int i = 0; i < 300; i++)
            poltronas[i] = false;
    }
    
    public int proximoLivre(){
        for(int i=0; i<poltronas.length; i++)
        {
            if(!poltronas[i])
                return i;
            i++;
        }
        return -1;             
    }
    
    public boolean verifica(int pos){       
        if(pos < poltronas.length && pos >= 0)
            return poltronas[pos];
        
        return true;
    }
    
    public boolean ocupa(int pos){
        if(!verifica(pos)){
            numeroVagas--;
            poltronas[pos] = true;
            return true;
        }
        
        return false;      
    }
   
    public int vagas() {
        return numeroVagas;
    }

    public int getNumeroTrem() {
        return numeroTrem;
    }

    public Data getDataViagem() {
        return dataViagem;
    }   
}
