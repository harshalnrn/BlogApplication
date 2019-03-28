package technicalblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.DriverManager;

//this class is required to create JPA instances using xml and store into spring container (EntityManagerFactory, EntityManager)
@Configuration
public class JpaConfig {

//bean method loads the single instance of EntityManagerFactory in the spring container and makes it available throughout the application
@Bean
public EntityManagerFactory entityManagerFactory(){

    LocalContainerEntityManagerFactoryBean enfb=new LocalContainerEntityManagerFactoryBean();
    enfb.setPersistenceXmlLocation("classpath:META-INF/hibernate_cfg.xml");
    enfb.afterPropertiesSet();
    return enfb.getObject();
}
@Bean
//this object shall have all db connection details to connect to database
public DataSource dataSource(){
    DriverManagerDataSource ds=new DriverManagerDataSource();
ds.setDriverClassName("org.postgresql.Driver");
ds.setUrl("jdbc:postgresql://localhost:5432/bloggingApplication");
ds.setUsername("postgres");
ds.setPassword("Kvihar@24");
return ds;
}

}
