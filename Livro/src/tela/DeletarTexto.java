package tela;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Texto;
//import tela.Visualizar.buscar;
import textoDAO.TextoDAO;

public class DeletarTexto extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscarTexto;
	private JTextField textTitulo;
	private JTextField textTema;
	private JTextArea textArea;
	
	private List<Texto> tsdf;
	private Long tempID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletarTexto frame = new DeletarTexto();
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
	public DeletarTexto() {
		setTitle("Deletar");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 12, 337, 102);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo");
		lblNewLabel.setBounds(12, 12, 70, 15);
		panel.add(lblNewLabel);
		
		txtBuscarTexto = new JTextField();
		txtBuscarTexto.setBounds(10, 37, 284, 19);
		panel.add(txtBuscarTexto);
		txtBuscarTexto.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(12, 68, 117, 25);
		panel.add(btnBuscar);
		btnBuscar.addActionListener(new buscar());
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 134, 748, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTema = new JLabel("Tema");
		lblTema.setBounds(12, 47, 38, 15);
		panel_1.add(lblTema);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(12, 20, 40, 15);
		panel_1.add(lblTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setBounds(70, 18, 272, 19);
		panel_1.add(textTitulo);
		textTitulo.setColumns(10);
		
		textTema = new JTextField();
		textTema.setBounds(68, 45, 274, 19);
		panel_1.add(textTema);
		textTema.setColumns(10);
		
		JLabel lblTexto = new JLabel("Texto");
		lblTexto.setBounds(12, 95, 70, 15);
		panel_1.add(lblTexto);
		
		textArea = new JTextArea();
		textArea.setBounds(70, 95, 666, 286);
		panel_1.add(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(374, 12, 191, 108);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Deletar");
		lblNewLabel_1.setBounds(26, 12, 70, 15);
		panel_2.add(lblNewLabel_1);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(24, 40, 117, 25);
		panel_2.add(btnConfirm);
		btnConfirm.addActionListener(new deletar());
	}
	
	private class buscar implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TextoDAO t = new TextoDAO();
			tsdf = t.mostrarTexto();
			
			
			for(int i = 0; i < tsdf.size(); i++) {
				if(tsdf.get(i).getTitulo().equals(txtBuscarTexto.getText())) {
					textTitulo.setText(tsdf.get(i).getTitulo());
					textTema.setText(tsdf.get(i).getTema());
					textArea.setText(tsdf.get(i).getTexto());
					
					tempID = tsdf.get(i).getId();
				}
			}
			
		}
		
	}
	
	private class deletar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TextoDAO tx = new TextoDAO();
			tx.deletarTexto(tempID);
		}
		
	}
	
}
