package may.i.jhq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by jinhuaquan on 2017/6/21.
 */
@Service
public class UserServiceImp implements  UserService{

    @Autowired
    @Qualifier("secondJdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    public  static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);


    @Override
    public void create(String name, Integer age) {
        logger.debug("add a new user");
        jdbcTemplate.update("INSERT INTO USER(NAME ,AGE) VALUES (?,?)",name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM USER WHERE name=?",name);
    }

    @Override
    public Integer getAllUsers() {
     return jdbcTemplate.queryForObject("SELECT count(*) FROM USER ",Integer.class);
    }

    @Cacheable
    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM USER ");
    }
}
