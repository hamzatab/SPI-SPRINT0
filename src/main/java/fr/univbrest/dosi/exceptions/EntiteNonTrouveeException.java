/**
 * 
 */
package fr.univbrest.dosi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Tabassamet
 *
 *         12 févr. 2017
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntiteNonTrouveeException extends RuntimeException
{
	private static final long serialVersionUID = -7344190446676818466L;

	public EntiteNonTrouveeException(String message)
	{
		super(message);
	}

}
