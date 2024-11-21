package com.apirestHibernate.apiRestHJPA.DAO;

import com.apirestHibernate.apiRestHJPA.Entity.EmployeeEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<EmployeeEntity> get() {
        return entityManager.createQuery("FROM EmployeeEntity", EmployeeEntity.class).getResultList();
    }

    @Override
    public EmployeeEntity get(int id) {
        return entityManager.find(EmployeeEntity.class, id);
    }

    @Override
    public void save(EmployeeEntity employee) {

        EmployeeEntity employeeEntity = entityManager.merge(employee);
        employee.setId(employeeEntity.getId());
    }

    @Override
    public void delete(int ID) {
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, ID);
        entityManager.remove(employee);
    }

    @Override
    public boolean existsById(int ID) {
        EmployeeEntity employee = entityManager.find(EmployeeEntity.class, ID);
        return employee != null;
    }
}
