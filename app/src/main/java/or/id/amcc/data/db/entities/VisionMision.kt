package or.id.amcc.data.db.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class VisionMision(
    @SerializedName("image")
    val image: String?,
    @SerializedName("post")
    val post: String?,
    @SerializedName("title")
    val title: String?
)