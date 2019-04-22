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
public class Item {
    private String title;
    private boolean gotIt;
    private String comment;
    
    public Item(String itemTitle, boolean itemGotIt, String itemComment)
    {
        title = itemTitle;
        gotIt = itemGotIt;
        comment = itemComment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isGotIt() {
        return gotIt;
    }

    public void setGotIt(boolean gotIt) {
        this.gotIt = gotIt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }    
      
}
