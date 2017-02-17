/**
 * 
 */
package fr.univbrest.dosi.business;

import java.util.Collection;

import fr.univbrest.dosi.model.FormationComplete;

/**
 * @author Tabassamet
 *
 * 8 févr. 2017
 */
public interface FormationBusiness
{
	FormationComplete createFormation(FormationComplete formationComplete);
	
	void deleteFormation(String codeFormation);
	
	FormationComplete updateFormation(FormationComplete newFormation);
	
	FormationComplete retrieveFormationByCodeFormation(String codeFormation);
	
	Collection<FormationComplete> retrieveAll();
	
//	List<Formation> retrieveFormationByNoAnnee(long noAnnee);
//	
//	List<Formation> retrieveFormationByName(String nomFormation);
//	
//	List<Formation> retrieveFormationByDoubleDiplome(Boolean doubleDiplome);

}
