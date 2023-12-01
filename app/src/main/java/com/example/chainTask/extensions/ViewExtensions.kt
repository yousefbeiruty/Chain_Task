package com.example.chainTask.extensions

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

fun Context.showToast(msg: String) =
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

fun Context.openMenu(view: View?, menu: Int, menuClick: (Int) -> Unit) {
    this.apply {
        val popupMenu =
            view?.let {
                PopupMenu(
                    this,
                    it
                )
            }
        popupMenu?.menuInflater?.inflate(menu, popupMenu.menu)

        popupMenu?.setOnMenuItemClickListener { menuItem ->
            menuClick.invoke(menuItem.itemId)
            true
        }
        popupMenu?.show()
    }
}

fun Context.shareWebUrl(url: String?) {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, url)
        type = "text/plain"
    }

    val shareIntent = Intent.createChooser(sendIntent, null)
    startActivity(shareIntent)
}
