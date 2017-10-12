package may.i.jhq.service;

import may.i.jhq.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by jinhuaquan on 2017/6/22.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE name=#{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(name,age) VALUES(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
    int insertUser(Map<String,Object> map);

    @Insert("INSERT INTO USER(name,age) VALUES(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
    int insertByUser(User user);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void  updateUser(@Param("age")Integer age,@Param("name") String name);

    @Delete("DELETE FROM user WHERE name =#{name}")
    void delete(@Param("name") String name);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();

}
