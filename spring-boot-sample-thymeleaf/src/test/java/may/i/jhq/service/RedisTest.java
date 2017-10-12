package may.i.jhq.service;

import may.i.jhq.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jinhuaquan on 2017/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Test
    public void  stringRedisTemplateTest(){
        stringRedisTemplate.opsForValue().set("j","g");
        Assert.assertNotNull(stringRedisTemplate.opsForValue().get("j"));
    }

    @Test
    public  void objectRedisTemplateTest(){
        User user = new User();
        user.setId(1L);
        user.setName("1");
        user.setAge(23);

        redisTemplate.opsForValue().set(user.getName(),user);
        System.out.println(redisTemplate.opsForValue().get(user.getName()).toString());
        Assert.assertNotNull(redisTemplate.opsForValue().get(user.getName()));

    }

}
