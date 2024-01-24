package com.bitc.plumMarket.Adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.Fragment.BottomSheetFragment
import com.bitc.plumMarket.ViewHolder.ListSellViewHolder
import com.bitc.plumMarket.databinding.ListSellItemBinding


class ListSellAdapter(
  private val items: MutableList<ListData>,
  private val activity: AppCompatActivity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val binding = ListSellItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return ListSellViewHolder(binding)
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val bind = (holder as ListSellViewHolder).binding
    val idx = items[position].list_idx.toString()
    bind.tvListSellIdx.text = items[position].list_idx.toString()
    bind.tvListSellTitle.text = items[position].list_title
    bind.tvListSellMoney.text = "${items[position].list_money}원"

    bind.btnEtc.setOnClickListener {
      val bottomSheetFragment = BottomSheetFragment(idx)
      bottomSheetFragment.show(activity.supportFragmentManager, bottomSheetFragment.tag)
    }
  }
}






