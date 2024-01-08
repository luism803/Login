package edu.paggiluis.login.data

import edu.paggiluis.login.domain.model.module.Budget
import edu.paggiluis.login.domain.model.module.Client
import edu.paggiluis.login.domain.model.Login
import edu.paggiluis.login.domain.model.LoginRequest
import edu.paggiluis.login.domain.model.UserAccount
import edu.paggiluis.login.domain.model.module.IssuedInvoice
import edu.paggiluis.login.domain.model.module.ReceivedInvoice
import edu.paggiluis.login.domain.model.module.Supplier
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

class Retrofit2Api {
    companion object {
        fun getRetrofit(): FacturAppApi {
            return Retrofit.Builder()
                .baseUrl("http://10.0.2.2:6969/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FacturAppApi::class.java)

        }
    }
}

interface FacturAppApi {
    @POST("auth/signin")
    suspend fun login(@Body request: LoginRequest): Response<Login>

    @GET("resource/users/{username}")
    fun getUserByUsername(@Header("Authorization") token: String, @Path("username") username: String): UserAccount

    //CLIENTS
    @GET("resource/clients")
    suspend fun getAllClients(@Header("Authorization") token: String): Response<List<Client>>

    @GET("resource/clients/active")
    suspend fun getActiveClients(@Header("Authorization") token: String): Response<List<Client>>

    //BUDGETS
    @GET("resource/budgets")
    suspend fun getAllBudgets(@Header("Authorization") token: String): Response<List<Budget>>

    //ISSUED INVOICES
    @GET("resource/issued-invoices")
    suspend fun getAllIssuedInvoices(@Header("Authorization") token: String): Response<List<IssuedInvoice>>

    //SUPPLIERS
    @GET("resource/suppliers")
    suspend fun getAllSuppliers(@Header("Authorization") token: String): Response<List<Supplier>>

    //RECEIVED INVOICES
    @GET("resource/received-invoices")
    suspend fun getAllReceivedInvoices(@Header("Authorization") token: String): Response<List<ReceivedInvoice>>
}