package edu.paggiluis.login.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import edu.paggiluis.login.databinding.ModuleReceivedInvoiceBinding
import edu.paggiluis.login.domain.model.module.Module
import edu.paggiluis.login.domain.model.module.ReceivedInvoice
import java.time.format.DateTimeFormatter

class ReceivedInvoicesAdapter(supportFragmentManager: FragmentManager) : ModulesAdapter(supportFragmentManager) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulesViewHolder {
        return IssuedInvoiceViewHolder(
            ModuleReceivedInvoiceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ).root)
    }

    inner class IssuedInvoiceViewHolder(view: View): ModulesViewHolder(view) {
        private val binding = ModuleReceivedInvoiceBinding.bind(view)

        override fun bind(module: Module) {
            val issuedInvoice = module as? ReceivedInvoice
            issuedInvoice?.let {
                binding.txtInvoiceNumber.text = it.id.toString()
                binding.txtDate.text = it.invoiceDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                binding.txtSupplier.text = it.supplier.name
                binding.txtPrice.text = String.format("%.2f €", it.base)
            }
            binding.root.setOnClickListener{

            }
        }
    }
}