package or.id.amcc.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import or.id.amcc.data.repositories.AuthLoginRepository

@Suppress("UNCHECKED_CAST")
class AuthLoginViewModelFactory(
    private val repository: AuthLoginRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthLoginViewModel(repository) as T
    }
}