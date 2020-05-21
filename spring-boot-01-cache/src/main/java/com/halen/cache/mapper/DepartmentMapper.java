package com.halen.cache.mapper;

import com.halen.cache.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created By Halen 2020/5/18 21:49
 */
@Mapper
public interface DepartmentMapper {
    @Select("select * from department WHERE id=#{id}")
    Department getDeptById(Integer id);
}
