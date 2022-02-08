package cn.prinf.demos.junit.spring.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.prinf.demos.junit.spring.entity.User;
import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAll();

    void insert(@Param("user") User employee);
}
