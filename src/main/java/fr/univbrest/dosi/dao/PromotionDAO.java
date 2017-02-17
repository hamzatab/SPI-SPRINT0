/**
 * 
 */
package fr.univbrest.dosi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

/**
 * @author Tabassamet
 *
 * 7 févr. 2017
 */
public interface PromotionDAO extends CrudRepository<Promotion, PromotionPK>
{
	List<Promotion>findBySiglePromotion(String siglePromotion);
	
	List<Promotion> findByEnseignant(Enseignant enseignant);
	
}
