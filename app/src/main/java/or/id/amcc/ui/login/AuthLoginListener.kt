package or.id.amcc.ui.login

import or.id.amcc.data.db.entities.User

interface AuthLoginListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}