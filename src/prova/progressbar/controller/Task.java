/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prova.progressbar.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.SwingWorker;

/**
 *
 * @author albert
 */
public class Task extends SwingWorker<Void, Void> {
    Controller controller;
        
    public Task(Controller controller) {
        this.controller = controller;
    }
    
    @Override
    protected Void  doInBackground() throws Exception {    
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            System.out.println("Entra");
            File file = new File("/home/albert/NetBeansProjects/prova-progressbar/file/test.txt");
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i=0; i<1000000; i++) {
                setProgress(i/10000);
                bw.write("id: " + i +"; name: nom_" + i + "; value: valor_" + i+ "\n");
            }
	    
            bw.close();
            System.out.println("Surt");
	} catch (Exception e) {
	    e.printStackTrace();
	}

        return null;
    }
    
    @Override
    protected void done() {
        controller.done();
    }    
}
