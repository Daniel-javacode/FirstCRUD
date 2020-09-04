package javamentor.FirstCRUD.configuration;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "javamentor.FirstCRUD")
@EnableTransactionManagement
@PropertySource(value = "classpath:db.properties")
public class HibernateConfig {
    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    /*@Bean
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("javamentor.FirstCRUD");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(hibernateProperties);
        em.setPersistenceUnitName("mytestdomain");
        em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        em.afterPropertiesSet();
        return em.getObject();
    }*/

    /*@Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("testgroup.filmography.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }*/

    /*@Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }*/

    //JPA-cfg-begin
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean managerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        managerFactoryBean.setJpaVendorAdapter(getJpaVendorAdapter());
        managerFactoryBean.setDataSource(dataSource());
        managerFactoryBean.setPersistenceUnitName("myJpaPersistenceUnit");
        managerFactoryBean.setPackagesToScan("FirstCRUD");
        managerFactoryBean.setJpaProperties(hibernateProperties());
        return managerFactoryBean;
    }

    @Bean
    public JpaVendorAdapter getJpaVendorAdapter() {
        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        return jpaVendorAdapter;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager txManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(
                getEntityManagerFactoryBean()
                        .getObject()
        );
        return jpaTransactionManager;
    }
    //JPA-cfg-end

}
