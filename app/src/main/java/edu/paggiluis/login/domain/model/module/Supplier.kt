package edu.paggiluis.login.domain.model.module

import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Supplier(
    @SerializedName("id")
    val id: Int,

    @SerializedName("cif")
    val cif: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("address")
    val address: String
): Module {

    override fun areContentsTheSame(other: Module): Boolean {
        if (other !is Supplier) return false
        return  (id == other.id) &&
                (cif == other.cif) &&
                (name == other.name) &&
                (address == other.address)
    }
}