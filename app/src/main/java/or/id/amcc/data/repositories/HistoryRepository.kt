package or.id.amcc.data.repositories

import or.id.amcc.data.network.MyApi
import or.id.amcc.data.network.SafeApiRequest

class HistoryRepository(
    private val api: MyApi
) : SafeApiRequest() {

    suspend fun getHistory() = apiRequest { api.getHistory() }
}