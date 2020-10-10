package or.id.amcc.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import or.id.amcc.data.db.entities.History
import or.id.amcc.data.repositories.HistoryRepository
import or.id.amcc.util.Coroutines

class HistoryViewModel(
    private val historyRepository: HistoryRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _history = MutableLiveData<History>()
    val history: LiveData<History>
        get() = _history

    fun getHistory() {
        job = Coroutines.ioThenMain(
            { historyRepository.getHistory() },
            { _history.value = it?.dataHistory!! }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}

//class ArticleViewModel(
//    private val repository: ArticleRepository
//) : ViewModel() {
//
//    private lateinit var job: Job
//
//    private val _article = MutableLiveData<List<Article>>()
//    val article: LiveData<List<Article>>
//        get() = _article
//
//    fun getArticle() {
//        job = Coroutines.ioThenMain(
//            { repository.getArticle() },
//            { _article.value = it!!.data }
//        )
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        if (::job.isInitialized) job.cancel()
//    }
//}