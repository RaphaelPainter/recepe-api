package com.rpainter.recepe.api.domain.services.cook

import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.model.Chef
import com.rpainter.recepe.api.server.adapters.CookRepository
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Assertions.assertEquals
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
class CookFindServiceTest {

	@Mock
	var dao: CookRepository? = null

	@InjectMocks
	val cookFindService: CookFindService? = null

	@Test
	@Throws(Exception::class)
	fun findAllCookShouldReturnAllCooks() {
		//GIVEN
		val password = "123"
		val encryptedPassword = BCryptPasswordEncoder().encode(password)
		val name = "name"
		val email = "email"
		val expectedAdmin = Account(name, email, encryptedPassword)
		expectedAdmin.setRole(Account.AccountRole.ADMIN)

		val expectedCookList = ArrayList<Chef>()
		val expectedCook = Chef()
		expectedCook.name = name
		expectedCook.account = expectedAdmin
		expectedCookList.add(expectedCook)

		//WHEN
		`when`(dao?.findAll()).thenReturn(expectedCookList)
		val obtained: MutableIterable<Chef>? = cookFindService?.findAll()

		//THEN
		assertEquals(expectedCookList, obtained)
		verify(dao, times(1))?.findAll();
	}
}
