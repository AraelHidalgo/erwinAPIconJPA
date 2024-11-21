package com.apirestHibernate.apiRestHJPA.Service;

import com.apirestHibernate.apiRestHJPA.DAO.EmployeeDAO;
import com.apirestHibernate.apiRestHJPA.Entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public List<EmployeeEntity> get() {
        return employeeDAO.get();
    }

    @Transactional
    @Override
    public EmployeeEntity get(int id) {
        return employeeDAO.get(id);
    }

    @Transactional
    @Override
    public void save(EmployeeEntity employee) {
        // Validar que todos los campos estén completos
        if (employee.getName() == null || employee.getName().trim().isEmpty() ||
                employee.getUsername() == null || employee.getUsername().trim().isEmpty() ||
                employee.getGender() == null || employee.getGender().trim().isEmpty() ||
                employee.getDepartament() == null || employee.getDepartament().trim().isEmpty() ||
                employee.getPassword() == null || employee.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Todos los campos son obligatorios y no pueden estár vacíos.");
        }

        // Verificar si el empleado ya existe por ID
        if (employee.getId() != 0 && employeeDAO.existsById(employee.getId())) {
            throw new RuntimeException("El empleado con ID " + employee.getId() + " ya existe.");
        }

        // Guardar nuevo empleado
        employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void delete(int ID) {
        employeeDAO.delete(ID);
    }
}
