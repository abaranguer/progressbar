/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.progressbar.controller;

import java.awt.Cursor;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.SwingWorker;
import prova.progressbar.model.Prova;
import prova.progressbar.gui.FrameProgressBar;


/**
 *
 * @author albert
 */
public class Task extends SwingWorker<Void, Void> {
    Controller controller;
    FrameProgressBar frameProgressBar = null;
    EntityManager entityManager1 = null;
    
    public Task(Controller controller) {
        this.controller = controller;
        frameProgressBar = controller.frameProgressBar; 
        entityManager1 = javax.persistence.Persistence.createEntityManagerFactory("prova-progressbarPU").createEntityManager();
    }
    
    @Override
    protected Void  doInBackground() throws Exception {
        int progress = 0;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Entra");
        EntityTransaction transaction = entityManager1.getTransaction();
        transaction.begin();
        for(progress=0; progress<1000; progress++) {
            Prova prova = new Prova();
            prova.setId(progress);
            prova.setName("Nom " + progress);
            prova.setValue("Valor " + progress);
            entityManager1.persist(prova);
        }
        transaction.commit();
        System.out.println("Surt");
        return null;
    }
    
    @Override
    protected void done() {
        frameProgressBar.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        frameProgressBar.setVisible(false);
        System.out.println("Task done");
    }    
}
