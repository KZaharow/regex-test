import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class Config {

    @Bean
    public DataSource postgresDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgres://localhost:5432/public");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");

        return dataSource;
    }

    @Bean
    public Resolver resolver(){
        return new Resolver(
            "complince_fin_operation#column#id:complince_fin_operation_id&k1:v1|k2:v2;",
            "hello"
        );
    }
}
