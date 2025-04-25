package vn.luongvo.kmp.ecommerce.presentation.screens.product

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import vn.luongvo.kmp.ecommerce.data.api.getProduct
import vn.luongvo.kmp.ecommerce.presentation.models.ProductModel
import vn.luongvo.kmp.ecommerce.presentation.models.toModel

data class ProductState(
    val isLoading: Boolean,
    val product: ProductModel? = null,
    val error: String? = null,
)

class ProductViewModel {

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        runBlocking {
            _stateFlow.emit(
                ProductState(
                    isLoading = false,
                    error = throwable.message.orEmpty()
                )
            )
        }
    }

    private val _stateFlow = MutableStateFlow(ProductState(isLoading = true))
    val stateFlow: StateFlow<ProductState> = _stateFlow.asStateFlow()

    fun loadProduct(productId: String) = viewModelScope.launch(exceptionHandler) {
        val response = getProduct(productId)
        _stateFlow.emit(
            ProductState(
                isLoading = false,
                product = response.toModel()
            )
        )
    }
}
