package or.id.amcc.ui.visionMision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import or.id.amcc.R
import or.id.amcc.databinding.ActivityVisionMisionBinding
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import java.lang.Exception

class VisionMisionActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: VisionMisionViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityVisionMisionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_vision_mision)
        val viewModel = ViewModelProvider(this, factory).get(VisionMisionViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.getVisionMision()
        viewModel.visionMision.observe(this, Observer { visionMision ->
            try {

            } catch (e: Exception) {
                Log.e("error getVisionMision: ", e.toString())
            }
        })
    }
}