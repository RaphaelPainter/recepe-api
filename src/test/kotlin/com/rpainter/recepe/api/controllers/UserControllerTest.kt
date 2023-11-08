package com.rpainter.recepe.api.controllers

import com.rpainter.recepe.api.entities.ApiUser
import com.rpainter.recepe.api.entities.Role
import com.rpainter.recepe.api.services.impl.AuthenticationService
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


object MockitoHelper {
	fun <T> anyObject(): T {
		Mockito.any<T>()
		return uninitialized()
	}
	@Suppress("UNCHECKED_CAST")
	fun <T> uninitialized(): T = null as T
}

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {


	@Autowired
	private val mvc: MockMvc? = null

	@Mock
	val authenticationService: AuthenticationService? = null

	@Test
	@Throws(Exception::class)
	fun admin_auth_should_return_accessToken() {
		//GIVEN
		val accessToken = "accessToken"
		val password = "123"
		val encryptedPassword = BCryptPasswordEncoder().encode(password)

		val apiUsersList: MutableList<ApiUser> = ArrayList<ApiUser>()
		val user = ApiUser("John", "admin", encryptedPassword)
		apiUsersList.add(user)

		`when`(authenticationService?.authentication(MockitoHelper.anyObject())).thenReturn(AuthenticationResponse(accessToken))

		//WHEN
		mvc!!.perform(post("/api/auth")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"email\": \"${user.email}\", " +
					"\"password\": \"${password}\"}")
			.accept(MediaType.APPLICATION_JSON)
			)

		//THEN
			.andExpect(
				content()
					.contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.accessToken").exists());
		verify(authenticationService, times(1))?.authentication(MockitoHelper.anyObject());

	}
}
