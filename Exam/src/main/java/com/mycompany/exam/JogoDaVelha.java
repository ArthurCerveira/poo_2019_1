/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exam;

import java.util.Scanner;

/**
 *
 * @author arthur
 */
public class JogoDaVelha {
    private int[][] grid;
    
    public JogoDaVelha(){
        grid = new int[3][3];
        for(int i = 0;i < 3;i++)
            for(int j = 0; j < 3; j++)
                grid[i][j] = 0;
    }
    
    public void ExibirGrid(){
        for(int i = 0;i < 3;i++){
            for(int j = 0; j < 3; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }            
    }
    
    public void Jogar(){
        boolean ganhou = false;
        int ganhador = 0;
        Scanner myObj = new Scanner(System.in);
        int[] jogada = new int[2];
        
        while(ganhou == false){
            ExibirGrid();
            
            System.out.print("P1: ");
            jogada[0] = myObj.nextInt();
            jogada[1] = myObj.nextInt();
            
            grid[jogada[0]][jogada[1]] = 1;
            
            System.out.print("P2: ");
            jogada[0] = myObj.nextInt();
            jogada[1] = myObj.nextInt();
            
            grid[jogada[0]][jogada[1]] = 2;
            
            for(int i = 0;i < 3;i++){
                if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != 0){
                    ganhador = grid[i][0];
                    ganhou = true;                    
                    break;                   
                }
                
                if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != 0){
                    ganhador = grid[0][i];
                    ganhou = true;                    
                    break;                    
                }
            }
            if(grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2] && grid[0][0] != 0){
                ganhador = grid[1][1];
                if(ganhador != 0)
                    ganhou = true;                    
                break;                  
            }
                
            if(grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2] && grid[2][0] != 0){
                ganhador = grid[1][1];
                if(ganhador != 0)
                    ganhou = true;                    
                break;                     
            }              
        }       
        
        ExibirGrid();
        System.out.println("Player " + ganhador + " won.");
    }
    
    
}
