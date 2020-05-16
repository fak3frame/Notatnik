package pl.wsei.notatnik

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