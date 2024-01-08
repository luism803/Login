package edu.paggiluis.login.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import edu.paggiluis.login.databinding.ModuleSupplierBinding
import edu.paggiluis.login.domain.model.module.Module
import edu.paggiluis.login.domain.model.module.Supplier

class SuppliersAdapter(supportFragmentManager: FragmentManager) : ModulesAdapter(supportFragmentManager) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulesViewHolder {
        return SupplierViewHolder(
            ModuleSupplierBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).root)
    }

    inner class SupplierViewHolder(view: View): ModulesViewHolder(view) {
        private val binding = ModuleSupplierBinding.bind(view)

        override fun bind(module: Module) {
            val supplier = module as? Supplier
            supplier?.let {
                binding.txtId.text = it.id.toString()
                binding.txtCif.text = it.cif
                binding.txtName.text = it.name
            }
        }
    }
}