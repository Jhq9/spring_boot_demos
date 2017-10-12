package may.i.jhq;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by jinhuaquan on 2017/6/21.
 */
@Configuration
public class DatasourceConfig {

    @Bean(name = "firstDatasource")
    @Qualifier("firstDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondDatasource")
    @Qualifier("secondDatasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource secondDatasource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name="firstJdbcTemplate")
    public JdbcTemplate firstJdbcTemplate(@Qualifier("firstDatasource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="secondJdbcTemplate")
    public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDatasource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

}
