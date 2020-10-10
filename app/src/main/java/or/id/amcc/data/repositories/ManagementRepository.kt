package or.id.amcc.data.repositories

import or.id.amcc.data.network.MyApi
import or.id.amcc.data.network.SafeApiRequest

class ManagementRepository(
    private val api: MyApi
) : SafeApiRequest() {

    suspend fun getManagement() = apiRequest { api.getManagement() }
}