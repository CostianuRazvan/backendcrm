package net.reply.backendcrm.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.reply.backendcrm.dao.EmployeesDAO;
import net.reply.backendcrm.dto.Employees;

@Transactional
@Repository("employeesDAO")
public class EmployeesDAOImpl implements EmployeesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employees> list() {
		String selectActiveCategory = "FROM Employees";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		return query.getResultList();
	}

	@Override
	public boolean add(Employees employees) {
		try {
			sessionFactory.getCurrentSession().persist(employees);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Employees employees) {
		try {

			// add the category to the database table

			sessionFactory.getCurrentSession().update(employees);

			return true;

		} catch (Exception ex) {

			ex.printStackTrace();

			return false;

		}
	}

	@Override
	public boolean deleteALL() {
		try {

			List<Employees> employeesList=list();
			for(Employees e:employeesList) {
				sessionFactory.getCurrentSession().delete(e);
			}

			return true;

		} catch (Exception ex) {

			ex.printStackTrace();

			return false;

		}
	}

	@Override
	public Employees get(int id) {
		String selectActiveCategory = "FROM Employees WHERE id="+id;

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		return (Employees)query.getResultList().get(0);
	}

}
