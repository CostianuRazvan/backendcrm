package net.reply.backendcrm.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.reply.backendcrm.dao.TemplatesDAO;
import net.reply.backendcrm.dto.Templates;


@Transactional
@Repository("templatesDAO")
public class TemplatesDAOImpl implements TemplatesDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Templates templates) {
		try {
			sessionFactory.getCurrentSession().persist(templates);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Templates> list() {
		String selectActiveCategory = "FROM Templates";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		return query.getResultList();
	}

	@Override
	public boolean update(Templates templates) {
		try {


			sessionFactory.getCurrentSession().update(templates);

			return true;

		} catch (Exception ex) {

			ex.printStackTrace();

			return false;

		}
	}

	@Override
	public List<Templates> get(String name) {
		String selectActiveCategory = "FROM Templates WHERE Name="+"'"+name+"'";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		return query.getResultList();
	}

	@Override
	public boolean deleteTemplate(int id) {
		
		String selectActiveCategory = "FROM Templates WHERE Id="+id;

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		
		sessionFactory.getCurrentSession().delete(query.getResultList().get(0));
		return false;
	}

}
