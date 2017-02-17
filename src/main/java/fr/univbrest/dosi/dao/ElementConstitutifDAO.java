/**
 * 
 */
package fr.univbrest.dosi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.ElementConstitutif;
import fr.univbrest.dosi.bean.ElementConstitutifPK;
import fr.univbrest.dosi.bean.Enseignant;

/**
 * @author Tabassamet
 *
 * 7 févr. 2017
 */
public interface ElementConstitutifDAO extends CrudRepository<ElementConstitutif, ElementConstitutifPK>
{
	List<ElementConstitutif> findByEnseignant(Enseignant enseignant);
	
	List<ElementConstitutif> findByDesignation(String designation);

}
