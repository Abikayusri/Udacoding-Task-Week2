package binar.sinau.assignmentweek2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            val userLogin = tieUsername.text.toString()
            val passLogin = tiePassword.text.toString()

            if ((userLogin == "Abikayusri") && (passLogin == "Abika123")) {
                intent.putExtra(HomeActivity.EXTRA_NAME,userLogin)
                startActivity(intent)
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_LONG).show()
            } else if ((userLogin.isEmpty()) || (passLogin.isEmpty())){
                Toast.makeText(this, "Data tidak boleh kosong!", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Username atau Password kamu salah", Toast.LENGTH_LONG).show()
            }
        }
    }
}
