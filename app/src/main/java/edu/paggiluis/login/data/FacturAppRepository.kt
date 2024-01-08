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

class FacturAppRepository(private val dataSource: FacturAppDataSource) {
    suspend fun login(request: LoginRequest): Response<Login>{
        return dataSource.login(request)
    }

    fun getUserByUsername(token: String, username: String) : UserAccount {
        return dataSource.getUserByUsername(token, username)
    }

    suspend fun getAllClients(token: String): Response<List<Client>>{
        return dataSource.getAllClients(token)
    }

    suspend fun getActiveClients(token: String): Response<List<Client>> {
        return dataSource.getActiveClients(token)
    }

    suspend fun getAllBudgets(token: String): Response<List<Budget>> {
        return dataSource.getAllBudgets(token)
    }

    suspend fun getAllIssuedInvoices(token: String): Response<List<IssuedInvoice>> {
        return dataSource.getAllInvoices(token)
    }

    suspend fun getAllSuppliers(token: String): Response<List<Supplier>> {
        return dataSource.getAllSuppliers(token)
    }

    suspend fun getAllReceivedInvoices(token: String): Response<List<ReceivedInvoice>> {
        return dataSource.getAllReceivedInvoices(token)
    }
}