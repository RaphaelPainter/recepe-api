package com.rpainter.recepe.api.services

import com.rpainter.recepe.api.entities.ApiUser
import com.rpainter.recepe.api.entities.Role
import com.rpainter.recepe.api.repositories.UserRepository
import com.rpainter.recepe.api.services.impl.UserService
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@SpringBootTest
@AutoConfigureMockMvc
class UserServicesTest {

	@Mock
	var dao: UserRepository? = null

	@InjectMocks
	val userService: UserService? = null



	@Test
	@Throws(Exception::class)
	fun admin_auth_should_return_accessToken() {
		//GIVEN
		val password = "123"
		val encryptedPassword = BCryptPasswordEncoder().encode(password)
		val apiUsersList: MutableList<ApiUser> = ArrayList<ApiUser>()
		val expectedAdmin = ApiUser("John", "admin", encryptedPassword)
		expectedAdmin.setRole(Role.ADMIN)
		apiUsersList.add(expectedAdmin)

		//WHEN
		`when`(dao?.findAll()).thenReturn(apiUsersList)
		val obtained: ApiUser? = userService?.findByEmail(expectedAdmin.email)

		//THEN
		assert( expectedAdmin == obtained)
		verify(dao, times(1))?.findAll();
	}
}
