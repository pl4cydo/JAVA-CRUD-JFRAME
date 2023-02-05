package tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import model.Texto;
import textoDAO.TextoDAO;
import javax.swing.JMenuItem;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextPane textPane;
	private JLabel lblNewLabel;
	
	
	private TextoDAO td = new TextoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Textos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 21);
		contentPane.add(menuBar);
		
		JMenu mnOpes = new JMenu("Opções");
		menuBar.add(mnOpes);
		
		JMenuItem mntmVisualizarTextos = new JMenuItem("Visualizar Textos");
		mnOpes.add(mntmVisualizarTextos);
		
		JMenu mnSaksda = new JMenu("saksda");
		mnOpes.add(mnSaksda);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnOpes.add(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar_1.add(mnNewMenu);
		
		JMenu menu = new JMenu("New menu");
		menuBar_1.add(menu);
		mntmVisualizarTextos.addActionListener(new visu());
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 33, 699, 485);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo ");
		lblTitulo.setBounds(50, 66, 44, 15);
		panel.add(lblTitulo);
		
		textField = new JTextField();
		textField.setBounds(112, 64, 525, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(50, 107, 38, 15);
		panel.add(lblTema);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 105, 525, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setBounds(50, 143, 39, 15);
		panel.add(lblTexto);
		
		JLabel lblSejaCriativo = new JLabel("Seja criativo");
		lblSejaCriativo.setBounds(112, 26, 144, 15);
		panel.add(lblSejaCriativo);
		
		textPane = new JTextPane();
		textPane.setBounds(111, 137, 526, 309);
		panel.add(textPane);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(112, 460, 117, 25);
		panel.add(btnEnviar);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(247, 458, 390, 15);
		panel.add(lblNewLabel);
		btnEnviar.addActionListener(new enviar());
		
	}
	
	private class enviar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-geneimport javax.swing.JDialog;rated method stub
			Texto t = new Texto();
			t.setTitulo(textField.getText());
			t.setTema(textField_1.getText());
			t.setTexto(textPane.getText());
			try {
				td.Save(t);
				lblNewLabel.setText(textField.getText() + " foi salvo.");
			} catch (Exception el) {
				el.printStackTrace();
			}	
		}
	}
	
	private class visu implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Visualizar vi = new Visualizar();
			vi.setVisible(true);
			
		}
		
	}
}
