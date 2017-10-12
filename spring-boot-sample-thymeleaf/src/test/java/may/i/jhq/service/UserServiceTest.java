package may.i.jhq.service;

import may.i.jhq.entity.User;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by jinhuaquan on 2017/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImp userServiceImp;


    @Autowired
    private  UserMapper userMapper;
    //    @Before
//    public  void setUp(){
//        userServiceImp.deleteAllUsers();
//    }

    @Test
    @Cacheable
    public void  testInsertUser(){
        userServiceImp.create("jhq",12);
    }


    @Test
    public  void  testGetAllUser(){
        userServiceImp.getAllUsers();

    System.out.println(userServiceImp.getAllUsers());
    }

    @Test
    public  void  findUserByName(){
        Map<String,Object> map = new HashedMap();
        map.put("name","jhq1");
        map.put("age",23);
        userMapper.insertUser(map);
        User user = userMapper.findByName("jhq1");
        System.out.println(user.toString());
    }



}
