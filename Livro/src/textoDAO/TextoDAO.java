package textoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conecao.ConnectionFac;
import model.Texto;
import model.Usuario;

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
	
	public void atualizarTexto(Texto txt) {
		String sql = "UPDATE Texto SET titulo = ?, tema = ?, texto = ? " + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFac.createConnection();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, txt.getTitulo());
			pstm.setString(2, txt.getTema());
			pstm.setString(3, txt.getTexto());
			pstm.setLong(4, txt.getId());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
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
		
	}
	
	
	public void deletarTexto(Long id) {
		
		String sql = "DELETE FROM Texto WHERE id = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFac.createConnection();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setLong(1, id);
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
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	public void cadastrarUsuario(Usuario u) {
		
		String sql = "INSERT INTO login(nome, usuario, senha) VALUES (?, ?, ?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFac.createConnection();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getNome());
			pstm.setString(2, u.getUsuario());
			pstm.setString(3, u.getSenha());
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
	
	
	

	public List<Usuario> login() {
		String sql = "SELECT * FROM login";
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//Classe que vai recuperar os dados do banco. ***SELECT****
		ResultSet rset = null;
		 
		try {
			conn = ConnectionFac.createConnection();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Usuario usuario = new Usuario();
				
				//Recuperar o id
				usuario.setId(rset.getInt("id"));
				//Recuperar o nome
				usuario.setNome(rset.getString("nome"));
				usuario.setUsuario(rset.getString("usuario"));
				usuario.setSenha(rset.getString("senha"));
				usuarios.add(usuario);
				
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
		
			return usuarios;
	}

}
