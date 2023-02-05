package tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Usuario;
import textoDAO.TextoDAO;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField txtUsuario;
	private JTextField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 28, 380, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 12, 70, 15);
		panel.add(lblNome);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(12, 39, 70, 15);
		panel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(12, 66, 70, 15);
		panel.add(lblSenha);
		
		textNome = new JTextField();
		textNome.setBounds(78, 8, 290, 19);
		panel.add(textNome);
		textNome.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(78, 37, 290, 19);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		textSenha = new JTextField();
		textSenha.setBounds(78, 64, 290, 19);
		panel.add(textSenha);
		textSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario us = new Usuario();
				us.setNome(textNome.getText());
				us.setUsuario(txtUsuario.getText());
				us.setSenha(textSenha.getText());
				
				TextoDAO td = new TextoDAO();
				td.cadastrarUsuario(us);
				
			}
		});
		btnCadastrar.setBounds(12, 148, 117, 25);
		panel.add(btnCadastrar);
		
		JRadioButton rdbtnConcordoComOs = new JRadioButton("Concordo com os termos de controle supremo");
		rdbtnConcordoComOs.setBounds(12, 102, 356, 23);
		panel.add(rdbtnConcordoComOs);
	}
}
