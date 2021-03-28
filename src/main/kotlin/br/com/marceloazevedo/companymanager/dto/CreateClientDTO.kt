package br.com.marceloazevedo.companymanager.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateClientDTO(
        @field:NotEmpty @field:NotNull
        @field:Email(message = "{email.invalid}")
        val email: String,
        @field:NotEmpty @field:NotNull
        val name: String,
        @field:NotEmpty @field:NotNull
        val password: String
)