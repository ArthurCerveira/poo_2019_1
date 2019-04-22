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
public class Inventory {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book i1;
        i1 = new Book("dom quixote", true, "no comment", "miguel de cervantes", 300);
        Book i2;
        i2 = new Book("cem anos de solidao", true, "no comment", "gabriel garcia marquez", 500);
        Book i3;
        i3 = new Book("orgulho e preconceito", true, "no comment", "jane austen", 415);
        Book i4;
        i4 = new Book("harry potter", false, "no comment", "jk rowling", 150);        
        Book i5;
        i5 = new Book("o apanhador no campo de centeio", false, "no comment", "jd salinger", 150);
        
                      
        LibraryItems l = new LibraryItems(5);
        l.Insert(i1);
        l.Insert(i2);
        l.Insert(i3);
        l.Insert(i4);
        l.Insert(i5);
         
        l.printAlphabeticTitle();       
    }
    
}
