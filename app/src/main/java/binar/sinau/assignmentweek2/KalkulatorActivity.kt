package binar.sinau.assignmentweek2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_kalkulator.*

class KalkulatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        val nAwal = etAwalKakulator.text
        val nAkhir = etAkhirKakulator.text

        btnTambah.setOnClickListener {
            validation(nAwal.toString(), nAkhir.toString(), "+")
        }

        btnKurang.setOnClickListener {
            validation(nAwal.toString(), nAkhir.toString(), "-")
        }

        btnBagi.setOnClickListener {
            validation(nAwal.toString(), nAkhir.toString(), "/")
        }

        btnKali.setOnClickListener {
            validation(nAwal.toString(), nAkhir.toString(), "*")
        }
    }

    fun validation(awal: String, akhir: String, operator: String) {
        if (awal.isEmpty() || akhir.isEmpty()) {
            Snackbar.make(findViewById(R.id.llKalkulator), "Data tidak boleh kosong", Snackbar.LENGTH_SHORT).show()
        } else {
            kalkulasi(awal.toDouble(), akhir.toDouble(), operator)
        }
    }

    fun kalkulasi(awal: Double, akhir: Double, operator: String) {
        var hasil: Double? = null

        when (operator) {
            "+" -> hasil = awal + akhir
            "-" -> hasil = awal - akhir
            "*" -> hasil = awal * akhir
            "/" -> hasil = awal / akhir
        }
        tvHasil.text = "Hasil: ${hasil.toString()}"
    }
}
