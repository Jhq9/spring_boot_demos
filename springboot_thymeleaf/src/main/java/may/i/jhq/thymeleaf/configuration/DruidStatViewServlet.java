package may.i.jhq.thymeleaf.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * 相当于在web.xml中声明了一个servlet， 等价于如下的配置信息（controller.xml):
 * <p>
 * <servlet>
 * <servlet-name>DruidStatView</servlet-name>
 * <servlet-class>com.alibaba.druid.support.http.StatViewServlet</servlet-class>
 * </servlet>
 * <servlet-mapping>
 * <servlet-name>DruidStatView</servlet-name>
 * <url-pattern>/druid/*</url-pattern>
 * </servlet-mapping>
 */
@WebServlet(urlPatterns = "/druid/*", initParams = {@WebInitParam(name = "allow", value = "127.0.0.1,192.168.163.1"),// IP白名单(没有配置或者为空，则允许所有访问)
                                                       @WebInitParam(name = "deny", value = "192.168.1.73"),// IP黑名单 (存在共同时，deny优先于allow)
                                                       @WebInitParam(name = "loginUsername", value = "admin"),// 用户名
                                                       @WebInitParam(name = "loginPassword", value = "123456"),// 密码
                                                       @WebInitParam(name = "resetEnable", value = "false")// 禁用HTML页面上的“Reset All”功能
})
public class DruidStatViewServlet extends DruidStatProperties.StatViewServlet {

}
