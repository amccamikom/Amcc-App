package or.id.amcc

import android.app.Application
import or.id.amcc.data.db.AppDatabase
import or.id.amcc.data.network.MyApi
import or.id.amcc.data.network.NetworkConnectionInterceptor
import or.id.amcc.data.preferences.PrefManager
import or.id.amcc.data.repositories.*
import or.id.amcc.ui.division.DivisionViewModelFactory
import or.id.amcc.ui.history.HistoryViewModelFactory
import or.id.amcc.ui.login.AuthLoginViewModelFactory
import or.id.amcc.ui.management.ManagementViewModelFactory
import or.id.amcc.ui.visionMision.VisionMisionViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AmccAmikomApplication : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@AmccAmikomApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { PrefManager(instance()) }
        bind() from singleton { AuthLoginRepository(instance(), instance()) }
        bind() from singleton { HistoryRepository(instance()) }
        bind() from singleton { VisionMisionRepository(instance()) }
        bind() from singleton { ManagementRepository(instance()) }
        bind() from singleton { DivisionRepository(instance()) }

        bind() from provider { AuthLoginViewModelFactory(instance()) }
        bind() from provider { HistoryViewModelFactory(instance()) }
        bind() from provider { VisionMisionViewModelFactory(instance()) }
        bind() from provider { ManagementViewModelFactory(instance()) }
        bind() from provider { DivisionViewModelFactory(instance()) }

    }

    companion object {
        @get:Synchronized
        lateinit var instance: AmccAmikomApplication
        lateinit var prefManager: PrefManager
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        prefManager = PrefManager(this)
    }
}