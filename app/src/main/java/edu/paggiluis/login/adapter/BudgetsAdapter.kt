package edu.paggiluis.login.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import edu.paggiluis.login.databinding.ModuleBudgetBinding
import edu.paggiluis.login.domain.model.module.Budget
import edu.paggiluis.login.domain.model.module.Module
import java.time.format.DateTimeFormatter

class BudgetsAdapter(supportFragmentManager: FragmentManager) : ModulesAdapter(supportFragmentManager) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulesViewHolder {
        return BudgetViewHolder(
            ModuleBudgetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).root)
    }

    inner class BudgetViewHolder(view: View): ModulesViewHolder(view) {
        private val binding = ModuleBudgetBinding.bind(view)

        @SuppressLint("SetTextI18n")
        override fun bind(module: Module) {
            val budget = module as? Budget
            budget?.let {
                binding.txtId.text = it.id.toString()
                binding.txtDate.text = it.budgetDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                binding.txtClientName.text = "${it.client.name} ${it.client.lastName ?: ""}"
                binding.txtDescription.text = it.description
                binding.txtPrice.text = String.format("%.2f €", it.cost)
            }
        }
    }
}