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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Texto;
import textoDAO.TextoDAO;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class Visualizar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private List<Texto> texto;
	
	private JLabel TituloLabel;
	private JLabel TemaLabel;
	private JTextArea txtrPasadsd;
	
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_3;
	
	public static boolean boo = false;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Visualizar frame = new Visualizar();
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
	public Visualizar() {
		setTitle("Visualizar Textos");
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
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 32, 304, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar Titulo");
		lblNewLabel.setBounds(12, 12, 132, 15);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(12, 25, 254, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(12, 45, 117, 25);
		panel.add(btnBuscar);
		btnBuscar.addActionListener(new buscar());
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("as");
		panel_1.setBounds(12, 126, 755, 421);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		TituloLabel = new JLabel("");
		TituloLabel.setBounds(12, 12, 390, 15);
		panel_1.add(TituloLabel);
		
		TemaLabel = new JLabel("");
		TemaLabel.setBounds(12, 39, 390, 15);
		panel_1.add(TemaLabel);
		
		txtrPasadsd = new JTextArea();
		txtrPasadsd.setEditable(false);
		
		txtrPasadsd.setBounds(12, 96, 731, 313);
		panel_1.add(txtrPasadsd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(328, 31, 439, 83);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Alguns textos salvos");
		lblNewLabel_1.setBounds(0, 0, 159, 15);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 23, 198, 15);
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("New label");
		lblNewLabel_2_1.setBounds(10, 40, 198, 15);
		panel_2.add(lblNewLabel_2_1);
		
		lblNewLabel_2_2 = new JLabel("New label");
		lblNewLabel_2_2.setBounds(229, 23, 198, 15);
		panel_2.add(lblNewLabel_2_2);
		
		lblNewLabel_2_3 = new JLabel("New label");
		lblNewLabel_2_3.setBounds(229, 40, 198, 15);
		panel_2.add(lblNewLabel_2_3);
		
		carregar();
	}
	
	public void carregar() {
		TextoDAO t = new TextoDAO();
		List<Texto> tsdf = t.mostrarTexto();
		
		lblNewLabel_2.setText(tsdf.get(0).getTitulo());
		lblNewLabel_2_1.setText(tsdf.get(1).getTitulo());
		lblNewLabel_2_2.setText(tsdf.get(2).getTitulo());
		lblNewLabel_2_3.setText(tsdf.get(3).getTitulo());
	}
	
	private class buscar implements ActionListener{
 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			TextoDAO t = new TextoDAO();
			List<Texto> tsdf = t.mostrarTexto();
			
			lblNewLabel_2.setText(tsdf.get(0).getTitulo());
			lblNewLabel_2_1.setText(tsdf.get(1).getTitulo());
			lblNewLabel_2_2.setText(tsdf.get(2).getTitulo());
			lblNewLabel_2_3.setText(tsdf.get(3).getTitulo());
			
			for(int i = 0; i < tsdf.size(); i++) {
				if(tsdf.get(i).getTitulo().equals(textField.getText())) {
					TituloLabel.setText(tsdf.get(i).getTitulo());
					TemaLabel.setText(tsdf.get(i).getTema());
					txtrPasadsd.setText(tsdf.get(i).getTexto());
				}
			}
			
//			System.out.println(tsdf.get(0).getTitulo());
			
//			for(Texto t1 : t.mostrarTexto()) {
//				System.out.println("titulo: "+t1.getTitulo());
//				System.out.println("tema: "+t1.getTema());
//				System.out.println("texto: "+t1.getTexto());
//			}
			
		}
		
	}
}
