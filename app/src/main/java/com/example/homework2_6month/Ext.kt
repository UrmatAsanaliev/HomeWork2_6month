package com.example.homework2_6month

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog

fun Context.showToast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

object PromptUtils {
    fun alertDialog(context: Context, dialogBuilder: AlertDialog.Builder.() -> Unit): Dialog {
        val builder = AlertDialog.Builder(context).also {
            it.setCancelable(false)
            it.dialogBuilder()
        }
        return builder.create()
    }

    fun AlertDialog.Builder.negativeButton(text: String = "Нет",
                                           handleClick: (dialogInterface: DialogInterface)
                                           -> Unit = {}) {
        this.setPositiveButton(text) { dialogInterface, which -> handleClick(dialogInterface) }
    }

    fun AlertDialog.Builder.positiveButton(text: String = "Да",
                                           handleClick: (dialogInterface: DialogInterface)
                                           -> Unit = {}) {
        this.setNegativeButton(text) { dialogInterface, which -> handleClick(dialogInterface) }
    }
}