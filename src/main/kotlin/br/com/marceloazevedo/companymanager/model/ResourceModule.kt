package br.com.marceloazevedo.companymanager.model

data class ResourceModule(
        val id: Long? = null,
        val name: String,
        val path: String,
        val allocatedVerbs: List<ResourceMethod>
)