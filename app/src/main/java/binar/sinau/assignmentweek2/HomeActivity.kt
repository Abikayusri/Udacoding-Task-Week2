package binar.sinau.assignmentweek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
//        const val EXTRA_PASSWORD = "extra_password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val parsUser = intent.getStringExtra(EXTRA_NAME)
//        val parsPassword = intent.getStringExtra(EXTRA_PASSWORD)

        tvUserHome.text = "Selamat Datang ${parsUser}"

        btnRecycler.setOnClickListener {
            startActivity(Intent(this@HomeActivity, RecyclerViewActivity::class.java))
        }

        btnKalkulator.setOnClickListener {
            startActivity(Intent(this@HomeActivity, KalkulatorActivity::class.java))
        }
    }
}
