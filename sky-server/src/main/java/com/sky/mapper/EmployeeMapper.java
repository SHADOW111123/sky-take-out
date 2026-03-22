package com.sky.mapper;

import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);
    @Insert("INSERT INTO employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user, status) " +
            "VALUES (#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser}, #{status})")
    void insert(Employee employee);

    @Select("SELECT * FROM employee LIMIT #{start}, #{size}")
    List<Employee> PageQuery(@Param("start") int start,
                             @Param("size") int size);


    void update(Employee employee);

    @Select("select * from employee where  id = #{id} ")
    Employee getByid(Long id);

}
