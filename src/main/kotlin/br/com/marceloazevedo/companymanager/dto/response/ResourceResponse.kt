package br.com.marceloazevedo.companymanager.dto.response

import br.com.marceloazevedo.companymanager.enum.ResponseCode

open class ResourceResponse(val code: String, var message: String) {
    constructor(response: ResponseCode): this(response.code, response.message)
}