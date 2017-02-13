/**
 * 
 */
package fr.univbrest.dosi.dao;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univbrest.dosi.AppTestConfig;
import fr.univbrest.dosi.bean.Candidat;

/**
 * @author Chobaz
 *
 * 7 févr. 2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class testCandidatDAO
{
	@Autowired
    private CandidatDAO candidatDAO;

    @Before
    public void init() 
    {
        Candidat candidat1 = new Candidat("001", "rue Chobazique", "001", "Oui", new Date(), new Date(), "001@email.com", "Chobaz-lando", "001", "001", "Chobazien", "Chobaz", "Chobaz-lando", "Derp", new BigDecimal(1), "M", "001", "Chobaz university", "Chobaz-city");
        candidatDAO.save(candidat1);

        Candidat candidat2 = new Candidat("002", "rue Chabozique", "002", "Oui", new Date(), new Date(), "002@email.com", "Chaboz-lando", "002", "002", "Chabozien", "Chaboz", "Chaboz-lando", "Perd", new BigDecimal(2), "F", "002", "Chaboz university", "Chaboz-city");
        candidatDAO.save(candidat2);
    }

    @Test
    public void doitCompterLesCandidats() 
    {
        long resultat = candidatDAO.count();

        assertThat(resultat).isEqualTo(2L);
    }

    @Test
    public void doitRécupérerUnCandidatParNom() 
    {
        List<Candidat> resultat = candidatDAO.findByNom("Chobaz");

        assertThat(resultat).hasSize(1);
        assertThat(resultat.get(0).getPrenom()).isEqualTo("Derp");
    }

    @Test
    public void doitRécupérerUnCandidatParUniversiteOrigine() 
    {
        List<Candidat> resultat = candidatDAO.findByUniversiteOrigine("Chobaz university");

        assertThat(resultat).hasSize(1);
        assertThat(resultat.get(0).getNoCandidat()).isEqualTo("001");
    }

}
