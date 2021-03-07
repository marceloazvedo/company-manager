package br.com.marceloazevedo.companymanager.dto

import javax.validation.constraints.NotBlank
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
data class CreateClientDTO(
        @NotBlank val email: String,
        @NotBlank val name: String,
        @NotBlank val password: String
)