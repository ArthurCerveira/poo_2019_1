/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class LibraryItems {
    private int numberOfElements;
    private Item[] items;
    
    public LibraryItems(int size) {
        items = new Item[size];
        numberOfElements = 0;
    }
    
    public void Insert(Item newItem){
        if(numberOfElements >= items.length){
            Item[] novaArea = new Item[items.length * 2];
            
            if (novaArea != null){                
                System.arraycopy(items, 0, novaArea, 0, numberOfElements);
                
                items = novaArea;                
            } else
                System.err.println("Não foi possível inserir o item. Não há memória disponível");
        }
        
        items[numberOfElements++] = newItem;        
    }
    
    public void print(){
        for (int i = 0; i < numberOfElements; i++)
            System.out.println("[ "+i+" ] " + items[i].toString());
    }
    
    public Item remove(int index){
        Item itemRemoved = null;
        if(index >= 0 && index < numberOfElements)
        {
            itemRemoved = items[index];
            for (int i = index; i < numberOfElements - 1; i++) 
                items[i] = items[i+1];
            numberOfElements--;
        }               
        return itemRemoved;
    }
    
    public int SearchByTitle(String title){
        for(int i = 0;i < numberOfElements; i++){
            if (items[i].getTitle().equals(title)) 
                return i;
        }
        return -1;
    }
    
    public ArrayList<Item> SearchByTitles(String title){
        ArrayList<Item> list = new ArrayList<>();
        
        for(int i = 0;i < numberOfElements; i++){
            if (items[i].getTitle().contains(title))
                list.add(items[i]);
        }          
        return list;       
    }
    
    public ArrayList<Integer> SearchByTitlesInt(String title){
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0;i < numberOfElements; i++){
            if (items[i].getTitle().contains(title))
                list.add(i);
        }          
        return list;       
    }
    
    public void printAlphabeticTitle(){
        //menor_c controla qual palavra vem antes
        //essa string é incializada em '|' porque esse caractere vem depois de qualquer letra em ASCII
        String menor_c = "|";
        int menor_c_index = 0;
        String s;
        LibraryItems auxItems;
        int menor_len;
        int k;
        
        //cria um auxiliar da lista e copia os elementos dela
        auxItems = new LibraryItems(numberOfElements);
        auxItems.numberOfElements = numberOfElements;
        
        System.arraycopy(items, 0, auxItems.items, 0, numberOfElements); 
        
        //esse loop serve para controlar os elementos que serao impressos        
        for (int i = 0; i < numberOfElements; i++)
        {
            //esse loop serve para saber qual item deve ser impresso
            for (int j = 0; j < auxItems.numberOfElements; j++)
            {
                //s vai receber a string atual que será testada
                s = (auxItems.items[j].getTitle());
                
                //caso a primeira letra seja igual
                if(s.charAt(0) == menor_c.charAt(0)){
                    
                    //testa-se qual o menor comprimento de palavra e armazena-o em menor_len
                    if(s.length() > menor_c.length())
                        menor_len = menor_c.length();
                    else menor_len = s.length();
                    
                    //compara letra por letra da palavra ate encontrar uma diferente
                    for(k = 1;k < menor_len; k++) {
                        if(s.charAt(k) < menor_c.charAt(k)) {
                            menor_c_index = j;
                            menor_c = s;
                            break;
                        } else {
                            if(s.charAt(k) > menor_c.charAt(k))
                                break;
                        }          
                    }
                    
                    //se k for igual ao comprimento, a menor palavra vem antes(eg: sol e solidao,onde sol vem antes na ordem alfabetica)
                    if(k == s.length()){
                        menor_c_index = j;
                        menor_c = s;
                    }
                        
                }
                
                //se a primeira letra da string for menor, ela vem antes
                if(s.charAt(0) < menor_c.charAt(0)) {
                    menor_c_index = j;
                    menor_c = s;
                }                
            }
            System.out.println("[ "+i+" ] " + auxItems.items[menor_c_index].toString());
            //apos ser impresso, o item é removido da lista auxiliar
            auxItems.remove(menor_c_index);
            //essa string recebe '|' porque esse caractere vem depois de qualquer letra em ASCII
            menor_c = "|";           
        }
    }
    
    public void printAlphabeticAuthor(){
        
    }
}
