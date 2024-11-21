package com.apirestHibernate.apiRestHJPA.DAO;

import com.apirestHibernate.apiRestHJPA.Entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDAO {

    List<EmployeeEntity> get();

    EmployeeEntity get(int id);

    void save (EmployeeEntity employee);

    void delete(int ID);

    boolean existsById(int ID);
}
