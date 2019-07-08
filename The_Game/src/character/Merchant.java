/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;

import item.Item;
import java.util.Set;

/**
 *
 * @author arthur
 */
public class Merchant extends CharacterGame{
    public Merchant(String name) {
        super(name, 1 , 0);
        this.setAttackable(false);
    }
    
    @Override
    public boolean insertItemInventory(Item newItem){
        getInventory().put(newItem.getName(), newItem);
        return true;
    }
    
    @Override
    public void sellItem(String itemName, Hero hero){
        Item item = getInventory().get(itemName);
        
        if(item != null){
            if(hero.getCoins() >= item.getPrice()){
                hero.insertItemInventory(item);
                hero.setCoins(hero.getCoins() - item.getPrice());
                
                this.removeItem(itemName);
                
                System.out.println(itemName + " is now in your inventory");
            } else System.out.println("You don't have enough money to buy " + 
                                      itemName + "\n");            
        } else System.out.println("There's no item called " + itemName + "\n");   
    }
    
    @Override
    public String getStringInventory() {
        String returnString = null;
        
        Set<String> i = getInventory().keySet();
        
        if(!i.isEmpty()) {
            returnString = "Items:\n";
            
            for(String name : i)
                returnString += name + "\nprice: " + 
                                getItem(name).getPrice() + " coins"
                                + "\nweight: " + getItem(name).getWeight() 
                                + "\n\n";
        }
        
        return returnString;
    }
    
}
