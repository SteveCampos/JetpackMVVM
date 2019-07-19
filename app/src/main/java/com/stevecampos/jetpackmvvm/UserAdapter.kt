package com.stevecampos.jetpackmvvm

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : GenericAdapter<User>() {
    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder = UserHolder(view)


    override fun getLayoutId(position: Int, obj: User): Int = R.layout.item_user

}

class UserHolder : RecyclerView.ViewHolder, GenericAdapter.Binder<User> {
    var txtTitle: AppCompatTextView

    constructor(view: View) : super(view) {
        txtTitle = view.findViewById(R.id.txt_title);
    }

    override fun bind(data: User) {
        txtTitle.setText(data.name)
    }

}