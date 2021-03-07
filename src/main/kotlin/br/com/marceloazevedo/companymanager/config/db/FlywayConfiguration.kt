package br.com.marceloazevedo.companymanager.config.db

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class FlywayConfiguration {

    @Autowired
    fun flywayConfiguration(datasource: DataSource?) {
        Flyway.configure().baselineOnMigrate(true).dataSource(datasource).load().migrate()
    }

}