/**
 * 
 */
package fr.univbrest.dosi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Enseignant;

/**
 * @author Tabassamet
 *
 * 7 févr. 2017
 */
public interface EnseignantDAO extends CrudRepository<Enseignant, Long>
{
	List<Enseignant> findByNom(String nom);
	
	List<Enseignant> findByVille(String ville);

}
