package model;

import java.util.Objects;

public class Texto {
	
	private Long id;
	private String titulo;
	private String Tema;
	private String texto;
	
	public Texto(Long id, String titulo, String tema, String texto) {
		this.id = id;
		this.titulo = titulo;
		Tema = tema;
		this.texto = texto;
	}

	public Texto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTema() {
		return Tema;
	}

	public void setTema(String tema) {
		Tema = tema;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String string) {
		this.texto = string;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Texto other = (Texto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Texto [id=" + id + ", titulo=" + titulo + ", Tema=" + Tema + ", texto=" + texto + "]";
	}
	
	
	
	
}
