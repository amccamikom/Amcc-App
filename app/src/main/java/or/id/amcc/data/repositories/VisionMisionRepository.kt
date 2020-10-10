package or.id.amcc.data.repositories

import or.id.amcc.data.network.MyApi
import or.id.amcc.data.network.SafeApiRequest

class VisionMisionRepository(
    private val api: MyApi
) : SafeApiRequest() {

    suspend fun getVisionMision() = apiRequest { api.getVisionMision() }
}