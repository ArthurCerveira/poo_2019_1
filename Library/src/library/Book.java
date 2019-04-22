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
public class Book extends Item {
    private String author;
    private int pages;
    private String RefNumber;
    
    public Book(String bookTitle, boolean bookGotIt, String bookComment, String bookAuthor, int bookPages)
    {
        super(bookTitle, bookGotIt, bookComment);
        author = bookAuthor;
        pages = bookPages;
        RefNumber = "";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getRefNumber() {
        if (RefNumber.length() > 0) {
            return RefNumber;
        } else {
            return "ZZZ";
        }
    }

    public void setRefNumber(String RefNumber) {
        this.RefNumber = RefNumber;
    }
    
    @Override
    public String toString() {
        String str = "Title: " + getTitle();
        
        if(isGotIt())
            str += " (*)";                    
        
        str +="\nAuthor: " + getAuthor() + 
              "\nPages: " + getPages();
        
        if (RefNumber.length() > 0) 
            str += ", Ref.: " + RefNumber;
        else
            str += ", Ref. ZZZ";
        
        return str;        
        
    } 
    
}
