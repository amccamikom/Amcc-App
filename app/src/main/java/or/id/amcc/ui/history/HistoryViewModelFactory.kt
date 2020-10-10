package or.id.amcc.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import or.id.amcc.data.repositories.HistoryRepository

@Suppress("UNCHECKED_CAST")
class HistoryViewModelFactory(
    private val historyRepository: HistoryRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HistoryViewModel(historyRepository) as T
    }
}