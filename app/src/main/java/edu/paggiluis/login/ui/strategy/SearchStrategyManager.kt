package edu.paggiluis.login.ui.strategy

object SearchStrategyManager {
    val strategies: Map<SearchType, SearchStrategyImpl> = mapOf(
        SearchType.CLIENTS to SearchStrategyImpl.CLIENTS,
        SearchType.BUDGETS to SearchStrategyImpl.BUDGETS,
        SearchType.ISSUED_INVOICES to SearchStrategyImpl.ISSUED_INVOICES,
        SearchType.SUPPLIERS to SearchStrategyImpl.SUPPLIERS,
        SearchType.RECEIVED_INVOICES to SearchStrategyImpl.RECEIVED_INVOICES
    )
}