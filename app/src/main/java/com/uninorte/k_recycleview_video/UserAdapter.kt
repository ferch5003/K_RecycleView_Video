package com.uninorte.k_recycleview_video

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.uninorte.k_recycleview_video.data.User
import com.uninorte.k_recycleview_video.databinding.RowBinding

class UserAdapter(private val mValues: List<User>,
                  private val mListener: onListInteraction)
    : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserAdapter.ViewHolder {
        // val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent,false)
        // return ViewHolder(view)
        var binder: RowBinding
        binder = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row, parent, false)
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mView.user = item
        holder.mView.executePendingBindings()

        holder.mView.theLayout.setOnClickListener{
            mListener?.onListCardInteraction(item)
        }
    }

    fun updateData(){
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: RowBinding): RecyclerView.ViewHolder(mView.root){

    }

    interface onListInteraction{
        fun onListItemInteraction(item: User?)
        fun onListCardInteraction(item: User?)
    }

}