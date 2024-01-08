package edu.paggiluis.login.domain.model.module

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import edu.paggiluis.login.utils.LocalDateAdapter
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class ReceivedInvoice(
    @SerializedName("id")
    val id: Int,

    @JsonAdapter(LocalDateAdapter::class)
    @SerializedName("invoiceDate")
    val invoiceDate: LocalDate,

    @SerializedName("base")
    val base: Double,

    @SerializedName("iva")
    val iva: Double,

    @SerializedName("invoiceNumber")
    val invoiceNumber: Int,

    @SerializedName("supplier")
    val supplier: Supplier
): Module {

    override fun areContentsTheSame(other: Module): Boolean {
        if (other !is ReceivedInvoice) return false
        return  (id == other.id) &&
                (invoiceDate == other.invoiceDate) &&
                (base == other.base) &&
                (iva == other.iva) &&
                (invoiceNumber == other.invoiceNumber) &&
                (supplier == other.supplier)
    }
}