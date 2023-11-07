package com.rpainter.recepe.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories("com.rpainter.recepe.api.*")
@ComponentScan("com.rpainter.recepe.api.*")
@EntityScan("com.rpainter.recepe.api.*")
@ConfigurationPropertiesScan("com.rpainter.recepe.api.*")

@SpringBootApplication
class ApiApplication


fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
