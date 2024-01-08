package edu.paggiluis.login.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import edu.paggiluis.login.databinding.ModuleClientBinding
import edu.paggiluis.login.domain.model.module.Client
import edu.paggiluis.login.domain.model.module.Module
import edu.paggiluis.login.ui.dialog.ClientDialogFragment

class ClientsAdapter(supportFragmentManager: FragmentManager) : ModulesAdapter(supportFragmentManager) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulesViewHolder {
        return ClientViewHolder(ModuleClientBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).root)
    }

    inner class ClientViewHolder(view: View): ModulesViewHolder(view) {
        private val binding = ModuleClientBinding.bind(view)

        @SuppressLint("SetTextI18n")
        override fun bind(module: Module) {
            val client = module as? Client
            client?.let {
                binding.txtId.text = it.id.toString()
                binding.txtPhone.text = it.phone
                binding.txtName.text = "${it.name} ${it.lastName}"
                binding.txtAddress.text = it.address
            }
            binding.root.setOnClickListener {
                ClientDialogFragment().show(supportFragmentManager, "clientDialog")
            }
        }
    }

}