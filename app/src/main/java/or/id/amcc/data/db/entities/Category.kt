package or.id.amcc.data.db.entities

import com.google.gson.annotations.SerializedName


data class Category(
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("updated_at")
    val updatedAt: String?
)
