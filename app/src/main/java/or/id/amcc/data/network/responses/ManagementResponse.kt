package or.id.amcc.data.network.responses

import com.google.gson.annotations.SerializedName
import or.id.amcc.data.db.entities.History
import or.id.amcc.data.db.entities.Management

data class ManagementResponse(
    @SerializedName("data")
    val dataManagement: List<Management>?
)