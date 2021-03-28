package br.com.marceloazevedo.companymanager.repository

import br.com.marceloazevedo.companymanager.model.Client
import org.springframework.data.jpa.repository.JpaRepository

interface ClientRepository: JpaRepository<Client, Long> {



}
