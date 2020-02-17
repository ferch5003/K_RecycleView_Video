package com.uninorte.k_recycleview_video

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uninorte.k_recycleview_video.data.User
import kotlinx.android.synthetic.main.row.view.*

class MyUserRecyclerViewAdapter(private val mValues: List<User>,
                                private val mListener: onListInteraction)
    : RecyclerView.Adapter<MyUserRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyUserRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: MyUserRecyclerViewAdapter.ViewHolder, position: Int) {
        val item = mValues[position]
        holder.textViewTitle.text = item.title
        holder.textViewFirst.text = item.first
        holder.textViewLast.text = item.last
        holder.textViewEmail.text = item.email
        holder.textViewPhone.text = item.phone


        holder.mView.setOnClickListener{
            mListener?.onListItemInteraction(item)
        }
    }

    public fun updateData(){
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View): RecyclerView.ViewHolder(mView){
        val textViewTitle: TextView = mView.textViewTitle
        val textViewFirst: TextView = mView.textViewFirst
        val textViewLast: TextView = mView.textViewLast
        val textViewEmail: TextView = mView.textViewEmail
        val textViewPhone: TextView = mView.textViewPhone
    }

    interface onListInteraction{
        fun onListItemInteraction(item: User?)
        fun onListButtonInteraction(item: User?)
    }

}