package com.example;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.h2.server.TcpServer;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class SpringConfig {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseServerOne() throws SQLException {
        Server server = new Server(new TcpServer(), "-tcp", "-tcpAllowOthers", "-tcpPort", "9091");
        logger.info("starting inMemoryH2Database 9091");
        return server;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseServerTwo() throws SQLException {
        Server server = new Server(new TcpServer(), "-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
        logger.info("starting inMemoryH2Database 9092");
        return server;
    }

    @Primary
    @Bean(name = "employee")
    @ConfigurationProperties(prefix = "foo.datasource")
    public DataSource employeeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "student")
    @ConfigurationProperties(prefix = "bar.datasource")
    public DataSource studentDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "employeeJdbcTemplate")
    public JdbcTemplate employeeJdbcTemplate(@Qualifier("employee") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "studentJdbcTemplate")
    public JdbcTemplate studentJdbcTemplate(@Qualifier("student") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
