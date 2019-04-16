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
}
