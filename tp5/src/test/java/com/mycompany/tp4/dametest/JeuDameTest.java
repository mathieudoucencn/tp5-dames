/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.tp4.dametest;
import com.mycompany.tp4.dame.JeuDame;
import com.mycompany.tp4.dame.Plateau;
import com.mycompany.tp4.dame.TP4Dame;

import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.*;

/**
 *
 * @author victo
 */
public class JeuDameTest {
    
    public JeuDameTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of demarrerPartie method, of class JeuDame.
     */
    @Test
    public void testDemarrerPartie() {
        System.out.println("demarrerPartie");
        JeuDame instance = new JeuDame();
        instance.demarrerPartie();
        char[][] plateauInit = {
            {'.', 'N', '.', 'N', '.', 'N', '.', 'N'},  
            {'N','.', 'N', '.', 'N', '.', 'N', '.'},  
            {'.', 'N', '.', 'N', '.', 'N', '.', 'N'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.'},  
            {'B','.', 'B', '.', 'B', '.', 'B', '.'},  
            {'.','B','.', 'B', '.', 'B', '.', 'B'},  
            {'B','.', 'B', '.', 'B', '.', 'B', '.'}   
        };
        assertEquals(plateauInit,instance.getPlateau().getPions());
    }

    /**
     * Test of jeuFini method, of class JeuDame.
     */
    @Test
    public void testJeuFini() {
        System.out.println("jeuFini");
        JeuDame instance = new JeuDame();
        char[][] plateauInit = {
            {'.', 'N', '.', 'N', '.', 'N', '.', 'N'},  
            {'N','.', 'N', '.', 'N', '.', 'N', '.'},  
            {'.', 'N', '.', 'N', '.', 'N', '.', 'N'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.'},  
            {'B','.', 'B', '.', 'B', '.', 'B', '.'},  
            {'.','B','.', 'B', '.', 'B', '.', 'B'},  
            {'B','.', 'B', '.', 'B', '.', 'B', '.'}   
        };
        Plateau p = new Plateau(plateauInit);
        instance.setPlateau(p);
        Boolean expResult = false;
        Boolean result = instance.jeuFini();
        assertEquals(expResult, result);
        
        char[][] plateau2 = {
            {'.', '.', '.', '.', '.', '.', '.', '.'},  
            {'.', '.', '.', '.', '.', '.', '.', '.'},  
            {'.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.'},  
            {'B','.', 'B', '.', 'B', '.', 'B', '.'},  
            {'.','B','.', 'B', '.', 'B', '.', 'B'},  
            {'B','.', 'B', '.', 'B', '.', 'B', '.'}   
        };
        Plateau p2 = new Plateau(plateau2);
        instance.setPlateau(p2);
        Boolean expResult2 = true;
        Boolean result2 = instance.jeuFini();
        assertEquals(expResult2, result2);
        
        char[][] plateau3 = {
            {'.', 'N', '.', 'N', '.', 'N', '.', 'N'},  
            {'N','.', 'N', '.', 'N', '.', 'N', '.'},  
            {'.', 'N', '.', 'N', '.', 'N', '.', 'N'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'.', '.', '.', '.', '.', '.', '.', '.'},  
            {'.', '.', '.', '.', '.', '.', '.', '.'},  
            {'.', '.', '.', '.', '.', '.', '.', '.'},  
            {'.', '.', '.', '.', '.', '.', '.', '.'}  
        };
        Plateau p3 = new Plateau(plateau3);
        instance.setPlateau(p3);
        Boolean expResult3 = true;
        Boolean result3 = instance.jeuFini();
        assertEquals(expResult3, result3);
    }

    /**
     * Test of sauvegarderCoup method, of class JeuDame.
     */
    @Test
    public void testSauvegarderCoup() throws IOException {
        System.out.println("sauvegarderCoup");
        char joueur = 'N';
        String coup = "6 1 5 2";
        String saveFile = "save.txt";
        JeuDame instance = new JeuDame();
        instance.jouerTour(joueur,coup);
        instance.sauvegarderCoup(joueur, coup, saveFile);
        // récupérer le texte du fichier puis vérifier l'égalité avec joueur + coup
        String contenu = Files.readString(Path.of(saveFile));
        assertEquals(contenu, joueur + " " + coup);
    }

    /**
     * Test of chargerPartie method, of class JeuDame.
     */
    @Test
    public void testChargerPartie() {
        System.out.println("chargerPartie");
        String filePath = "savetest.txt";
        JeuDame instance = new JeuDame();
        instance.chargerPartie(filePath);
        char[][] plateauTest = {
            {'.', 'N', '.', 'N', '.', 'N', '.', 'N'},  
            {'N','.', 'N', '.', 'N', '.', 'N', '.'},  
            {'.', 'N', '.', 'N', '.', 'N', '.', 'N'},
            {'.', '.', '.', '.', '.', '.', '.', '.'}, 
            {'.', 'B', '.', '.', '.', '.', '.', '.'},  
            {'.','.', 'B', '.', 'B', '.', 'B', '.'},  
            {'.','B','.', 'B', '.', 'B', '.', 'B'},  
            {'B','.', 'B', '.', 'B', '.', 'B', '.'}
        };
        assertEquals(plateauTest,instance.getPlateau().getPions());
    }
    
}
