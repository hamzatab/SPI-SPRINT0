/**
 * 
 */
package fr.univbrest.dosi.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.dao.FormationDAO;
import fr.univbrest.dosi.exceptions.EntiteNonTrouveeException;
import fr.univbrest.dosi.mapper.MapperFormation;
import fr.univbrest.dosi.model.FormationComplete;

/**
 * @author Tabassamet
 *
 *         8 févr. 2017
 */
@Component
public class FormationBusinessJPA implements FormationBusiness
{
	private FormationDAO formationDAO;
	private MapperFormation mapperFormation;

	@Autowired
	FormationBusinessJPA(FormationDAO formationDAO)
	{
		this.formationDAO = formationDAO;
		this.mapperFormation = MapperFormation.INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.univbrest.dosi.business.FormationBusiness#createFormation(fr.univbrest
	 * .dosi.bean.Formation)
	 */
	@Override
	public FormationComplete createFormation(FormationComplete formationComplete)
	{
		Formation formation = mapperFormation
				.formationCompleteToFormation(formationComplete);

		Formation formationSaved = formationDAO.save(formation);

		return mapperFormation.formationToFormationComplete(formationSaved);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.univbrest.dosi.business.FormationBusiness#deleteFormation(java.lang
	 * .String)
	 */
	@Override
	public void deleteFormation(String codeFormation)
	{
		Optional<Formation> formation = Optional.ofNullable(formationDAO
				.findByCodeFormation(codeFormation));

		Formation formationASupprimer = formation
				.orElseThrow(() -> new EntiteNonTrouveeException(
						"Impossible de trouver l'entitée à supprimer: "
								+ codeFormation));

		formationDAO.delete(formationASupprimer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.univbrest.dosi.business.FormationBusiness#updateFormation(java.lang
	 * .String, fr.univbrest.dosi.bean.Formation)
	 */
	@Override
	public FormationComplete updateFormation(FormationComplete newFormation)
	{
		Optional<Formation> formation = Optional.ofNullable(formationDAO
				.findByCodeFormation(newFormation.getCodeFormation()));

		Formation formationAModifier = formation
				.orElseThrow(() -> new EntiteNonTrouveeException(
						"Impossible de trouver l'entitée à supprimer: "
								+ newFormation.getCodeFormation()));
		
		return mapperFormation.formationToFormationComplete(formationDAO.save(formationAModifier)); 
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.univbrest.dosi.business.FormationBusiness#retrieveFormationByCodeFormation
	 * (java.lang.String)
	 */
	@Override
	public FormationComplete retrieveFormationByCodeFormation(
			String codeFormation)
	{
		Formation formationFound = formationDAO
				.findByCodeFormation(codeFormation);

		return mapperFormation.formationToFormationComplete(formationFound);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.univbrest.dosi.business.FormationBusiness#retrieveAllFormation()
	 */
	@Override
	public List<FormationComplete> retrieveAll()
	{
		List<Formation> formations = (List<Formation>) formationDAO.findAll();

		List<FormationComplete> formationsCompletes = new ArrayList<FormationComplete>();
		
		for(Formation f: formations)
			formationsCompletes.add(mapperFormation.formationToFormationComplete(f));
		
		return formationsCompletes;
	}

}
