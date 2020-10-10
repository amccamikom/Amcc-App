package or.id.amcc.ui.division

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_division.*
import or.id.amcc.R
import or.id.amcc.databinding.ActivityDivisionBinding
import org.kodein.di.android.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class DivisionActivity : AppCompatActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: DivisionViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDivisionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_division)
        val viewModel = ViewModelProvider(this, factory).get(DivisionViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.getDivision()

        viewModel.division.observe(this, Observer { division ->
            try {
                tv_division_name.text = division[0].name
            } catch (e: Exception) {

            }
        })
    }
}