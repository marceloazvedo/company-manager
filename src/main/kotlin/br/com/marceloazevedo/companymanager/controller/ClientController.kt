package br.com.marceloazevedo.companymanager.controller

import br.com.marceloazevedo.companymanager.dto.CreateClientDTO
import br.com.marceloazevedo.companymanager.model.User
import br.com.marceloazevedo.companymanager.service.ClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/clients")
class ClientController {

    @Autowired
    private lateinit var clientService: ClientService

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@Valid @RequestBody clientDTO: CreateClientDTO): ResponseEntity<User> =
            ResponseEntity(clientService.create(clientDTO), HttpStatus.CREATED)

}
