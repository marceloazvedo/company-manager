package br.com.marceloazevedo.companymanager.model

data class ApplicationModule(
        val id: Long,
        val name: String,
        val inMaintenance: Boolean,
        val resources: List<ResourceModule>
)