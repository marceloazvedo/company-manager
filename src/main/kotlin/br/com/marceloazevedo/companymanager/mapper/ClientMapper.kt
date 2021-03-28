package br.com.marceloazevedo.companymanager.mapper

import br.com.marceloazevedo.companymanager.dto.response.ClientCreatedResponse
import br.com.marceloazevedo.companymanager.model.Client
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.stereotype.Component
import java.util.Locale

@Component
class ClientMapper {

    @Autowired
    private lateinit var messageSource: MessageSource

    fun toSuccessCreatedResponse(client: Client): ClientCreatedResponse {
        val response = ClientCreatedResponse(client.user.name, client.user.email)
        messageSource.getMessage(response.message, null, Locale.ENGLISH).also { response.message = it }
        return response
    }
}