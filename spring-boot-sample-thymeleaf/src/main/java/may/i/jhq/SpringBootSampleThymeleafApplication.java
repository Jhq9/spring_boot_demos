package may.i.jhq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class SpringBootSampleThymeleafApplication {

	@RequestMapping(value = "/")
	public  String index(ModelMap modelMap){
		modelMap.addAttribute("host","http://blog.didispace.com");

		return  "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleThymeleafApplication.class, args);
	}
}
