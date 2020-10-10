package or.id.amcc.ui.login

import android.view.View
import androidx.lifecycle.ViewModel
import or.id.amcc.AmccAmikomApplication.Companion.prefManager
import or.id.amcc.data.repositories.AuthLoginRepository
import or.id.amcc.util.ApiException
import or.id.amcc.util.Coroutines

class AuthLoginViewModel(
    private val authLoginRepository: AuthLoginRepository
) : ViewModel() {

    var nim: String? = null
    var password: String? = null

    var authListener: AuthLoginListener? = null

    fun getLoggedInUser() = authLoginRepository.getUser()

    fun onButtonLoginClicked(view: View) {
        authListener?.onStarted()

        if (nim.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Email atau password salah!")
            return
        }

        Coroutines.main {
            try {
                val authResponse = authLoginRepository.userLogin(nim!!, password!!)
                authResponse.dataUser?.let {
                    authListener?.onSuccess(it)
                    authLoginRepository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.dataUser?.name!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            }
        }
    }
}