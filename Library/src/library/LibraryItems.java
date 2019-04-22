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
            Item[] novaArea = new Book[items.length * 2];
            
            if (novaArea != null) 
            {                
                for (int i = 0; i < numberOfElements; i++)
                    novaArea[i] = items[i];
                
                items = novaArea;                
            }   
            else
                System.err.println("Não foi possível inserir o item. Não há memória disponível");
                
        items[numberOfElements++] = newItem;}        
    }
    
    public void print(){
        for (int i = 0; i < numberOfElements; i++)
            System.out.println("[ "+i+" ] " + items[i]);
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
}
