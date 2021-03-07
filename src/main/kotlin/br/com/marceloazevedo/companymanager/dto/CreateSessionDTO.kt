package br.com.marceloazevedo.companymanager.dto

import javax.validation.constraints.NotBlank
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class CreateSessionDTO {

    @NotBlank
    var email: String? = null

    @NotBlank
    var password: String? = null

    constructor() {}

    constructor(email: String?, password: String?) {
        this.email = email
        this.password = password
    }

}