package vn.luongvo.kmp.ecommerce.android.main.menu

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import vn.luongvo.kmp.ecommerce.data.api.getPhotos
import vn.luongvo.kmp.ecommerce.data.model.MenuResponse

data class MenuState(
    val isLoading: Boolean,
    val menus: List<MenuResponse> = emptyList(),
    val error: String? = null,
)

class MenuViewModel {

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        runBlocking {
            _stateFlow.emit(
                MenuState(
                    isLoading = false,
                    error = throwable.message.orEmpty()
                )
            )
        }
    }

    private val _stateFlow = MutableStateFlow(MenuState(isLoading = true))
    val stateFlow: StateFlow<MenuState> = _stateFlow.asStateFlow()

    fun loadMenus() = viewModelScope.launch(exceptionHandler) {
        val response = getPhotos()
        _stateFlow.emit(
            MenuState(
                isLoading = false,
                menus = response
            )
        )
    }
}
