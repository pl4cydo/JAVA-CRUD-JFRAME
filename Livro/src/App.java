import javax.swing.SwingUtilities;

import tela.Login;

//import tela.Cadastro;
//import tela.Tela;


public class App {
    public static void main(String[] args) throws Exception {
       
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run(){
            	Login vt = new Login();
                vt.setVisible(true);
            }

        });

    }
}
