package binar.sinau.assignmentweek2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import binar.sinau.assignmentweek2.R
import binar.sinau.assignmentweek2.model.Buah

/**
 * Created by Abika Chairul Yusri
 * on Saturday, 16 May 2020
 * Bismillahirrahmanirrahim
 */

class BuahAdapter(private val listData: ArrayList<Buah>) :
    RecyclerView.Adapter<BuahAdapter.ListViewHolder>() {

    private lateinit var onItemCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listData.size ?: 0

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listData[position]

        holder.imgPhoto.setImageResource(item.foto)
        holder.tvNama.text = item.nama
        holder.tvDesc.text = item.deskripsi

        holder.itemView.setOnClickListener {
            onItemCallback.onItemClicked(listData[holder.adapterPosition])
        }

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto = itemView.findViewById<ImageView>(R.id.ivImageList)
        var tvNama = itemView.findViewById<TextView>(R.id.tvNamaList)
        var tvDesc = itemView.findViewById<TextView>(R.id.tvDescList)
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Buah)
    }
}


//class BuahAdapter(
//    private val context: Context,
//    private val data: ArrayList<Buah>,
//    private val itemClick: OnItemClickCallback
//) : RecyclerView.Adapter<BuahAdapter.ListViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
//
//        return ListViewHolder(view)
//    }
//
//    override fun getItemCount(): Int = data.size ?: 0
//
//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val item = data[position]
//        holder.imgPhoto.setImageResource(item.foto ?: 0)
//        holder.tvNama.text = item.nama
//        holder.tvDesc.text = item.deskripsi
//
//        holder.itemView.setOnClickListener {
//            itemClick.onItemClicked(item)
////            Toast.makeText(context, "Kamu memilih " + data[holder.adapterPosition],Toast.LENGTH_LONG).show()
//        }
//    }
//
//    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var imgPhoto = itemView.findViewById<ImageView>(R.id.ivImageList)
//        var tvNama = itemView.findViewById<TextView>(R.id.tvNamaList)
//        var tvDesc = itemView.findViewById<TextView>(R.id.tvDescList)
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(item: Buah?)
//    }
//}