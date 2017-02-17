/**
 * 
 */
package fr.univbrest.dosi.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.model.FormationComplete;

/**
 * @author Tabassamet
 *
 *         12 févr. 2017
 */
@Mapper(uses = OuiNonMapper.class)
public interface MapperFormation
{
	MapperFormation INSTANCE = Mappers.getMapper( MapperFormation.class );

	@Mappings({
			@Mapping(source = "estUnDoubleDiplome", target = "doubleDiplome"),
			@Mapping(source = "numeroAnnee", target = "n0Annee") })
	Formation formationCompleteToFormation(FormationComplete fc);

	@InheritInverseConfiguration
	FormationComplete formationToFormationComplete(Formation formation);

}
