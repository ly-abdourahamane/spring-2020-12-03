package fr.formation.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class DataConfig {
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder() //LE BUILDER AIDE A FABRIQUER LA DATASOURCE EMBARQUEE
			.setType(EmbeddedDatabaseType.H2)
			.addScript("classpath:/schema.sql")
			.addScript("classpath:/data.sql")
			.build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("fr.formation.Model");
		emf.setJpaVendorAdapter(adapter);
		emf.setJpaProperties(this.hibernateProperties());
		
		return emf;
	}
	
	public Properties hibernateProperties() {
		Properties props = new Properties();
		
//		props.setProperty("hibernate.hbm2ddl.auto", "update");
		props.setProperty("hibernate.show_sql", "true");
		
		
		return props;
	}
	
	//GESTIONNAIRE DE TRANSACTIONS
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}
}