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

class FacturAppDataSource {
    private val retrofit2Api = Retrofit2Api.getRetrofit()

    suspend fun login(request: LoginRequest): Response<Login> {
        return retrofit2Api.login(request)
    }

    fun getUserByUsername(token: String, username: String) : UserAccount {
        return retrofit2Api.getUserByUsername("Bearer $token", username)
    }

    suspend fun getAllClients(token: String): Response<List<Client>>{
        return retrofit2Api.getAllClients("Bearer $token")
    }

    suspend fun getActiveClients(token: String): Response<List<Client>> {
        return retrofit2Api.getActiveClients("Bearer $token")
    }

    suspend fun getAllBudgets(token: String): Response<List<Budget>> {
        return retrofit2Api.getAllBudgets("Bearer $token")
    }

    suspend fun getAllInvoices(token: String): Response<List<IssuedInvoice>> {
        return retrofit2Api.getAllIssuedInvoices("Bearer $token")
    }

    suspend fun getAllSuppliers(token: String): Response<List<Supplier>> {
        return retrofit2Api.getAllSuppliers("Bearer $token")
    }

    suspend fun getAllReceivedInvoices(token: String): Response<List<ReceivedInvoice>> {
        return retrofit2Api.getAllReceivedInvoices("Bearer $token")
    }
}