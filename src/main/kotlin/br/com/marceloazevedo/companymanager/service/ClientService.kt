package br.com.marceloazevedo.companymanager.service

import br.com.marceloazevedo.companymanager.dto.CreateClientDTO
import br.com.marceloazevedo.companymanager.model.Client

interface ClientService {

    fun create(createClient: CreateClientDTO): Client

}