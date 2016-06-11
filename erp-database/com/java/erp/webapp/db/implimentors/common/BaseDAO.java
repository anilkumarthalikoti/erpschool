package com.java.erp.webapp.db.implimentors.common;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.java.erp.webapp.db.interfaces.common.BaseDAOI;

public class BaseDAO implements BaseDAOI {

	private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
	private static final ThreadLocal<Transaction> transaction = new ThreadLocal<Transaction>();
	Logger logger;
	private static SessionFactory sessionFactory = null;

	public BaseDAO() {
		logger = Logger.getLogger(BaseDAO.class.getName());
		if (null == sessionFactory) {
			try {

				sessionFactory = new AnnotationConfiguration().configure(
						getClass().getClassLoader().getResource(
								"hibernate.cfg.xml")).buildSessionFactory();
				logger.info("DB CONNECTION CREATED");
			} catch (Exception e) {
				logger.info("DB CONNECTION FAILED");
				e.printStackTrace();
			}
		}
	}

	private Session getCurrentSession() {
		Session currentSession = session.get();
		if (currentSession == null) {
			currentSession = sessionFactory.openSession();
			session.set(currentSession);
		}
		if (null != currentSession) {
			Transaction currentTransaction = currentSession.beginTransaction();
			transaction.set(currentTransaction);
		}
		return currentSession;
	}

	@Override
	public Object persist(Object entity) throws Exception {
		try {
			getCurrentSession().save(entity);
			transaction.get().commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		}
		return entity;
	}

	@Override
	public Object merge(Object entity) throws Exception {
		try {
			getCurrentSession().merge(entity);
			transaction.get().commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		}
		return entity;
	}

	@Override
	public void flush() throws Exception {
		try {
			getCurrentSession().clear();

		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public boolean remove(Object entity) throws Exception {
		try {
			getCurrentSession().delete(entity);
			transaction.get().commit();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
			return false;
		}
		return true;
	}

	@Override
	public List<?> getResultList(String query) {
		try {
			return getCurrentSession().createQuery(query).list();

		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		} finally {
			transaction.get().commit();

		}
		return null;
	}

	@Override
	public Object getSingleResult(String query) {
		try {
			return getCurrentSession().createQuery(query).list().get(0);

		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		} finally {
			if (transaction.get().isActive()) {
				transaction.get().commit();
			}

		}
		return null;
	}

	@Override
	public List<?> getResultList(String query, Map<Object, Object> params) {
		try {
			return getCurrentSession().createQuery(query).setProperties(params)
					.list();
		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		} finally {
			if (transaction.get().isActive())
				transaction.get().commit();
		}
		return null;
	}

	@Override
	public Object getSingleResult(String query, Map<Object, Object> params) {
		try {
			Query queryObject = getCurrentSession().createQuery(query);
			for (Map.Entry<Object, Object> entry : params.entrySet()) {
				queryObject.setParameter(entry.getKey().toString(),
						entry.getValue());
			}
			if (queryObject.list() == null || queryObject.list().isEmpty()) {
				return null;
			}
			return queryObject.list().get(0);

		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			e.printStackTrace();
			transaction.get().rollback();
		} finally {
			if (transaction.get().isActive()) {
				transaction.get().commit();
			}
		}
		return null;
	}

	@Override
	public List<Object[]> getNativeResultList(String query) {
		try {
			return getCurrentSession().createSQLQuery(query).list();

		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		} finally {
			if (transaction.get().isActive()) {
				transaction.get().commit();
			}

		}
		return null;
	}

	@Override
	public Object[] getNativeSingleResult(String query) {
		try {
			return (Object[]) getCurrentSession().createSQLQuery(query).list()
					.get(0);

		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		} finally {
			if (transaction.get().isActive()) {
				transaction.get().commit();
			}
		}
		return null;
	}

	@Override
	public List<Object[]> getNativeResultList(String query,
			Map<Object, Object> params) {
		try {
			return getCurrentSession().createSQLQuery(query)
					.setProperties(params).list();

		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		} finally {
			if (transaction.get().isActive()) {
				transaction.get().commit();
			}

		}
		return null;
	}

	@Override
	public Object[] getNativeSingleResult(String query,
			Map<Object, Object> params) {
		logger.info(query);
		try {
			return (Object[]) getCurrentSession().createSQLQuery(query).list()
					.get(0);

		} catch (Exception e) {
			logger.log(Level.WARNING, e.getMessage());
			transaction.get().rollback();
		} finally {
			if (transaction.get().isActive()) {
				transaction.get().commit();
			}

		}
		return null;
	}

}
