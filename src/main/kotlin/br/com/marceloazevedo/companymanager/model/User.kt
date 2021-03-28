package br.com.marceloazevedo.companymanager.model

import br.com.marceloazevedo.companymanager.enum.UserType
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        @Column(unique = true, nullable = false)
        val email: String,
        val password: String,
        @Enumerated(EnumType.STRING)
        val userType: UserType,
        @ManyToOne
        val roleGroup: RoleGroup?,
        var status: Boolean = true,
        @CreatedDate var createAt: LocalDateTime = LocalDateTime.now(),
        @LastModifiedDate var updateAt: LocalDateTime? = null,
)