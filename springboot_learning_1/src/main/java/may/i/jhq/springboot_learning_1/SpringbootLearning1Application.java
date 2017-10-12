package may.i.jhq.springboot_learning_1;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.PrintStream;

@SpringBootApplication
@ServletComponentScan//可以对servlet、filter、listener进行注册
public class SpringbootLearning1Application {

//	@Autowired
//	private RandomValue randomValue;

	public static void main(String[] args) {
//		SpringApplication.run(SpringbootLearning1Application.class, args);
		SpringApplication springBootApplication = new SpringApplication(SpringbootLearning1Application.class);
		springBootApplication.setBannerMode(Banner.Mode.CONSOLE);//设置banner输出到控制台
//		springBootApplication.setAdditionalProfiles("dev");
//		springBootApplication.setWebEnvironment(true);
		//代码里实现，自定义banner
		springBootApplication.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> aClass, PrintStream printStream) {
				printStream.println("May");
			}
		});

		springBootApplication.run();
	}

	/**
	 * 流式构建ApplicationContext
	 * @param args
	 */
//	public static void main(String[] args){
//		new SpringApplicationBuilder()
//				.sources(Parent.class)
//				.child(SpringbootLearning1Application.class)
//				.bannerMode(Banner.Mode.OFF)
//				.run(args);
//	}


	/**
	 * 实现ApplicationRunner及CommandLineRunner的run方法均可以仅在SpringApplication.run(…)完成之前调用
	 */
	@Component
	public class Mybean implements ApplicationRunner{

		@Override
		public void run(ApplicationArguments applicationArguments) throws Exception {
			System.out.println("applicationArguments:"+applicationArguments);
		}
	}

	@Component
	public class MyRunnerBean implements CommandLineRunner{

		@Override
		public void run(String... strings) throws Exception {
			System.out.println("strings"+strings);
//			System.out.println("RandomValue"+randomValue.toString());
		}
	}

	/**
	 * 定义了Application关闭时的退出码及动作
	 */
	@Component
	public class DestoryBean implements ExitCodeGenerator{

		@Override
		public int getExitCode() {
			return 0;
		}

		@PreDestroy
		public void destory(){
			System.out.println("i am shutdown!"+getExitCode());

		}
	}

}
