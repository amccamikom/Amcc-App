package or.id.amcc.data.network.responses

import com.google.gson.annotations.SerializedName
import or.id.amcc.data.db.entities.User

data class UserLoginResponse(
    @SerializedName("data")
    val dataUser: User?
)