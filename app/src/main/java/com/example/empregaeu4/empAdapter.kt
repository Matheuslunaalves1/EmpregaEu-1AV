package com.example.recifefit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.empregaeu4.UserModelo
import com.example.recifefitness.R

class empAdapter(empList: ArrayList<UserModelo>) {

    class empAdapter(private val empList: ArrayList<UserModelo>) :
        RecyclerView.Adapter<empAdapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.emp_list_item, parent, false)
            return ViewHolder(itemView)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val currentEmp = empList[position]
            holder.tvEmpName.text = currentEmp.empName
        }

        override fun getItemCount(): Int {
            return empList.size
        }


        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val tvEmpName : TextView = itemView.findViewById(R.id.tvEmpName)


        }
    }
}

