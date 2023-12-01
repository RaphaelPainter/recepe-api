package com.rpainter.recepe.api.client

import com.rpainter.recepe.api.ApiApplication
import com.rpainter.recepe.api.Helper.*
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.model.Chef
import com.rpainter.recepe.api.domain.services.cook.CookFindService
import configuration.TestConfig
import mu.KotlinLogging
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*


@SpringBootTest(classes = arrayOf(ApiApplication::class, TestConfig::class))
@AutoConfigureMockMvc
class CookControllerTest {

	@Autowired
	private val mvc: MockMvc? = null

	@MockBean
	val cookFindService: CookFindService? = null

	private val logger = KotlinLogging.logger {}


	@Test
	@Throws(Exception::class)
	fun user_should_be_able_to_get_cooks() {
		//GIVEN
		/*val apiTestUser = mockAuthentification(mvc!!, TEST_USER_EMAIL, TEST_USER_PASSWORD)

		val cooks = LinkedList<Chef>()
		val cook = Chef("Chef")
		val account =  Account("name", "email", "password")
		account.setRole(Account.AccountRole.ADMIN)
		cook.users_fk = account
		cooks.add(cook)

		`when`(cookFindService?.findAll()).thenReturn(cooks)

		//WHEN
		mvc.perform(
			MockMvcRequestBuilders.get(RootPath.COOK)
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\": \"${apiTestUser.email}\", " +
						"\"password\": \"${apiTestUser.password}\"}")
				.header("authorization", "Bearer " + apiTestUser.token)
				.accept(MediaType.APPLICATION_JSON)
		)
			//THEN
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").exists())
			.andExpect(jsonPath("$").isArray )
			.andExpect (
				content().json(TestObjectMapper.getInstance()!!.writeValueAsString(cooks))
			)*/
	}
}
