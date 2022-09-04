package pe.company.pmmcourier.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tipocolaborador")
public class TipoColaborador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipoC_id")
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@JsonBackReference(value = "tipoC_colaborador")
	private ERole name;
	


	public TipoColaborador() {
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public ERole getName() {
		return name;
	}



	public void setName(ERole name) {
		this.name = name;
	}
	
	
}
