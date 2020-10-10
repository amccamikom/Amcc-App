package or.id.amcc.ui.division

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import or.id.amcc.data.repositories.DivisionRepository
import or.id.amcc.data.repositories.HistoryRepository
import or.id.amcc.data.repositories.ManagementRepository
import or.id.amcc.data.repositories.VisionMisionRepository

@Suppress("UNCHECKED_CAST")
class DivisionViewModelFactory(
    private val divisionRepository: DivisionRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DivisionViewModel(divisionRepository) as T
    }
}