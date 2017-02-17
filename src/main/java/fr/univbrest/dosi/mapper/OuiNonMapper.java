/**
 * 
 */
package fr.univbrest.dosi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Tabassamet
 *
 *         12 févr. 2017
 */

@Mapper()
public interface OuiNonMapper
{
	OuiNonMapper INSTANCE = Mappers.getMapper(OuiNonMapper.class);

	default boolean StringToBoolean(String ouiNon)
	{
		if ("O".equals(ouiNon))
		{
			return true;
		} else
		{
			return false;
		}
	}

	default String booleanToString(boolean ouiNon)
	{
		if (ouiNon)
		{
			return "O";
		} else
		{
			return "N";
		}
	}
}
