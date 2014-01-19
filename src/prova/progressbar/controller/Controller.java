/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.progressbar.controller;

import java.awt.Cursor;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import prova.progressbar.gui.*;
import prova.progressbar.model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author albert
 */
public class Controller implements PropertyChangeListener {
    FrameMainProvaProgressBar frameMainProvaProgressBar = null;
    FrameProgressBar frameProgressBar = null;
    EntityManager entityManager1 = null;
 
   
    public void initGUI() {
        frameMainProvaProgressBar = new FrameMainProvaProgressBar(this);
        frameMainProvaProgressBar.setVisible(true);
        frameProgressBar = new FrameProgressBar();
        frameProgressBar.setVisible(false);
        
        entityManager1 = javax.persistence.Persistence.createEntityManagerFactory("prova-progressbarPU").createEntityManager();
    }
    
    public void reset() {
        EntityTransaction transaction = entityManager1.getTransaction();
        transaction.begin();
        entityManager1.createNamedQuery("Prova.deleteAll").executeUpdate();
        transaction.commit();
        System.out.println("reset");
    }
            
    public void loadProva() {
        
        frameProgressBar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        //Instances of javax.swing.SwingWorker are not reusuable, so
        //we create new instances as needed.
        Task task = new Task(this);
        task.addPropertyChangeListener(this);
        task.execute();
    }
        /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            frameProgressBar.setProgresBarValue(progress);
        } 
    }      
}
