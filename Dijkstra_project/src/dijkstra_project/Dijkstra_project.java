/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dijkstra_project;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zvika
 */
public class Dijkstra_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Algo.DijkstraSP.main(args);
        } catch (IOException ex) {
            Logger.getLogger(Dijkstra_project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
