package fr.univbrest.dosi.bean;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;

/**
 * The persistent class for the UNITE_ENSEIGNEMENT database table.
 * 
 */
@Entity
@Table(name = "UNITE_ENSEIGNEMENT")
@NamedQuery(name = "UniteEnseignement.findAll", query = "SELECT u FROM UniteEnseignement u")
public class UniteEnseignement implements Serializable
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UniteEnseignementPK id;

	private String description;

	private String designation;

	@Column(name = "NBH_CM")
	private BigDecimal nbhCm;

	@Column(name = "NBH_TD")
	private BigDecimal nbhTd;

	@Column(name = "NBH_TP")
	private BigDecimal nbhTp;

	private String semestre;

	// uni-directional many-to-one association to Enseignant
	// Added manually the optional value
	@ManyToOne(optional = true)
	@JoinColumn(name = "NO_ENSEIGNANT", insertable = false, updatable = false)
	private Enseignant enseignant;

	// uni-directional many-to-one association to Formation
	@ManyToOne(optional = true)
	@JoinColumn(name = "CODE_FORMATION", insertable = false, updatable = false)
	private Formation formation;

	public UniteEnseignement()
	{
	}

	public UniteEnseignement(UniteEnseignementPK id, String description,
			String designation, BigDecimal nbhCm, BigDecimal nbhTd,
			BigDecimal nbhTp, String semestre)
	{
		super();
		this.id = id;
		this.description = description;
		this.designation = designation;
		this.nbhCm = nbhCm;
		this.nbhTd = nbhTd;
		this.nbhTp = nbhTp;
		this.semestre = semestre;
	}

	public UniteEnseignementPK getId()
	{
		return this.id;
	}

	public void setId(UniteEnseignementPK id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDesignation()
	{
		return this.designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public BigDecimal getNbhCm()
	{
		return this.nbhCm;
	}

	public void setNbhCm(BigDecimal nbhCm)
	{
		this.nbhCm = nbhCm;
	}

	public BigDecimal getNbhTd()
	{
		return this.nbhTd;
	}

	public void setNbhTd(BigDecimal nbhTd)
	{
		this.nbhTd = nbhTd;
	}

	public BigDecimal getNbhTp()
	{
		return this.nbhTp;
	}

	public void setNbhTp(BigDecimal nbhTp)
	{
		this.nbhTp = nbhTp;
	}

	public String getSemestre()
	{
		return this.semestre;
	}

	public void setSemestre(String semestre)
	{
		this.semestre = semestre;
	}

	public Enseignant getEnseignant()
	{
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant)
	{
		this.enseignant = enseignant;
	}

	public Formation getFormation()
	{
		return this.formation;
	}

	public void setFormation(Formation formation)
	{
		this.formation = formation;
	}

}