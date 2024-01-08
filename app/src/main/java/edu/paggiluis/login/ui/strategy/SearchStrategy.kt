package edu.paggiluis.login.ui.strategy

import edu.paggiluis.login.R
import edu.paggiluis.login.adapter.BudgetsAdapter
import edu.paggiluis.login.adapter.ClientsAdapter
import edu.paggiluis.login.adapter.IssuedInvoicesAdapter
import edu.paggiluis.login.adapter.ModulesAdapter
import edu.paggiluis.login.adapter.ReceivedInvoicesAdapter
import edu.paggiluis.login.adapter.SuppliersAdapter
import edu.paggiluis.login.data.FacturAppDataSource
import edu.paggiluis.login.data.FacturAppRepository
import edu.paggiluis.login.domain.model.module.Module
import retrofit2.Response

interface ISearchStrategy {
    fun getModuleName(getString: (Int, Array<out Any>) -> String): String
    fun getNewModuleText(getString: (Int, Array<out Any>) -> String): String
    fun getAdapter(): ModulesAdapter
    suspend fun getResponse(token: String): Response<List<Module>>
}

enum class SearchStrategyImpl : ISearchStrategy{
    CLIENTS {
        private val adapter = ClientsAdapter( )

        override fun getModuleName(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.name_client,
            arrayOf()
        )

        override fun getNewModuleText(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.txt_new_module_male,
            arrayOf(getModuleName(getString))
        )

        override fun getAdapter(): ClientsAdapter = adapter

        override suspend fun getResponse(token: String): Response<List<Module>> {
            val facturAppRepository = FacturAppRepository(FacturAppDataSource())
            @Suppress("UNCHECKED_CAST")
            return facturAppRepository.getActiveClients(token) as Response<List<Module>>
        }
    },

    BUDGETS {
        private val adapter = BudgetsAdapter( )

        override fun getModuleName(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.name_budget,
            arrayOf()
        )

        override fun getNewModuleText(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.txt_new_module_male,
            arrayOf(getModuleName(getString))
        )

        override fun getAdapter(): BudgetsAdapter = adapter

        override suspend fun getResponse(token: String): Response<List<Module>> {
            val facturAppRepository = FacturAppRepository(FacturAppDataSource())
            @Suppress("UNCHECKED_CAST")
            return facturAppRepository.getAllBudgets(token) as Response<List<Module>>
        }
    },

    ISSUED_INVOICES {
        private val adapter = IssuedInvoicesAdapter( )

        override fun getModuleName(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.name_issued_invoice,
            arrayOf()
        )

        override fun getNewModuleText(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.txt_new_module_female,
            arrayOf(getModuleName(getString))
        )

        override fun getAdapter() = adapter

        override suspend fun getResponse(token: String): Response<List<Module>> {
            val facturAppRepository = FacturAppRepository(FacturAppDataSource())
            @Suppress("UNCHECKED_CAST")
            return facturAppRepository.getAllIssuedInvoices(token) as Response<List<Module>>
        }
    },

    SUPPLIERS {
        private val adapter = SuppliersAdapter()

        override fun getModuleName(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.name_supplier,
            arrayOf()
        )

        override fun getNewModuleText(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.txt_new_module_male,
            arrayOf(getModuleName(getString))
        )

        override fun getAdapter() = adapter

        override suspend fun getResponse(token: String): Response<List<Module>> {
            val facturAppRepository = FacturAppRepository(FacturAppDataSource())
            @Suppress("UNCHECKED_CAST")
            return facturAppRepository.getAllSuppliers(token) as Response<List<Module>>
        }
    },

    RECEIVED_INVOICES {
        private val adapter = ReceivedInvoicesAdapter()

        override fun getModuleName(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.name_received_invoice,
            arrayOf()
        )

        override fun getNewModuleText(getString: (Int, Array<out Any>) -> String) = getString(
            R.string.txt_new_module_female,
            arrayOf(getModuleName(getString))
        )

        override fun getAdapter() = adapter

        override suspend fun getResponse(token: String): Response<List<Module>> {
            val facturAppRepository = FacturAppRepository(FacturAppDataSource())
            @Suppress("UNCHECKED_CAST")
            return facturAppRepository.getAllReceivedInvoices(token) as Response<List<Module>>
        }
    }
}