package textoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	
	public void ver(String t) {
		
	}

}
