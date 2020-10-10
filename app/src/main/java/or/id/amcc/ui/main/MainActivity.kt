package or.id.amcc.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import or.id.amcc.R
import or.id.amcc.ui.division.DivisionActivity
import or.id.amcc.ui.history.HistoryActivity
import or.id.amcc.ui.management.ManagementActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_history.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        tv_management_team.setOnClickListener {
            startActivity(Intent(this, ManagementActivity::class.java))
        }

        tv_divisions.setOnClickListener {
            startActivity(Intent(this, DivisionActivity::class.java))
        }
    }
}