package com.halen.springboot06.mapper;

import com.halen.springboot06.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);

}
