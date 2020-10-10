package or.id.amcc.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_USER_ID = 0

@Entity
data class User(
        @SerializedName("access_token")
        val accessToken: String?,
        @SerializedName("division")
        val division: String?,
        @SerializedName("email")
        val email: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("nim")
        val nim: String?,
        @SerializedName("phone")
        val phone: String?,
        @SerializedName("photo")
        val photo: String?,
        @SerializedName("since")
        val since: String?,
        @SerializedName("year")
        val year: String?
) {
    @PrimaryKey(autoGenerate = false)
    var uid:  Int? = CURRENT_USER_ID
}