package or.id.amcc.data.network.responses

import com.google.gson.annotations.SerializedName
import or.id.amcc.data.db.entities.History
import or.id.amcc.data.db.entities.VisionMision

data class VisionMisionResponse(
    @SerializedName("data")
    val dataVisionMision: List<VisionMision>
)