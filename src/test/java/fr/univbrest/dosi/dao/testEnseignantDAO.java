/**
 * 
 */
package fr.univbrest.dosi.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Enseignant;

/**
 * @author Chobaz
 *
 *         8 févr. 2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class testEnseignantDAO
{
	@Autowired
	private EnseignantDAO enseignantDAO;

	@Before
	public void init()
	{
		Enseignant enseignant1 = new Enseignant(new Long(001), "Chobaz-lando",
				"001", "chobaz@email.com", "chobaz@ubo.com", "001", "Chobaz",
				"Chobaz-lando", "Derp01", "M", "001", "Chobaz", "Chobaz-city");
		enseignantDAO.save(enseignant1);

		Enseignant enseignant2 = new Enseignant(new Long(002), "Chaboz-lando",
				"002", "chobaz@email.com", "chobaz@ubo.com", "002", "Chaboz",
				"Chaboz-lando", "Derp02", "M", "002", "Chaboz", "Chaboz-city");
		enseignantDAO.save(enseignant2);
	}

	@Test
	public void doitCompterLesEnseignants()
	{
		long resultat = enseignantDAO.count();

		assertThat(resultat).isEqualTo(2L);
	}

	@Test
	public void doitRécupérerUnEnseignantParNom()
	{
		List<Enseignant> resultat = enseignantDAO.findByNom("Chobaz");

		assertThat(resultat).hasSize(1);
		assertThat(resultat.get(0).getPrenom()).isEqualTo("Derp01");
	}

	@Test
	public void doitRécupérerUnEnseignantParVille()
	{
		List<Enseignant> resultat = enseignantDAO.findByVille("Chobaz-city");

		assertThat(resultat).hasSize(1);
	}

}
