package may.i.jhq.thymeleaf.dao;

import may.i.jhq.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jinhuaquan
 * @create 2017-09-26 下午5:28
 * @desc User实体的dao
 **/
public interface UserDAO extends JpaRepository<User, Long>{



}
