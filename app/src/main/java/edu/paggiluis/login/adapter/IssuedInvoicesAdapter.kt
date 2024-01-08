package edu.paggiluis.login.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import edu.paggiluis.login.databinding.ModuleIssuedInvoiceBinding
import edu.paggiluis.login.domain.model.module.IssuedInvoice
import edu.paggiluis.login.domain.model.module.Module
import java.time.format.DateTimeFormatter

class IssuedInvoicesAdapter(supportFragmentManager: FragmentManager) : ModulesAdapter(supportFragmentManager) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulesViewHolder {
        return IssuedInvoiceViewHolder(
            ModuleIssuedInvoiceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).root)
    }

    inner class IssuedInvoiceViewHolder(view: View): ModulesViewHolder(view) {
        private val binding = ModuleIssuedInvoiceBinding.bind(view)

        override fun bind(module: Module) {
            val issuedInvoice = module as? IssuedInvoice
            issuedInvoice?.let {
                binding.txtId.text = it.id.toString()
                binding.txtDate.text = it.invoiceDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                binding.txtClientName.text = it.name
                binding.txtDescription.text = it.concept
                binding.txtPrice.text = String.format("%.2f €", it.getTotal())
            }
            binding.root.setOnClickListener{

            }
        }
    }
}