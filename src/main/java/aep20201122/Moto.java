package aep20201122;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Moto {
	@Id
	private String id;
	private String nome;
	private int cilindradas;
	
	public Moto() {
		id = UUID.randomUUID().toString();
	}
	
	public Moto(String nome, int cilindradas) {
		this();
		this.nome = nome;
		this.cilindradas = cilindradas;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getCilindradas() {
		return cilindradas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cilindradas;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moto other = (Moto) obj;
		if (cilindradas != other.cilindradas)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
}
