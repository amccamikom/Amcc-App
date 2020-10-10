package or.id.amcc.data.repositories

import or.id.amcc.data.network.MyApi
import or.id.amcc.data.network.SafeApiRequest

class CategoryRepository(
    private val api: MyApi
) : SafeApiRequest() {

    suspend fun getCategory() = apiRequest { api.getCategory() }
}