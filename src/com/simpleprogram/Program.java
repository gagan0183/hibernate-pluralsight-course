package com.simpleprogram;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		System.out.println("Hello");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setName("user");
		user.setGoal(9);
		session.save(user);

		session.getTransaction().commit();
		
		session.beginTransaction();
		
		User loaduser = (User) session.get(User.class, 1);
		System.out.println(loaduser.getName());
		
		loaduser.setTotal(loaduser.getTotal() + 90);
		
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
