package or.id.amcc.ui.management

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import or.id.amcc.data.db.entities.History
import or.id.amcc.data.db.entities.Management
import or.id.amcc.data.db.entities.VisionMision
import or.id.amcc.data.repositories.HistoryRepository
import or.id.amcc.data.repositories.ManagementRepository
import or.id.amcc.data.repositories.VisionMisionRepository
import or.id.amcc.util.Coroutines

class ManagementViewModel(
    private val managementRepository: ManagementRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _management = MutableLiveData<List<Management>>()
    val management: LiveData<List<Management>>
        get() = _management

    fun getManagement() {
        job = Coroutines.ioThenMain(
            { managementRepository.getManagement() },
            { _management.value = it?.dataManagement!! }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}
