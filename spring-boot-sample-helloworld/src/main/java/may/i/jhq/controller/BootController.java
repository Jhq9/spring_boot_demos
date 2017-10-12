package may.i.jhq.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import may.i.jhq.entity.User;

@SpringBootApplication
@RestController
public class BootController {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	public static Logger logger = LoggerFactory.getLogger(BootController.class);
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String, String> stringValueOperations;
	
	@Resource(name="redisTemplate")
	ValueOperations<String, User> objectValueOperations;
	
	
	
	
	@RequestMapping(value="/hello")
	@ResponseBody
	public String sayHello(){
		logger.debug("Say Hello World!");
		return "Hello World!";
	}
	
	
	@RequestMapping(value="/redis/string",method=RequestMethod.GET)
	public String saveAndGetFromRedis(@RequestParam String key,@RequestParam String value){
		
		logger.debug("save key-value at redis");
		stringValueOperations.set(key, value);
		
		logger.debug("get value from redis by key");
		
		return "this is the value :"+stringValueOperations.get(key)+" of the key "+key+" in the redis";
		
	}
	
	@RequestMapping(value="/redis/object",method=RequestMethod.GET)
	@ResponseBody
	public User saveAndGetUser(@RequestParam String userName,
							   @RequestParam Integer age,
							   @RequestParam String password){
		
		logger.debug("user information is coming in");
		
		User user = new User();
		
		user.setAge(age);
		user.setPassword(password);
		user.setUserName(userName);
		
		objectValueOperations.set(userName, user);
		
		logger.debug("user is saved in redis");
		redisTemplate.delete(userName);
		return objectValueOperations.get(userName);
		
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootController.class, args);
	}
}
