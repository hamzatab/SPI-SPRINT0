/**
 * 
 */
package fr.univbrest.dosi;

import org.springframework.boot.autoconfigure.jdbc.EmbeddedDataSourceConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Chobaz
 *
 * 7 févr. 2017
 */
@Configuration
@EnableJpaRepositories(basePackages = "fr.univbrest.dosi.dao")
@org.springframework.boot.orm.jpa.EntityScan(basePackages = "fr.univbrest.dosi.bean")
@Import({ EmbeddedDataSourceConfiguration.class, HibernateJpaAutoConfiguration.class })
public class AppTestConfig 
{

}