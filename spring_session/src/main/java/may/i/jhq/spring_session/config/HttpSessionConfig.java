package may.i.jhq.spring_session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author jinhuaquan
 * @create 2017-09-13 上午9:14
 * @desc 配置类开启Redis Http Session
 **/
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {


}
