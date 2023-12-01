package configuration

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.test.context.TestPropertySource
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@TestPropertySource(locations=["classpath:testApplication.yaml"])
@EnableTransactionManagement
class TestConfig {

}