/**
 * 
 */
package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.dao.FormationDAO;
import fr.univbrest.dosi.model.FormationComplete;

/**
 * @author Chobaz
 *
 *         8 févr. 2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class testFormationBusiness
{

	@Test
	public void doitPouvoirAjouterUneFormation()
	{
		FormationDAO entrepot = new FormationDAOStub();
		FormationBusinessJPA formationBusiness = new FormationBusinessJPA(
				entrepot);

		formationBusiness.createFormation(new FormationComplete());

		assertThat(entrepot.findAll()).hasSize(1);

	}

	@Test
	public void doitRécupérerDesFormations()
	{
		List<Formation> formations = Lists.newArrayList(new Formation("01"),
				new Formation("02"), new Formation("03"));

		FormationDAO entrepot = new FormationDAOStub(formations);
		FormationBusinessJPA formationBusiness = new FormationBusinessJPA(
				entrepot);

		assertThat(formationBusiness.retrieveAll()).hasSize(3);
	}
}
