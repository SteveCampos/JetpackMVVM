package com.stevecampos.jetpackmvvm

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("items")
fun <T> setRecyclerViewProperties(rcv: RecyclerView, data: List<T>?) {
    if (data == null) return
    if (rcv.adapter is GenericAdapter<*>) {
        (rcv.adapter as GenericAdapter<T>).setItems(data)
    }
}
