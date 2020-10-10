package or.id.amcc.data.network.responses

import com.google.gson.annotations.SerializedName
import or.id.amcc.data.db.entities.History

data class HistoryResponse(
    @SerializedName("data")
    val dataHistory: History?
)