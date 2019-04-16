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
public class Library {
    private int numeroDeElementos;
    private Item[] items;
    
    public Library(int tamanho) {
        items = new Item[tamanho];
        numeroDeElementos = 0;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
