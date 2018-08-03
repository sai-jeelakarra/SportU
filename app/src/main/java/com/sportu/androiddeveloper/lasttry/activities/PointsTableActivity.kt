package com.sportu.androiddeveloper.lasttry.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.ProgressBar
import com.google.firebase.database.*
import com.sportu.androiddeveloper.lasttry.R
import com.sportu.androiddeveloper.lasttry.adapters.PointsTableAdapter
import com.sportu.androiddeveloper.lasttry.ui.PointsTable

class PointsTableActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference
    lateinit var employeeList:MutableList<PointsTable>
    lateinit var listview: ListView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_points_table)


        employeeList = mutableListOf()
        listview = findViewById(R.id.listview1)
        val loader : ProgressBar = findViewById(R.id.loader)

        listview.emptyView = loader

        ref = FirebaseDatabase.getInstance().getReference("Pointstable")

        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
            }

            override fun onDataChange(p0: DataSnapshot?) {
                if (p0!!.exists()){
                    employeeList.clear()
                    for (e in p0.children){
                        val employee = e.getValue(PointsTable::class.java)
                        employeeList.add(employee!!)
                    }
                    val adapter = PointsTableAdapter(this@PointsTableActivity,R.layout.points_table,employeeList)
                    listview.adapter = adapter
                    adapter.notifyDataSetChanged()
                }
            }

        })



    }
}
