/**
 * 
 */
package fr.univbrest.dosi.dao;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Etudiant;
import fr.univbrest.dosi.bean.Promotion;

/**
 * @author Tabassamet
 *
 * 7 févr. 2017
 */
public interface EtudiantDAO extends CrudRepository<Etudiant, String>
{
	Enseignant findByPromotion(Promotion promotion);
}
