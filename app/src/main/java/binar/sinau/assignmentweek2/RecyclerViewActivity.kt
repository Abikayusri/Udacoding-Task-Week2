package binar.sinau.assignmentweek2

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import binar.sinau.assignmentweek2.adapter.BuahAdapter
import binar.sinau.assignmentweek2.model.Buah
import kotlinx.android.synthetic.main.detail_list_item.*

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvBuah: RecyclerView
    private var listBuah = ArrayList<Buah>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        rvBuah = findViewById(R.id.rvRecycler)
        rvBuah.setHasFixedSize(true)

        listBuah.add(Buah("Anggur", R.drawable.anggur, getString(R.string.anggur)))
        listBuah.add(Buah("Apel", R.drawable.apel, getString(R.string.anggur)))
        listBuah.add(Buah("Brokoli", R.drawable.brokoli, getString(R.string.brokoli)))
        listBuah.add(Buah("Jeruk", R.drawable.jeruk, getString(R.string.jeruk)))
        listBuah.add(Buah("Nanas", R.drawable.nanas, getString(R.string.nanas)))
        listBuah.add(Buah("Semangka", R.drawable.semangka, getString(R.string.semangka)))
        listBuah.add(Buah("Timun", R.drawable.timun, getString(R.string.timun)))
        listBuah.add(Buah("Tomat", R.drawable.tomat, getString(R.string.tomat)))
        listBuah.add(Buah("Wortel", R.drawable.wortel, getString(R.string.wortel)))

        rvBuah.layoutManager = LinearLayoutManager(this)
        val listBuahAdapter = BuahAdapter(listBuah)
        rvBuah.adapter = listBuahAdapter

        listBuahAdapter.setOnItemClickCallback(object : BuahAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Buah) {
                Toast.makeText(
                    this@RecyclerViewActivity,
                    "Kamu memilih ${data.nama}",
                    Toast.LENGTH_SHORT
                ).show()

                Dialog(this@RecyclerViewActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_list_item)

                    val dImage = this.findViewById<ImageView>(R.id.ivImageDetail)
                    val dNama = this.findViewById<TextView>(R.id.tvNamaDetail)
                    val dDesc = this.findViewById<TextView>(R.id.tvDescDetail)

                    dImage.setImageResource(
                        data.foto ?: 0
                    )
                    dNama.text = data.nama
                    dDesc.text = data.deskripsi

                    btnClose.setOnClickListener {
                        this.dismiss()
                    }
                }.show()
            }
        })
    }
}
