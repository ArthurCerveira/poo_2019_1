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
public class TremEspecial extends Trem{
    private int numeroFumantes;       
    
    public TremEspecial(int numeroTrem, Data dataViagem, int numeroFumantes,int totalVagas) {
        super(numeroTrem, dataViagem);
        this.numeroFumantes = numeroFumantes;
        this.numeroVagas = totalVagas;
        this.poltronas = new Boolean[totalVagas];
    }

    public int getNumeroVagas() {
        return numeroVagas;
    }

    public int cadeirasFumantes() {
        return numeroFumantes;
    }
    
    public char tipo(int pos){
        if(pos >= 0 && pos < numeroFumantes)
            return 'N';
        else{
            if(pos >= numeroFumantes && pos < poltronas.length)
                return 'F';
        }
        
        return '\0';
    }
   
    
    
    
}
