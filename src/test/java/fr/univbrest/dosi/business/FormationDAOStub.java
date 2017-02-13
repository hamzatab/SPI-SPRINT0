/**
 * 
 */
package fr.univbrest.dosi.business;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.dao.FormationDAO;

/**
 * @author Chobaz
 *
 *         8 févr. 2017
 */
public class FormationDAOStub implements FormationDAO
{
	private List<Formation> donnees;

	FormationDAOStub()
	{
		this.donnees = Lists.newArrayList();
	}

	FormationDAOStub(List<Formation> setUpData)
	{
		this.donnees = Lists.newArrayList(setUpData);
	}

	@Override
	public <S extends Formation> S save(S entity)
	{
		this.donnees.add(entity);

		return entity;
	}

	@Override
	public <S extends Formation> Iterable<S> save(Iterable<S> entities)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Formation> findAll()
	{
		return this.donnees;
	}

	@Override
	public long count()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Formation entity)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Formation> entities)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Formation findByCodeFormation(String codeFormation)
	{
		return this.donnees
				.stream()
				.filter(formation -> formation.getCodeFormation().equals(
						codeFormation)).findFirst().orElse(null);
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
	 */
	@Override
	public void delete(String arg0)
	{
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
	 */
	@Override
	public boolean exists(String arg0)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	@Override
	public Iterable<Formation> findAll(Iterable<String> arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
	 */
	@Override
	public Formation findOne(String arg0)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.univbrest.dosi.dao.FormationDAO#findByN0Annee(java.math.BigDecimal)
	 */
	@Override
	public List<Formation> findByN0Annee(BigDecimal n0Annee)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.univbrest.dosi.dao.FormationDAO#findByNomFormation(java.lang.String)
	 */
	@Override
	public List<Formation> findByNomFormation(String nomFormation)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.univbrest.dosi.dao.FormationDAO#findByDoubleDiplome(java.lang.String)
	 */
	@Override
	public List<Formation> findByDoubleDiplome(String doubleDiplome)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
