package com.example.chainTask.extensions

import com.example.chainTask.common.ProgressDialog

fun ProgressDialog.showProgressDialog(){
    this.show()
}


fun ProgressDialog.hideProgressDialog(){
    this.dismiss()
}
