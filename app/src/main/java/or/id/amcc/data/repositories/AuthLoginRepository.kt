package or.id.amcc.data.repositories

import or.id.amcc.data.db.AppDatabase
import or.id.amcc.data.db.entities.User
import or.id.amcc.data.network.MyApi
import or.id.amcc.data.network.SafeApiRequest
import or.id.amcc.data.network.responses.UserLoginResponse
import retrofit2.Response

class AuthLoginRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(nim: String, password: String): UserLoginResponse {
        return apiRequest { api.userLogin(nim, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getUser()
}