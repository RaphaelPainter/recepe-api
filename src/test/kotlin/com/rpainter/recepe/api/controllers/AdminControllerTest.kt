package com.rpainter.recepe.api.controllers

import com.jayway.jsonpath.JsonPath
import com.rpainter.recepe.api.ApiApplication
import com.rpainter.recepe.api.Helper.ApiTestUser
import com.rpainter.recepe.api.entities.ApiUser
import com.squareup.moshi.Moshi
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
	fun correct_auth_should_return_accessToken() {
		//GIVEN
		val apiTestUser = getAuthenticatedTestAdmin()

		//WHEN
		mvc!!.perform(
			MockMvcRequestBuilders.get("/api/admin/users")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"email\": \"${apiTestUser.getEmail()}\", " +
					"\"password\": \"${apiTestUser.getPassword()}\"}")
			.header("authorization", "Bearer " + apiTestUser.getAccessToken())
			.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(status().isOk())
	}

	fun getAuthenticatedTestAdmin(): ApiTestUser {
		val password = "123"
		val encryptedPassword = BCryptPasswordEncoder().encode(password)

		val apiUsersList: MutableList<ApiUser> = ArrayList<ApiUser>()
		val user = ApiUser("John", "admin_test", encryptedPassword)
		apiUsersList.add(user)

		val authResponse = mvc!!.perform(
			MockMvcRequestBuilders.post("/api/auth")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"${user.email}\", " +
						"\"password\": \"${password}\"}")
				.accept(MediaType.APPLICATION_JSON)
		).andReturn().response.contentAsString

		val regex = "(?<=\\\"accessToken\\\":\\\")[^\\\"]*".toRegex()
		val token:String = regex.find(authResponse)!!.value

		val apiTestUser = ApiTestUser(user, token)

		return apiTestUser;
	}
}
