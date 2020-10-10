package or.id.amcc.ui.visionMision

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import or.id.amcc.data.db.entities.History
import or.id.amcc.data.db.entities.VisionMision
import or.id.amcc.data.repositories.HistoryRepository
import or.id.amcc.data.repositories.VisionMisionRepository
import or.id.amcc.util.Coroutines

class VisionMisionViewModel(
    private val visionMisionRepository: VisionMisionRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _visionMision = MutableLiveData<List<VisionMision>>()
    val visionMision: LiveData<List<VisionMision>>
        get() = _visionMision

    fun getVisionMision() {
        job = Coroutines.ioThenMain(
            { visionMisionRepository.getVisionMision() },
            { _visionMision.value = it?.dataVisionMision!! }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}