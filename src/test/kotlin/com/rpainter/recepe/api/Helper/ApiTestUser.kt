package com.rpainter.recepe.api.Helper

import com.rpainter.recepe.api.client.RootPath
import mu.KotlinLogging
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

data class ApiTestUser(val email:String, val password: String, val token : String)

//Those should be present in test database before launching tests !
const val TEST_ADMIN_EMAIL = "admin_test"
const val TEST_ADMIN_PASSWORD = "123"
const val TEST_USER_EMAIL = "user_test"
const val TEST_USER_PASSWORD = "123"

const val ACCESS_TOKEN_REGEX = 	"(?<=\\\"accessToken\\\":\\\")[^\\\"]*"
private val logger = KotlinLogging.logger {}


fun mockAuthentification(mvc: MockMvc, email:String, password:String): ApiTestUser {
    val authResponse = mvc.perform(
        MockMvcRequestBuilders.post(RootPath.AUTH)
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"email\": \"${email}\", " +
                    "\"password\": \"${password}\"}")
            .accept(MediaType.APPLICATION_JSON)
    ).andReturn().response.contentAsString

    logger.info {("authResponse : $authResponse")}

    val regex = ACCESS_TOKEN_REGEX.toRegex()
    val token:String = regex.find(authResponse)!!.value

    return ApiTestUser(email, password, token)
}
