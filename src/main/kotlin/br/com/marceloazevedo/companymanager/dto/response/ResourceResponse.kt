package br.com.marceloazevedo.companymanager.dto.response

import br.com.marceloazevedo.companymanager.enum.ResponseCode

data class ResourceResponse(
        val code: String,
        val message: String
) {
    constructor(response: ResponseCode): this(response.code, response.message)
}