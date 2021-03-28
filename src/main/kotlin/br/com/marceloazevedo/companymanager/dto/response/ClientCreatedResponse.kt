package br.com.marceloazevedo.companymanager.dto.response

import br.com.marceloazevedo.companymanager.enum.ResponseCode

data class ClientCreatedResponse(
        val name: String,
        val email: String
): ResourceResponse(ResponseCode.SUCCESS)