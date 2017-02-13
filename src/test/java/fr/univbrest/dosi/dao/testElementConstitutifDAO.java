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
import fr.univbrest.dosi.bean.ElementConstitutif;
import fr.univbrest.dosi.bean.ElementConstitutifPK;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.UniteEnseignement;
import fr.univbrest.dosi.bean.UniteEnseignementPK;

/**
 * @author Chobaz
 *
 * 8 févr. 2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AppTestConfig.class)
public class testElementConstitutifDAO
{
	@Autowired
    private ElementConstitutifDAO elementConstitutifDAO;

	@Autowired
	private UniteEnseignementDAO uniteEnseignementDAO;
	
	@Autowired
	private FormationDAO formationDAO;
	
    @Before
    public void init() 
    {
    	formationDAO.save(new Formation("001", new Date(), "F1", "Oui", new Date(), new BigDecimal(2000), "Formation1"));
    	uniteEnseignementDAO.save(new UniteEnseignement(new UniteEnseignementPK("001", "001"), "UE1", "UE1", new BigDecimal(10), new BigDecimal(10), new BigDecimal(10), "1"));
        
    	ElementConstitutif ec1 = new ElementConstitutif(new ElementConstitutifPK("001", "001", "001"), "EC1", "EC1", new BigDecimal(10), new BigDecimal(10), new BigDecimal(10));
		elementConstitutifDAO.save(ec1);

		ElementConstitutif ec2 = new ElementConstitutif(new ElementConstitutifPK("001", "001", "002"), "EC2", "EC2", new BigDecimal(20), new BigDecimal(20), new BigDecimal(20));
		elementConstitutifDAO.save(ec2);
    }

    @Test
    public void doitCompterLesECs() 
    {
        long resultat = elementConstitutifDAO.count();

        assertThat(resultat).isEqualTo(2L);
    }

    @Test
    public void doitRécupérerUnECParDesignation() 
    {
        List<ElementConstitutif> resultat = elementConstitutifDAO.findByDesignation("EC1");

        assertThat(resultat).hasSize(1);
        assertThat(resultat.get(0).getDescription()).isEqualTo("EC1");
    }

}
