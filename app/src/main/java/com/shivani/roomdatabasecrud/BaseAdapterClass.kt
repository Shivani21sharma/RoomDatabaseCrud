package com.shivani.roomdatabasecrud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.shivani.roomdatabasecrud.RoomDataBase.TodoEntity
import com.shivani.roomdatabasecrud.databinding.ItemAdapterBinding

class BaseAdapterClass(var array : ArrayList<TodoEntity>,
                       var description: ArrayList<String>,var activity: MainActivity): BaseAdapter() {
    override fun getCount(): Int {
        return arrayListOf<String>().size
    }

    override fun getItem(p0: Int): Any {
        return 0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
       // var initView = LayoutInflater.from(p2?.context).inflate(R.layout.item_adapter, p2, false)
        //var tvTitle: TextView = initView.findViewById(R.id.tvtitle)

        var initView=ItemAdapterBinding.inflate(activity.layoutInflater)
        //var tvDescription: TextView = initView.findViewById(R.id.tvDscriptio)
        //tvTitle.setText(arrayListOf<String>()[p0])
        //tvDescription.setText(arrayListOf<String>()[p0])
        initView.todo= array[p0]
        fun goneUnless(view: View, visible: Boolean) {
            view.visibility = if (visible) View.VISIBLE else View.GONE
        }
        return initView.root
    }
}


