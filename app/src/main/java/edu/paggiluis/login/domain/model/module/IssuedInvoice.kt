package edu.paggiluis.login.domain.model.module

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import edu.paggiluis.login.utils.LocalDateAdapter
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class IssuedInvoice(
    @SerializedName("id")
    val id: Int,

    @JsonAdapter(LocalDateAdapter::class)
    @SerializedName("invoiceDate")
    val invoiceDate: LocalDate,

    @SerializedName("concept")
    val concept: String,

    @SerializedName("base")
    val base: Double,

    @SerializedName("discount")
    val discount: Double,

    @SerializedName("iva")
    val iva: Double,

    @SerializedName("clientId")
    val clientId: Int,

    @SerializedName("nif")
    val nif: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("address")
    val address: String
): Module {

    override fun areContentsTheSame(other: Module): Boolean {
        if (other !is IssuedInvoice) return false
        return  (id == other.id) &&
                (invoiceDate == other.invoiceDate) &&
                (concept == other.concept) &&
                (base == other.base) &&
                (discount == other.discount) &&
                (iva == other.iva) &&
                (clientId == other.clientId) &&
                (nif == other.nif) &&
                (name == other.name) &&
                (address == other.address)
    }

    fun getTotal(): Double{
        return base * (1 + iva/100)
    }
}