package com.example.project
import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri


class UsersProvider() : ContentProvider(){

    companion object {

        val PROVIDER_NAME = "com.example.project.UsersProvider"

        val URL = "content://$PROVIDER_NAME/USERS"
        val CONTENT_URI = Uri.parse(URL)
        val name="name"
        val lastName="LASTNAME"
        val email="email"
        val password="password"
        val contacct="contact"

    }
    lateinit var db:SQLiteDatabase

    override fun onCreate(): Boolean {
        var helper= context?.let { MyHelper(it) }

        if (helper != null) {
            db=helper.writableDatabase
        }

        return if(db==null) false else true

    }

    override fun query(
        uri: Uri,
        cols: Array<out String>?,
        condition: String?,
        condition_val: Array<out String>?,
        order: String?
    ): Cursor? {
        return db.query("USERS",cols,condition,condition_val,null,null,null)
    }

    override fun getType(p0: Uri): String? {
        return "vnd.android.cursor.dir/vnd.example.USERS"
    }


    override fun insert(uri: Uri, cv: ContentValues?): Uri? {

        db.insert("USERS",null,cv)
        context?.contentResolver?.notifyChange(uri,null)
        return uri
    }

    override fun delete(uri: Uri, condition: String?, condition_val: Array<out String>?): Int {
        var count= db.delete("USERS",condition,condition_val)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }

    @SuppressLint("SuspiciousIndentation")
    override fun update(uri: Uri, cv: ContentValues?, condition: String?, condition_val: Array<out String>?): Int {
        var count = db.update("USERS",cv,condition,condition_val)
        context?.contentResolver?.notifyChange(uri,null)
        return count
    }

}