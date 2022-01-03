package com.great.learning.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.great.learning.entity.Student;


@Repository
public class StudentRepository {

	private SessionFactory sessionFactory;
	// create session
	private Session session;

	@Autowired
	public StudentRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	public List<Student> findAll() {

		Transaction tx = session.beginTransaction();

		List<Student> students = session.createQuery("from Student").list();

		tx.commit();

		return students;
	}

	@Transactional
	public void save(Student theStudent) {

		Transaction tx = session.beginTransaction();

		session.saveOrUpdate(theStudent);

		tx.commit();

	}

	public Student findById(int id) {

		Student student = new Student();

		Transaction tx = session.beginTransaction();

		// find record with Id from the database table
		student = session.get(Student.class, id);

		tx.commit();

		return student;
	}

	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();

		// get transaction
		Student student = session.get(Student.class, id);

		// delete record
		session.delete(student);

		tx.commit();

	}

	@Transactional
	public void print(List<Student> student) {

		for (Student stu : student) {
			System.out.println(stu);
		}
	}

}