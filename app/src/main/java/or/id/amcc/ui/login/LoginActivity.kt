package or.id.amcc.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import or.id.amcc.AmccAmikomApplication.Companion.prefManager
import or.id.amcc.R
import or.id.amcc.data.db.entities.User
import or.id.amcc.databinding.ActivityLoginBinding
import or.id.amcc.ui.main.MainActivity
import or.id.amcc.util.toast
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(), KodeinAware, AuthLoginListener {

    override val kodein by kodein()
    private val factory: AuthLoginViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val loginBinding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this, factory).get(AuthLoginViewModel::class.java)

        loginBinding.loginViewModel = viewModel
        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->
            if (!prefManager.spToken.isNullOrEmpty()) {
                Intent(this, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
        toast("Started login!")
    }

    override fun onSuccess(user: User) {
        prefManager.spToken = user.accessToken
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}