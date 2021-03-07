package br.com.marceloazevedo.companymanager.model

import br.com.marceloazevedo.companymanager.enum.UserType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class RoleGroup (
        @Id @GeneratedValue
        val id: Long? = null,
        var name: String,
        var description: String,
        @Enumerated(EnumType.STRING)
        val userType: UserType,
        @CreatedDate var createAt: LocalDateTime = LocalDateTime.now(),
        @LastModifiedDate var updateAt: LocalDateTime? = null,
)