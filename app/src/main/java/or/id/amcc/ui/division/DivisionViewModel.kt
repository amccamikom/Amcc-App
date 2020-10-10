package or.id.amcc.ui.division

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import or.id.amcc.data.db.entities.Division
import or.id.amcc.data.db.entities.History
import or.id.amcc.data.db.entities.Management
import or.id.amcc.data.db.entities.VisionMision
import or.id.amcc.data.repositories.DivisionRepository
import or.id.amcc.data.repositories.HistoryRepository
import or.id.amcc.data.repositories.ManagementRepository
import or.id.amcc.data.repositories.VisionMisionRepository
import or.id.amcc.util.Coroutines

class DivisionViewModel(
    private val divisionRepository: DivisionRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _division = MutableLiveData<List<Division>>()
    val division: LiveData<List<Division>>
        get() = _division

    fun getDivision() {
        job = Coroutines.ioThenMain(
            { divisionRepository.getDivision() },
            { _division.value = it?.dataDivision!! }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}
