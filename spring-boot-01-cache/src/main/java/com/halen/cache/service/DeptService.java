package com.halen.cache.service;

import com.halen.cache.bean.Department;
import com.halen.cache.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

/**
 * Created By Halen 2020/5/20 15:31
 */
@Service
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /*@Cacheable(cacheNames = "dept",cacheManager = "deptCacheManager")
    public Department getDeptById(Integer id) {
        System.out.println("查询部门：" + id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }*/

    @Qualifier("deptCacheManager")
    @Autowired
    private RedisCacheManager deptCacheManager;

    public Department getDeptById(Integer id) {
        System.out.println("查询部门：" + id);
        Department department = departmentMapper.getDeptById(id);
        Cache dept = deptCacheManager.getCache("dept");
        dept.put("dept:1", department);

        return department;
    }

}
