package com.apirestHibernate.apiRestHJPA.Service;

import com.apirestHibernate.apiRestHJPA.Entity.EmployeeEntity;

import java.util.List;


public interface EmployeeService {

    List<EmployeeEntity> get();

    EmployeeEntity get(int ID);

    void save (EmployeeEntity employee);

    void delete(int ID);

}
