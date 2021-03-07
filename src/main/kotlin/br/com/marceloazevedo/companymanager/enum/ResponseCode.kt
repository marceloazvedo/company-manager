package br.com.marceloazevedo.companymanager.enum

enum class ResponseCode(val code: String, val message: String) {

    SUCCESS("00", "success"),
    VALIDATION_ERROR("00", "error.validation");

}