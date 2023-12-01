package com.example.chaintask.extensions

import com.example.chaintask.common.ProgressDialog

fun ProgressDialog.showProgressDialog(){
    this.show()
}


fun ProgressDialog.hideProgressDialog(){
    this.dismiss()
}
