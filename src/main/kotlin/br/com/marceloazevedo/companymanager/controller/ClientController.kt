package br.com.marceloazevedo.companymanager.controller

import br.com.marceloazevedo.companymanager.dto.CreateClientDTO
import br.com.marceloazevedo.companymanager.dto.response.ResourceResponse
import br.com.marceloazevedo.companymanager.enum.ResponseCode.SUCCESS
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/client")
class ClientController {

    @PostMapping
    fun create(@RequestBody @Valid clientDTO: CreateClientDTO) : ResponseEntity<ResourceResponse> =
            ResponseEntity(ResourceResponse(SUCCESS), HttpStatus.CREATED)

}