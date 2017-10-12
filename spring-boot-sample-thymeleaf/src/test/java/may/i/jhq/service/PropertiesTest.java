package may.i.jhq.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jinhuaquan on 2017/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Value("${may.i.jhq.name}")
    private  String name;

    @Value("${may.i.jhq.age}")
    private  Integer age;

    @Value("${may.i.jhq.introduction}")
    private  String instroduction;

    @Value("${may.i.jhq.randvalue}")
    private String randValue;

    @Value("${may.i.jhq.randlong}")
    private Long randLong;

    @Test
    public void  getValueTest(){
        System.out.println("name:"+name+"  age:"+age+" randvalue:"+randValue+"  randLong:"+randLong);
        System.out.println(instroduction);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
