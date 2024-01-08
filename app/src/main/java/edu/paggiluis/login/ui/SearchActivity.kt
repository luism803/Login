package edu.paggiluis.login.ui

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import edu.paggiluis.login.R
import edu.paggiluis.login.SharedApp
import edu.paggiluis.login.databinding.ActivitySearchBinding
import edu.paggiluis.login.domain.model.module.Module
import edu.paggiluis.login.ui.strategy.SearchStrategyImpl
import edu.paggiluis.login.ui.strategy.SearchStrategyManager
import edu.paggiluis.login.ui.strategy.SearchType
import kotlinx.coroutines.launch

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var strategy: SearchStrategyImpl

    private val moduleList: MutableList<Module> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION") val searchType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            intent.getParcelableExtra("search_type", SearchType::class.java)
        else intent.getParcelableExtra("search_type")

        if (searchType == null) {
            throw IllegalArgumentException("Search type is required")
        }

        try {
            strategy = SearchStrategyManager.strategies.getValue(searchType)
        } catch (e: NoSuchElementException) {
            throw IllegalArgumentException("Search type not supported")
        }

        binding.btnNew.text = strategy.getNewModuleText(this::getString)
        binding.svSearch.queryHint = getString(R.string.txt_search_module, strategy.getModuleName(this::getString))

        binding.recyclerView.hideKeyboardOnTouch()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.recyclerView.adapter = strategy.getAdapter()

        loadModules()
    }

    private fun View.hideKeyboardOnTouch() {
        setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                v.performClick()
            }
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(v.windowToken, 0)
            false
        }
    }

    private fun loadModules() {
        lifecycleScope.launch {
            try {
                val token = SharedApp.preferences.token
                val response = strategy.getResponse(token)
                if (response.isSuccessful) {
                    response.body()?.let { modules ->
                        moduleList.clear()
                        moduleList.addAll(modules)
                        strategy.getAdapter().submitList(moduleList.toList())
                    }
                } else {
                    if(response.code() == 403){
                        TODO("EXPIRED TOKEN")
                    }
                    Log.e("SearchActivity", "Request failed with status code: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("SearchActivity", e.message.toString())
            }
        }
    }
}
