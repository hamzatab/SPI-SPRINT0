/**
 * 
 */
package fr.univbrest.dosi.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Formation;

/**
 * @author Tabassamet
 *
 * 7 févr. 2017
 */
public interface FormationDAO extends CrudRepository<Formation, String>
{
	List<Formation>findByN0Annee(BigDecimal n0Annee);
	
	List<Formation> findByNomFormation(String nomFormation);
	
	List<Formation> findByDoubleDiplome(String doubleDiplome);
	
	Formation findByCodeFormation(String codeForString);
}
