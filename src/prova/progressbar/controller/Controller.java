/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.progressbar.controller;

import java.awt.Cursor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import prova.progressbar.gui.*;

/**
 *
 * @author albert
 */
public class Controller implements PropertyChangeListener {
    FrameMainProvaProgressBar frameMainProvaProgressBar = null;
    FrameProgressBar frameProgressBar = null;

    public void initGUI() {
        frameMainProvaProgressBar = new FrameMainProvaProgressBar(this);
        frameMainProvaProgressBar.setVisible(true);
        frameProgressBar = new FrameProgressBar();
        frameProgressBar.setVisible(false);
    }
            
    public void loadProva() {
        frameProgressBar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        frameProgressBar.setVisible(true);
        Task task = new Task(this);
        task.addPropertyChangeListener(this);
        task.execute();
    }

    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Evt: " + evt.getPropertyName() + "; value: " + evt.getNewValue());
        if ("progress" == evt.getPropertyName()) {         
            int progress = (Integer) evt.getNewValue();
            frameProgressBar.setProgresBarValue(progress);
        } 
    }   
    
    public void done() {
        frameProgressBar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        frameProgressBar.setVisible(false);
        System.out.println("Task done");
    }
}
