package edu.paggiluis.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import edu.paggiluis.login.databinding.ActivityMainBinding
import edu.paggiluis.login.ui.strategy.SearchType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClients.setOnClickListener{
            startSearchActivity(SearchType.CLIENTS)
        }

        binding.btnBudgets.setOnClickListener{
            startSearchActivity(SearchType.BUDGETS)
        }

        binding.btnIssuedInvoices.setOnClickListener{
            startSearchActivity(SearchType.ISSUED_INVOICES)
        }

        binding.btnSuppliers.setOnClickListener{
            startSearchActivity(SearchType.SUPPLIERS)
        }

        binding.btnReceivedInvoices.setOnClickListener{
            startSearchActivity(SearchType.RECEIVED_INVOICES)
        }
    }

    private fun startSearchActivity(searchType: SearchType) {
        Intent(this, SearchActivity::class.java).apply {
            putExtra("search_type", searchType as Parcelable)
            startActivity(this)
        }
    }
}