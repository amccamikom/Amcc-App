package or.id.amcc.data.db.entities

import com.google.gson.annotations.SerializedName

data class Management(
    @SerializedName("image")
    val image: String?,
    @SerializedName("post")
    val post: String?,
    @SerializedName("title")
    val title: String?
)