package com.zavanton123.mydemokotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StudentAdapter(private val studentClickListener: StudentClickListener,
                     private val students: List<String>?)
    : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    interface StudentClickListener {

        fun onStudentClick(student: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_view_holder, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.bind(students?.get(position) ?: "not available")
    }

    override fun getItemCount(): Int {

        return students?.size ?: 0
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        val studentTextView: TextView = view.findViewById(R.id.student_text_view)
        lateinit var student: String

        init {
            view.setOnClickListener(this)
        }

        fun bind(student: String) {

            this.student = student
            studentTextView.text = student
        }

        override fun onClick(view: View){

            studentClickListener.onStudentClick(student)
        }
    }

}