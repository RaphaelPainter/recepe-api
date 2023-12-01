package com.rpainter.recepe.api.client

import com.rpainter.recepe.api.ApiApplication
import com.rpainter.recepe.api.Helper.TEST_ADMIN_EMAIL
import com.rpainter.recepe.api.Helper.TEST_ADMIN_PASSWORD
import configuration.TestConfig
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*



@SpringBootTest(classes = arrayOf(ApiApplication::class, TestConfig::class))
@AutoConfigureMockMvc
class AuthControllerTest {

	@Autowired
	private val mvc: MockMvc? = null

	@Test
	@Throws(Exception::class)
	fun correct_auth_should_return_accessToken() {
		//GIVEN

		//WHEN
		mvc!!.perform(post(RootPath.AUTH)
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"email\": \"${TEST_ADMIN_EMAIL}\", " +
					"\"password\": \"${TEST_ADMIN_PASSWORD}\"}")
			.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.accessToken").exists())
	}

	@Test
	@Throws(Exception::class)
	fun auth_with_non_existant_user_should_be_forbidden() {
		//GIVEN
		val adminEmail = "wrong_email"
		val adminPassword = "123"

		//WHEN
		mvc!!.perform(post(RootPath.AUTH)
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"email\": \"${adminEmail}\", " +
					"\"password\": \"${adminPassword}\"}")
			.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(status().isForbidden())
	}

	@Test
	@Throws(Exception::class)
	fun auth_with_wrong_password_should_be_forbidden() {
		//GIVEN
		val adminEmail = "admin_test"
		val adminPassword = "wrong_password"

		//WHEN
		mvc!!.perform(post(RootPath.AUTH)
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"email\": \"${adminEmail}\", " +
					"\"password\": \"${adminPassword}\"}")
			.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(status().isForbidden())
	}
}
