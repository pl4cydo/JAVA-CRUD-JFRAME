package tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Usuario;
import textoDAO.TextoDAO;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textSenha;
	
	Principal p = new Principal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 440, 21);
		contentPane.add(menuBar);
		
		JMenu mnCadastro = new JMenu("Opções");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mnCadastro.add(mntmCadastro);
		mntmCadastro.addActionListener(new cadastro());
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mnCadastro.add(mntmSair);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 49, 373, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(22, 12, 70, 15);
		panel.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(12, 31, 313, 23);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(22, 66, 70, 15);
		panel.add(lblSenha);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(12, 85, 313, 23);
		panel.add(textSenha);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(12, 120, 117, 25);
		panel.add(btnLogin);
		btnLogin.addActionListener(new logar());
		
		
	}
	
	private class logar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TextoDAO usuario = new TextoDAO();
			List<Usuario> usuL = usuario.login();
			
			for(int i = 0; i < usuL.size(); i++) {
				if(textUsuario.getText().equals(usuL.get(i).getUsuario()) && textSenha.getText().equals(usuL.get(i).getSenha()) ) {
//					System.out.println("Senha correta");
					
					p.setVisible(true);
				}
			}
			
		}
		
	}
	
	private class cadastro implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CadastroUsuario cu = new CadastroUsuario();
			cu.setVisible(true);
		}
		
	}
}
