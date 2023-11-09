package com.rpainter.recepe.api.controllers

import com.rpainter.recepe.api.ApiApplication
import com.rpainter.recepe.api.entities.ApiUser
import com.rpainter.recepe.api.services.impl.AuthenticationService
import configuration.TestConfig
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
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
		val adminEmail = "admin_test"
		val adminPassword = "123"

		//WHEN
		val authResponse = mvc!!.perform(post("/api/auth")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"email\": \"${adminEmail}\", " +
					"\"password\": \"${adminPassword}\"}")
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
		val authResponse = mvc!!.perform(post("/api/auth")
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
		val authResponse = mvc!!.perform(post("/api/auth")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"email\": \"${adminEmail}\", " +
					"\"password\": \"${adminPassword}\"}")
			.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(status().isForbidden())
	}
}
