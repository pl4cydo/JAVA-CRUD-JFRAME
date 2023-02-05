import javax.swing.SwingUtilities;

import tela.Principal;

//import tela.Cadastro;
//import tela.Tela;


public class App {
    public static void main(String[] args) throws Exception {
       
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run(){
            	Principal vt = new Principal();
                vt.setVisible(true);
            }

        });

    }
}
