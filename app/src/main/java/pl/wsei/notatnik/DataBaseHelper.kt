package pl.wsei.notatnik

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


//Opis tabeli
object TableInfo: BaseColumns{

    const val TABLE_NAME = "Moje notatki"
    const val TABLE_COLUMN_TITLE = "tytuł"
    const val TABLE_COLUMN_MESSAGE = "wiadomość"
}

//Podstawowe komendy SQL
object BasicCommand{
    const val SQL_CREATE_TABLE: String =
        "CREATE TABLE ${TableInfo.TABLE_NAME} ("+
                "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                "${TableInfo.TABLE_COLUMN_TITLE} TEXT NOT NULL," +
                "${TableInfo.TABLE_COLUMN_MESSAGE} TEXT NOT NULL)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXIST ${TableInfo.TABLE_NAME}"
}

class DataBaseHelper(context: Context): SQLiteOpenHelper(context, TableInfo.TABLE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(BasicCommand.SQL_CREATE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(BasicCommand.SQL_DELETE_TABLE)
        onCreate(db)
    }


}