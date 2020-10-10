package or.id.amcc.ui.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_history.*
import or.id.amcc.R
import or.id.amcc.databinding.ActivityHistoryBinding
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import java.lang.Exception

class HistoryActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: HistoryViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityHistoryBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_history)
        val viewModel = ViewModelProvider(this, factory).get(HistoryViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.getHistory()
        viewModel.history.observe(this, Observer { history ->
            try {
                tv_title_history.text = history.title
            } catch (e: Exception) {
                Log.e("error getHistory: ", e.toString())
            }
        })
    }
}