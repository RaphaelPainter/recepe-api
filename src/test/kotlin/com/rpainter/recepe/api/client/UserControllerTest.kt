package com.rpainter.recepe.api.client

import com.rpainter.recepe.api.ApiApplication
import com.rpainter.recepe.api.Helper.*
import com.rpainter.recepe.api.Helper.TEST_USER_EMAIL
import configuration.TestConfig
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*




@SpringBootTest(classes = arrayOf(ApiApplication::class, TestConfig::class))
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	private val mvc: MockMvc? = null


}
