package com.robotemi.sdk

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.net.Uri
import androidx.annotation.RestrictTo
import androidx.annotation.RestrictTo.Scope.LIBRARY

@RestrictTo(LIBRARY)
class TemiSdkContentProvider : ContentProvider() {


    override fun onCreate(): Boolean {
        sdkContext = context
        if (context == null) {
            throw NullPointerException("context=null")
        }
        TemiSdkServiceConnection().startConnection(context!!)
        return true
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?) = 0

    override fun getType(uri: Uri) = null

    override fun insert(uri: Uri, values: ContentValues?) = null

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ) = null

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ) = 0

    companion object {
        @SuppressLint("StaticFieldLeak")
        var sdkContext: Context? = null
    }
}
