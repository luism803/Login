package edu.paggiluis.login.adapter

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import edu.paggiluis.login.domain.model.module.Module

abstract class ModulesAdapter(
    protected val supportFragmentManager: FragmentManager
) : ListAdapter<Module, ModulesAdapter.ModulesViewHolder>(ModulesDiffCallback()) {

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModulesViewHolder

    override fun onBindViewHolder(holder: ModulesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    abstract inner class ModulesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(module: Module)
    }
}

class ModulesDiffCallback : DiffUtil.ItemCallback<Module>() {
    override fun areItemsTheSame(oldItem: Module, newItem: Module): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Module, newItem: Module): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}