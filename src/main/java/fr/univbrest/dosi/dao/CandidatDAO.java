/**
 * 
 */
package fr.univbrest.dosi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Candidat;

/**
 * @author Tabassamet
 *
 * 7 févr. 2017
 */
public interface CandidatDAO extends CrudRepository<Candidat, String>
{
	List<Candidat> findByNom(String nom);
	
	List<Candidat> findByUniversiteOrigine(String universiteOrigine);
	
}
