/**
 * 
 */
package fr.univbrest.dosi.controller;

import fr.univbrest.dosi.business.FormationBusiness;
import fr.univbrest.dosi.exceptions.EntiteInvalideException;
import fr.univbrest.dosi.model.FormationComplete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;

/**
 * @author Tabassamet
 *
 *         9 févr. 2017
 */
@Api(value = "formation", description = "Description de la ressource formation.")
@RestController
@RequestMapping(value = "/formation")
public class FormationController
{
	private FormationBusiness formationBusiness;

	@Autowired
	FormationController(FormationBusiness formationBusiness)
	{
		this.formationBusiness = formationBusiness;
	}

	@ApiOperation(value = "", notes = "Permet de récupérer la liste de toutes les formations.", response = Collection.class, tags={  })
	@RequestMapping(method = RequestMethod.GET)
	public Collection<FormationComplete> retrieveAll()
	{
		return formationBusiness.retrieveAll();
	}

	@ApiOperation(value = "", notes = "Permet de récupérer une formation à partir de son code formation.", response = FormationComplete.class, tags={  })
	@RequestMapping(value = "/{codeFormation}", method = RequestMethod.GET)
	public FormationComplete retrieveFormation(
			@PathVariable(value = "codeFormation") final String codeFormation)
	{
		return formationBusiness
				.retrieveFormationByCodeFormation(codeFormation);
	}

	@ApiOperation(value = "", notes = "Permet de créer une formation dans la BD.", response = FormationComplete.class, tags={  })
	@RequestMapping(value = "", method = RequestMethod.POST, produces = { "application/json" })
	public FormationComplete createFormation(@Valid @RequestBody FormationComplete formation)
	{
		validerFormationAEnregistrer(formation);
		
		return formationBusiness.createFormation(formation);
	}
	
	@ApiOperation(value = "", notes = "Permet de mettre à jour les données d'une formation.", response = FormationComplete.class, tags={  })
	@RequestMapping(value = "", method = RequestMethod.PUT, produces = { "application/json" })
	public FormationComplete updateFormation(@Valid @RequestBody FormationComplete newFormation)
	{
		//aliderFormationAMettreAJour(codeFormation, newFormation);
		
		return formationBusiness.createFormation(newFormation);
	}
	
	@ApiOperation(value = "", notes = "Permet de supprimer une formation à partir de son code formation.", response = FormationComplete.class, tags={  })
	@RequestMapping(value = "/{codeFormation}", method = RequestMethod.DELETE)
	public void deleteFormation(
			@PathVariable(value = "codeFormation") String codeFormation)
	{
		formationBusiness.deleteFormation(codeFormation);
	}

	private void validerFormationAMettreAJour(String codeFormation,
			FormationComplete formationAMettreAJour)
	{
		if (codeFormation.equals(formationAMettreAJour.getCodeFormation()))
		{
			validerFormationAEnregistrer(formationAMettreAJour);
		} else
		{
			throw new EntiteInvalideException();
		}
	}

	private void validerFormationAEnregistrer(
			FormationComplete formationAEnregistrer)
	{
		if (Strings.isNullOrEmpty(formationAEnregistrer.getCodeFormation()))
		{
			throw new EntiteInvalideException();
		}
	}

}
