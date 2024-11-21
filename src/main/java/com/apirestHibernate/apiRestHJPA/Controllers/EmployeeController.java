package com.apirestHibernate.apiRestHJPA.Controllers;

import com.apirestHibernate.apiRestHJPA.Entity.EmployeeEntity;
import com.apirestHibernate.apiRestHJPA.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees() {
        List<EmployeeEntity> employees = employeeService.get();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/one/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        EmployeeEntity employee = employeeService.get(id);
        if (employee == null) {
            return new ResponseEntity<>("Empleado no encontrado",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeEntity employee) {
        try {
            employeeService.save(employee);
            return new ResponseEntity<>("Empleado guardado correctamente", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>("Empleado eliminado correctamente", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("No se encuentra el empleado", HttpStatus.NOT_FOUND);
        }
    }
}
