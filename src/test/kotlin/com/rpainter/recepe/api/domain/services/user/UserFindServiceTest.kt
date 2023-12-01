package com.rpainter.recepe.api.domain.services.user

import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.services.user.UserFindService
import com.rpainter.recepe.api.server.adapters.UserRepository
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
class UserFindServiceTest {

	@Mock
	var dao: UserRepository? = null

	@InjectMocks
	val userFindService: UserFindService? = null

	@Test
	@Throws(Exception::class)
	fun findByEmailShouldReturnUserWhenUserExists() {
		//GIVEN
		val password = "123"
		val encryptedPassword = BCryptPasswordEncoder().encode(password)
		val apiUsersList = ArrayList<Account>()
		val name = "name"
		val email = "email"
		val role = Account.AccountRole.ADMIN

		val expectedAdmin = Account(name, email, encryptedPassword)
		expectedAdmin.setRole(role)
		apiUsersList.add(expectedAdmin)

		//WHEN
		`when`(dao?.findAll()).thenReturn(apiUsersList)
		val obtained: Account? = userFindService?.findByEmail(expectedAdmin.email)

		//THEN
		assert( expectedAdmin.equals(obtained))
		verify(dao, times(1))?.findAll();
	}

	@Test
	@Throws(Exception::class)
	fun findByEmailShouldReturnNullWhenUserDoesNotExists() {
		//GIVEN
		val password = "123"
		val encryptedPassword = BCryptPasswordEncoder().encode(password)
		val apiUsersList = ArrayList<Account>()
		val name = "name"
		val email = "email"
		val role = Account.AccountRole.ADMIN

		val adminNotInDB = Account(name, email, encryptedPassword)
		adminNotInDB.setRole(role)

		//WHEN
		`when`(dao?.findAll()).thenReturn(apiUsersList)
		val obtained: Account? = userFindService?.findByEmail(adminNotInDB.email)

		//THEN
		assert(obtained == null)
		verify(dao, times(1))?.findAll();
	}
}
