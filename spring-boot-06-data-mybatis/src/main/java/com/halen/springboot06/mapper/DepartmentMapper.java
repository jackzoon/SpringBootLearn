package com.halen.springboot06.mapper;

import com.halen.springboot06.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * Created By Halen 2020/5/17 17:06
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id=#{id}")
    public Department getDepById(Integer id);

    @Delete("delete from department where id=#{id}")
    public int deleteDepById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName}) ")
    public int insertDept(Department department);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

}
