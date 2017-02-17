/**
 * 
 */
package fr.univbrest.dosi.model;

import java.util.Date;

/**
 * @author Tabassamet
 *
 *         12 févr. 2017
 */

public class FormationComplete
{

	private String codeFormation;

	private String diplome;

	private int numeroAnnee;

	private String nomFormation;

	private boolean estUnDoubleDiplome;

	private Date debutAccreditation;

	private Date finAccreditation;

	public String getCodeFormation()
	{
		return codeFormation;
	}

	public void setCodeFormation(String codeFormation)
	{
		this.codeFormation = codeFormation;
	}

	public String getDiplome()
	{
		return diplome;
	}

	public void setDiplome(String diplome)
	{
		this.diplome = diplome;
	}

	public int getNumeroAnnee()
	{
		return numeroAnnee;
	}

	public void setNumeroAnnee(int umeroAnnee)
	{
		this.numeroAnnee = umeroAnnee;
	}

	public String getNomFormation()
	{
		return nomFormation;
	}

	public void setNomFormation(String nomFormation)
	{
		this.nomFormation = nomFormation;
	}

	public boolean isEstUnDoubleDiplome()
	{
		return estUnDoubleDiplome;
	}

	public void setEstUnDoubleDiplome(boolean estUnDoubleDiplome)
	{
		this.estUnDoubleDiplome = estUnDoubleDiplome;
	}

	public Date getDebutAccreditation()
	{
		return debutAccreditation;
	}

	public void setDebutAccreditation(Date debutAccreditation)
	{
		this.debutAccreditation = debutAccreditation;
	}

	public Date getFinAccreditation()
	{
		return finAccreditation;
	}

	public void setFinAccreditation(Date finAccreditation)
	{
		this.finAccreditation = finAccreditation;
	}

}
