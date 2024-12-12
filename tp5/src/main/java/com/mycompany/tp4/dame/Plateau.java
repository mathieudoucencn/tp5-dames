/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tp4.dame;

/**
 *
 * @author victo
 */
public class Plateau {
    private char[][] pions = new char[8][8]; // Plateau de 8x8
    
    public Plateau(char[][] p){
        this.pions = p;
    }

    public Plateau() {
        // Placer les pièces de manière initiale
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 1 && i < 3) pions[i][j] = 'N'; // Pièces noires
                else if ((i + j) % 2 == 1 && i > 4) pions[i][j] = 'B'; // Pièces blanches
                else pions[i][j] = ' ';
            }
        }
        // Compléter le reste du plateau par des .
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pions[i][j] != 'N' && pions[i][j] != 'B'){
                    pions[i][j] = '.';
                };
            }
        }
    }

    // Méthode pour afficher le plateau dans la console
    public void afficherPlateau() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(pions[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public char[][] getPions(){
        return this.pions;
    }

}

