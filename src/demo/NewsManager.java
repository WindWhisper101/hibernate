package demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class NewsManager {
	public static void main(String[] args) throws Exception{
		Configuration conf=new Configuration().configure();
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder() 
				.applySettings(conf.getProperties()).build();
		SessionFactory sf = conf .buildSessionFactory(standardServiceRegistry);
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();	
		Newsinfo news=new Newsinfo();
		news.setTitle("no.1");
		news.setContent("ssh");
		sess.save(news);
		tx.commit();
		sess.close();
		sf.close();
	}
}
