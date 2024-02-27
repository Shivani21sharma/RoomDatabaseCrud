package com.shivani.roomdatabasecrud

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import com.shivani.roomdatabasecrud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var baseAdapter: BaseAdapter
    var arrayList= arrayListOf<String>("Title")
    var description= arrayListOf<String>("description")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // baseAdapter=BaseAdapterClass()
        binding.listView.adapter=baseAdapter
        binding.fabBtn.setOnClickListener {
            val dialog=Dialog(this)
            dialog.setContentView(R.id.btn_Update)
            val etUpdate = dialog.findViewById<EditText>(R.id.etUpdate)
            val btnUpdate = dialog.findViewById<Button>(R.id.btn_Update)
            val datePicker = dialog.findViewById<DatePicker>(R.id.etUpdate)
            btnUpdate.setOnClickListener {
                if (etUpdate.text.toString().isEmpty()) {
                    etUpdate.error = "Enter Text"
                    return@setOnClickListener
                }
                val day = datePicker.dayOfMonth
                val month = datePicker.month
                val year = datePicker.year
                if (day == 0 || month == 0 || year == 0) {
                    Toast.makeText(this, "Pick Date ", Toast.LENGTH_SHORT).show()
                } else {
                    baseAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
            dialog.show()
        }
        binding.listView.setOnItemLongClickListener { adapterView, view, i, l ->
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Are you sure you want to delete")
            builder.setPositiveButton("yes",{_,_ ->
                arrayList.add("Task")
                arrayList.remove("1")
                baseAdapter.notifyDataSetChanged()
            })
            builder.setNegativeButton("No",{_,_->
            }).show()
            return@setOnItemLongClickListener true
        }
        }
    }