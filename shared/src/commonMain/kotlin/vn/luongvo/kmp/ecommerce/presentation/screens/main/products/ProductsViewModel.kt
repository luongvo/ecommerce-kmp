package vn.luongvo.kmp.ecommerce.presentation.screens.main.products

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import vn.luongvo.kmp.ecommerce.data.api.getProducts
import vn.luongvo.kmp.ecommerce.presentation.models.ProductModel
import vn.luongvo.kmp.ecommerce.presentation.models.toModel

data class ProductsState(
    val isLoading: Boolean,
    val products: List<ProductModel> = emptyList(),
    val error: String? = null,
)

class ProductsViewModel {

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        runBlocking {
            _stateFlow.emit(
                ProductsState(
                    isLoading = false,
                    error = throwable.message.orEmpty()
                )
            )
        }
    }

    private val _stateFlow = MutableStateFlow(ProductsState(isLoading = true))
    val stateFlow: StateFlow<ProductsState> = _stateFlow.asStateFlow()

    fun loadProducts() = viewModelScope.launch(exceptionHandler) {
        val response = getProducts()
        _stateFlow.emit(
            ProductsState(
                isLoading = false,
                products = response.map { it.toModel() }
            )
        )
    }
}
