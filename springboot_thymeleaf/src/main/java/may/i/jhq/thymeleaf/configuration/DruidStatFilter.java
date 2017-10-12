package may.i.jhq.thymeleaf.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * 相当于在web.xml中声明了一个servlet， 等价于如下的配置信息（controller.xml):
 *
 * <filter>
 * <filter-name>DruidWebStatFilter</filter-name>
 * <filter-class>com.alibaba.druid.support.http.WebStatFilter</filter-class>
 * <init-param>
 * <param-name>exclusions</param-name>
 * <param-value>*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*</param-value>
 * </init-param>
 * </filter>
 * <filter-mapping>
 * <filter-name>DruidWebStatFilter</filter-name>
 * <url-pattern>/*</url-pattern>
 * </filter-mapping>
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
    initParams={
        @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") //忽略的资源类型
    }
)
public class DruidStatFilter extends DruidStatProperties.WebStatFilter{


}
