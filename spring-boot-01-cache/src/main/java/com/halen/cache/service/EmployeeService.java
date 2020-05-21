package com.halen.cache.service;

import com.halen.cache.bean.Employee;
import com.halen.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * Created By Halen 2020/5/18 22:03
 */
@Service
@CacheConfig(cacheNames = "emp",cacheManager = "employeeCacheManager")
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;


//    @Cacheable(value = {"emp"},key = "#root.methodName+'['+#id+']'") //将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存汇总获取
    @Cacheable(value = {"emp"})
    public Employee getEmp(Integer id) {
        System.out.println("查询" + id +"号员工");
        return employeeMapper.getEmpById(id);
    }

    /**
     * @CachePut:既调用方法，又更新缓存
     * 修改了数据库中的某个数据，同时更新缓存
     * 运行时机：
     *  1、先调用目标方法
     *  2、将目标方法的结果缓存起来
     */
    @CachePut(value = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("updateEmp:" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     *@CacheEvict:缓存清除
     * 通过key指定要清除的数据
     * allEntries = true:指定清除这个缓存中所有的数据
     * beforeInvocation = false：缓存的清除是否在方法之前执行
     *  默认代表是在方法之后执行
     */
    @CacheEvict(value = "emp",key = "#id",beforeInvocation = true)
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp:" + id);
        //employeeMapper.deleteEmpById(id);
        int i = 10/0;
    }

    @Caching(
            cacheable = {@Cacheable(value = "emp",key = "#lastName")},
            put = {@CachePut(value = "emp",key = "#result.id"),@CachePut(value = "emp",key = "#result.email")}
    )
    public Employee getEmpByLastName(String lastName) {
        return employeeMapper.getEmpBYLastName(lastName);
    }
}
