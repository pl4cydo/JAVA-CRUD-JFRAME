package textoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conecao.ConnectionFac;
import model.Texto;

public class TextoDAO {
	
	
	public void Save(Texto texto) {
		
		String sql = "INSERT INTO Texto(titulo, tema, texto) VALUES (?, ?, ?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFac.createConnection();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, texto.getTitulo());
			pstm.setString(2, texto.getTema());
			pstm.setString(3, texto.getTexto());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Texto> mostrarTexto(){
		
		String sql = "SELECT * FROM Texto";
		
		List<Texto> textos = new ArrayList<Texto>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
		
		try {
			conn = ConnectionFac.createConnection();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Texto texto = new Texto();
				
				//Recuperar o id
				texto.setId(rset.getLong("id"));
				//Recuperar o nome
				texto.setTitulo(rset.getString("titulo"));
				texto.setTema(rset.getString("tema"));
				texto.setTexto(rset.getString("texto"));
				textos.add(texto);
				
			}
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					
					if(pstm!=null) {
						pstm.close();
					}
					
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		
			return textos;
	}



}
