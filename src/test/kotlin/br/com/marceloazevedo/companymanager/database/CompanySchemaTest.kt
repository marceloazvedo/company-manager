package br.com.marceloazevedo.companymanager.database

import br.com.marceloazevedo.companymanager.enum.UserType
import br.com.marceloazevedo.companymanager.model.Company
import br.com.marceloazevedo.companymanager.model.User
import br.com.marceloazevedo.companymanager.repository.CompanyRepository
import org.hibernate.validator.internal.util.Contracts.assertNotNull
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class CompanySchemaTest {

	@Autowired
	lateinit var companyRepository: CompanyRepository

	@AfterEach
	fun afterEachTest() {
		companyRepository.deleteAll()
	}

	@Test
	fun `should create a company with a user`(){
		val company = Company(
				cnpj = "111111111",
				fullName = "Fantasy Company Name",
				users = listOf(User(
						name = "Test User",
						email = "test.user@email.com",
						password = "password",
						userType = UserType.COMPANY,
						roleGroup = null
				))
		)
		val companySaved = companyRepository.save(company)

		val companyFinded = companyRepository.getOne(companySaved.id!!)

		assert(company == companySaved)
		assert(company.users[0] == companySaved.users[0])
		assertNotNull(companySaved.users[0].id)
		assert(companyFinded.users[0] == companySaved.users[0])
	}

}
