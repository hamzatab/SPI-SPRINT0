/**
 * 
 */
package fr.univbrest.dosi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.UniteEnseignement;
import fr.univbrest.dosi.bean.UniteEnseignementPK;

/**
 * @author Tabassamet
 *
 * 7 févr. 2017
 */
public interface UniteEnseignementDAO extends CrudRepository<UniteEnseignement, UniteEnseignementPK>
{
	List<UniteEnseignement> findByDesignation(String designation);
	
	List<UniteEnseignement> findByEnseignant(Enseignant enseignant);
	
	List<UniteEnseignement> findByFormation(Formation formation);
}
