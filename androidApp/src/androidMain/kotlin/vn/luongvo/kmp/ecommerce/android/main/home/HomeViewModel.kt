package vn.luongvo.kmp.ecommerce.android.main.home

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import vn.luongvo.kmp.ecommerce.data.api.getPosts
import vn.luongvo.kmp.ecommerce.data.model.PostResponse

data class HomeState(
    val isLoading: Boolean,
    val posts: List<PostResponse> = emptyList(),
    val error: String? = null,
)

class HomeViewModel {

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        runBlocking {
            _stateFlow.emit(
                HomeState(
                    isLoading = false,
                    error = throwable.message.orEmpty()
                )
            )
        }
    }

    private val _stateFlow = MutableStateFlow(HomeState(isLoading = true))
    val stateFlow: StateFlow<HomeState> = _stateFlow.asStateFlow()

    fun loadPosts() = viewModelScope.launch(exceptionHandler) {
        val response = getPosts()
        _stateFlow.emit(
            HomeState(
                isLoading = false,
                posts = response
            )
        )
    }
}
