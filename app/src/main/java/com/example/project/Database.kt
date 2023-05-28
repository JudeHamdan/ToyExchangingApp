    package com.example.project

    import android.content.ContentProvider
    import android.content.ContentValues
    import android.database.Cursor
    import android.database.sqlite.SQLiteDatabase

    import android.net.Uri

    class Database : ContentProvider() {


        companion object{
            private const val PROVIDER_NAME="package com.example.project/Database"
            private const val URL = "content://$PROVIDER_NAME/NAME"
            val CONTENT_URI: Uri =Uri.parse(URL)

            const val ID= "_ID"
            const val NAME="NAME"
            const val MEANING= "MEANING"


        }

        override fun onCreate(): Boolean {

            var helper=MyHelper(context)
            db=helper.writableDatabase
            return db != null

            TODO("Not yet implemented")
        }


    lateinit var db: SQLiteDatabase



        override fun query(
            uri: Uri,
            cols: Array<out String>?,
            condition: String?,
            condition_value: Array<out String>?,
            order: String?
        ): Cursor? {

            return db.query("NAME",cols,condition,condition_value,null,null,order)
            TODO("Not yet implemented")
        }

        override fun getType(p0: Uri): String? {
            return "vnd.android.cursor.dir/vnd.example.NAME"


            TODO("Not yet implemented")
        }

        override fun insert(uri: Uri, cv: ContentValues?): Uri? {
            db.insert("NAME",null,cv)
            context?.contentResolver?.notifyChange(uri,null)
            return uri

        }

        override fun delete(uri: Uri, condition: String?, condition_value: Array<out String>?): Int {


            var count =   db.delete("NAME",condition,condition_value)
            context?.contentResolver?.notifyChange(uri,null)
            return count

        }

        override fun update(uri: Uri, cv: ContentValues?, condition: String?, condition_value: Array<out String>?): Int {
         var count =   db.update("NAME",cv,condition,condition_value)
            context?.contentResolver?.notifyChange(uri,null)
            return count




        }
    }