package com.example.chaintask.extensions

import android.view.View

fun <MODEL> ((view: View, model: MODEL, position: Int) -> Unit)?.toViewClickListener(
    model: MODEL,
    position: Int
) =
    { view: View ->
        this?.invoke(view, model, position)
    }