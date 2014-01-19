/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.progressbar;

import prova.progressbar.controller.Controller;

/**
 *
 * @author albert
 */
public class ProvaProgressBar {
    static Controller controller;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        controller = new Controller();
        controller.initGUI();
    }
}
