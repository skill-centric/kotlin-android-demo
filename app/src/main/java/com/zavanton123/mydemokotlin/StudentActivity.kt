package com.zavanton123.mydemokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.toast

class StudentActivity : AppCompatActivity(), StudentAdapter.StudentClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        val students = listOf("Mike", "Jack", "Jane")

        val studentRecyclerView = findViewById<RecyclerView>(R.id.student_recycler_view)
        studentRecyclerView.layoutManager = LinearLayoutManager(this)
        studentRecyclerView.adapter = StudentAdapter(this, students)
    }

    override fun onStudentClick(student: String) {

        toast("Clicked: $student")
    }
}
