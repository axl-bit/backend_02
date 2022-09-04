package pe.company.pmmcourier.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Colaborador")
public class Colaborador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "colaborador_id",unique = true)
	private Integer colaboradorID;
	
	
	@Column(name = "dni", length = 8, nullable = true, unique = true)
	private String dnicolaborador;
	
	@Column(name = "nombre_Colaborador",length = 80, nullable = true)
	private String nombreC;
	
	@NotBlank
	@Column(name = "username", length = 30, nullable = false, unique = true)
	private String username;
	
	@NotBlank
	@Column(name = "email", length = 50, nullable = false, unique = true)
	@Email
	private String email;
	
	@NotBlank
	@Column(name = "contrasena",nullable = false, unique = true)
	private String contrasena;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", 
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<TipoColaborador> tipocolaborador = new HashSet<>();
		
	
	public Colaborador() {
		super();
	}
	
	

	public Colaborador(String dnicolaborador, String nombreC, @NotBlank String username, @NotBlank @Email String email,
			@NotBlank String contrasena) {
		super();
		this.dnicolaborador = dnicolaborador;
		this.nombreC = nombreC;
		this.username = username;
		this.email = email;
		this.contrasena = contrasena;
	}

	public Integer getColaboradorID() {
		return colaboradorID;
	}

	public void setColaboradorID(Integer colaboradorID) {
		this.colaboradorID = colaboradorID;
	}

	public String getDnicolaborador() {
		return dnicolaborador;
	}

	public void setDnicolaborador(String dnicolaborador) {
		this.dnicolaborador = dnicolaborador;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Set<TipoColaborador> getTipocolaborador() {
		return tipocolaborador;
	}

	public void setTipocolaborador(Set<TipoColaborador> tipocolaborador) {
		this.tipocolaborador = tipocolaborador;
	}
	
}
