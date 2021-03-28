package br.com.marceloazevedo.companymanager.repository

import br.com.marceloazevedo.companymanager.model.Company
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<Company, Long>