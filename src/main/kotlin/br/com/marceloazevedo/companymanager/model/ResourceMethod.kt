package br.com.marceloazevedo.companymanager.model

import org.springframework.http.HttpMethod

data class ResourceMethod(
        val id: Long,
        var method: HttpMethod,
        val path: String,
        val allocatedMethods: List<HttpMethod>
)