package or.id.amcc.data.repositories

import or.id.amcc.data.network.MyApi
import or.id.amcc.data.network.SafeApiRequest

class DivisionRepository(
    private val api: MyApi
) : SafeApiRequest() {

    suspend fun getDivision() = apiRequest { api.getDivision() }
}