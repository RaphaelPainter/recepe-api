package com.rpainter.recepe.api.controllers

import com.rpainter.recepe.api.ApiApplication
import com.rpainter.recepe.api.Helper.*
import com.rpainter.recepe.api.Helper.TEST_USER_EMAIL
import com.rpainter.recepe.api.entities.ApiUser
import configuration.TestConfig
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*




@SpringBootTest(classes = arrayOf(ApiApplication::class, TestConfig::class))
@AutoConfigureMockMvc
class AdminControllerTest {

	@Autowired
	private val mvc: MockMvc? = null

	@Test
	@Throws(Exception::class)
	fun admin_should_be_authorized_to_get_users() {
		//GIVEN
		val apiTestAdmin = mockAuthentification(mvc!!,TEST_ADMIN_EMAIL, TEST_ADMIN_PASSWORD)

		//WHEN
		mvc!!.perform(
			MockMvcRequestBuilders.get("/api/admin/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"${apiTestAdmin.email}\", " +
						"\"password\": \"${apiTestAdmin.password}\"}")
				.header("authorization", "Bearer " + apiTestAdmin.token)
				.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(status().isOk())
	}

	@Test
	@Throws(Exception::class)
	fun admin_should_be_effectively_able_to_get_users() {
		//GIVEN
		val apiTestAdmin = mockAuthentification(mvc!!,TEST_ADMIN_EMAIL, TEST_ADMIN_PASSWORD)

		//WHEN
		mvc!!.perform(
			MockMvcRequestBuilders.get("/api/admin/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"${apiTestAdmin.email}\", " +
						"\"password\": \"${apiTestAdmin.password}\"}")
				.header("authorization", "Bearer " + apiTestAdmin.token)
				.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(jsonPath("$.users").exists())
	}



	@Test
	@Throws(Exception::class)
	fun user_should_not_be_authorized_to_get_users() {
		//GIVEN
		val apiTestUser = mockAuthentification(mvc!!,TEST_USER_EMAIL, TEST_USER_PASSWORD)

		//WHEN
		mvc!!.perform(
			MockMvcRequestBuilders.get("/api/admin/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"${apiTestUser.email}\", " +
						"\"password\": \"${apiTestUser.password}\"}")
				.header("authorization", "Bearer " + apiTestUser.token)
				.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(status().isForbidden())
	}
}
