package backgammon04.backgammon04_persistence_mysql.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDao
{
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @return the current hibernate session of actual thread
     */
    public Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * @return the autowired hibernate session factory
     */
    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    /**
     * @param sessionFactory - set the hibernate session factory
     */
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
}
