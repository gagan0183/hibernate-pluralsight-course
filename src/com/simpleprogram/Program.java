package com.simpleprogram;

import java.util.Date;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		System.out.println("Hello");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User();
		user.setName("user");
		user.getProteinData().setGoal(90);
		user.getUserHistories().add(new UserHistory(new Date(), "Set the goal to 90"));
		session.save(user);

		session.getTransaction().commit();

		session.beginTransaction();

		User loaduser = (User) session.get(User.class, 1);
		System.out.println(loaduser.getName());

		for (UserHistory userHistory : loaduser.getUserHistories()) {
			System.out.println(userHistory.getEntryDate() + " " + userHistory.getEntry());
		}

		loaduser.getProteinData().setTotal(loaduser.getProteinData().getTotal() + 90);
		loaduser.getUserHistories().add(new UserHistory(new Date(), "Set the total to 90"));

		session.getTransaction().commit();

		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
