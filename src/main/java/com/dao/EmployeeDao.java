package com.dao;

import com.bean.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void insert(Employee employee){
        Session session=sessionFactory.getCurrentSession();
        session.persist(employee);
    }
    @Transactional
    public void updateEmployee(Employee employee){
        Session session=sessionFactory.getCurrentSession();
        session.update(employee);
    }
    @Transactional
    public void deleteEmployee(int id){
        Session session=sessionFactory.getCurrentSession();
        Employee employee=(Employee) session.get(Employee.class,new Integer(id));
        session.delete(employee);
    }
    @Transactional
    public List<Employee> displayEmployee(){
        Session session= sessionFactory.getCurrentSession();
        List<Employee> employees=session.createQuery("from Employee").list();
        return employees;
    }
}
