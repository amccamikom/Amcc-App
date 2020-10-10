package or.id.amcc.ui.visionMision

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import or.id.amcc.data.repositories.HistoryRepository
import or.id.amcc.data.repositories.VisionMisionRepository

@Suppress("UNCHECKED_CAST")
class VisionMisionViewModelFactory(
    private val visionMisionRepository: VisionMisionRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VisionMisionViewModel(visionMisionRepository) as T
    }
}