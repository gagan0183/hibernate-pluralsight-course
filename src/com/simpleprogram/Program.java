package com.simpleprogram;

import java.util.Date;
import java.util.Map.Entry;

import org.hibernate.Session;

public class Program {

	public static void main(String[] args) {
		System.out.println("Hello");
		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User user = new User();
		user.setName("user");
		user.getProteinData().setGoal(90);
		user.getUserHistories().put("1", new UserHistory(new Date(), "Set the goal to 90"));
		session.save(user);

		session.getTransaction().commit();

		session.beginTransaction();

		User loaduser = (User) session.get(User.class, 1);
		System.out.println(loaduser.getName());

		for (Entry<String, UserHistory> entry : loaduser.getUserHistories().entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue().getEntryDate() + " " + entry.getValue().getEntry());
		}

		loaduser.getProteinData().setTotal(loaduser.getProteinData().getTotal() + 90);
		loaduser.getUserHistories().put("2", new UserHistory(new Date(), "Set the total to 90"));

		session.getTransaction().commit();

		session.close();
		HibernateUtilities.getSessionFactory().close();
	}
}
