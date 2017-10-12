package may.i.jhq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import may.i.jhq.domain.Friend;
import may.i.jhq.repository.FriendRepository;

@SpringBootApplication
@RestController
public class MySqlApplication {
	
	public static final Logger logger = LoggerFactory.getLogger(MySqlApplication.class);
	
	@Autowired
	private FriendRepository friendRepository;
	
	
	@RequestMapping(value="/friend/save",method=RequestMethod.POST)
	@ResponseBody
	public Friend saveFriend(@RequestBody Friend friend){
		
		logger.debug("make a new friend!");
		
		return friendRepository.save(friend);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MySqlApplication.class, args);
	}
}
