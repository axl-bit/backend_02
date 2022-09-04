package pe.company.pmmcourier.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Distrito")
public class Distrito implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "distrito_id",unique = true)
	private Integer DistritoID;
	
	@Column(name = "distrito", nullable = false, unique = true)
	private String Distrito;
	
	@ManyToOne
	@JoinColumn(name = "tarifa_id",nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(tarifa_id) references Tarifa(tarifa_id)"))
	private Tarifa Tarifa;
	
	@ManyToOne
	@JoinColumn(name = "provincia_id",nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(provincia_id) references Provincia(provincia_id)"))
	private Provincia Provincia;
		

	public Distrito() {
		// TODO Auto-generated constructor stub
	}


	public Distrito(String distrito, pe.company.pmmcourier.model.Tarifa tarifa,
			pe.company.pmmcourier.model.Provincia provincia) {
		super();
		Distrito = distrito;
		Tarifa = tarifa;
		Provincia = provincia;
	}


	public Integer getDistritoID() {
		return DistritoID;
	}


	public void setDistritoID(Integer distritoID) {
		DistritoID = distritoID;
	}


	public String getDistrito() {
		return Distrito;
	}


	public void setDistrito(String distrito) {
		Distrito = distrito;
	}


	public Tarifa getTarifa() {
		return Tarifa;
	}


	public void setTarifa(Tarifa tarifa) {
		Tarifa = tarifa;
	}


	public Provincia getProvincia() {
		return Provincia;
	}


	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
	}
		

}
