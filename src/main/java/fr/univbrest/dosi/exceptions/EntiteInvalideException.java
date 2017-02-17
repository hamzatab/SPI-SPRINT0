/**
 * 
 */
package fr.univbrest.dosi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tabassamet
 *
 * 12 févr. 2017
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntiteInvalideException extends RuntimeException
{
	private static final long serialVersionUID = -6269189246805876837L;

	public EntiteInvalideException()
	{
		super("L'entité à persister est invalide!");
	}

}
