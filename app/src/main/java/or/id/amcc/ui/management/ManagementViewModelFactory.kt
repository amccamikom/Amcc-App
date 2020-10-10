package or.id.amcc.ui.management

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import or.id.amcc.data.repositories.HistoryRepository
import or.id.amcc.data.repositories.ManagementRepository
import or.id.amcc.data.repositories.VisionMisionRepository

@Suppress("UNCHECKED_CAST")
class ManagementViewModelFactory(
    private val managementRepository: ManagementRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ManagementViewModel(managementRepository) as T
    }
}