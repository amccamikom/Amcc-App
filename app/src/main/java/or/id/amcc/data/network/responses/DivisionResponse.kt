package or.id.amcc.data.network.responses

import com.google.gson.annotations.SerializedName
import or.id.amcc.data.db.entities.Division

data class DivisionResponse(
    @SerializedName("data")
    val dataDivision: List<Division>
)