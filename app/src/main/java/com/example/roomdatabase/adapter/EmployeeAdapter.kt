package com.example.roomdatabase.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.R
import com.example.roomdatabase.model.EmployeeModel
import kotlinx.android.synthetic.main.item_layout.view.*

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {
    var deleteEmpl = MutableLiveData<EmployeeModel>()

    var listEmployee = emptyList<EmployeeModel>()
    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onViewAttachedToWindow(holder: EmployeeViewHolder) {
        holder.itemView.btn_delete.setOnClickListener {
            deleteEmpl.value = listEmployee[holder.adapterPosition]
        }

    }

    override fun onViewDetachedFromWindow(holder: EmployeeViewHolder) {
        holder.itemView.btn_delete.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.itemView.fioTV.text = listEmployee[position].fio
        holder.itemView.postTV.text = listEmployee[position].post
        holder.itemView.salaryTV.text = (listEmployee[position].salary).toString()

    }

    override fun getItemCount(): Int {
        return listEmployee.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list : List<EmployeeModel>) {
        listEmployee = list
        notifyDataSetChanged()
    }

}