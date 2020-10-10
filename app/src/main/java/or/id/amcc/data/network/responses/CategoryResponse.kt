package or.id.amcc.data.network.responses

import com.google.gson.annotations.SerializedName
import or.id.amcc.data.db.entities.Category
import or.id.amcc.data.db.entities.Division

data class CategoryResponse(
    @SerializedName("data")
    val dataCategory: List<Category>
)