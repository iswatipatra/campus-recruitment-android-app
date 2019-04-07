package myapp.training.swati.com.cr_s;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ContactDBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    public static final String DATABASE_NAME = "contact_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table "+ ContactContract.ContactEntry.TABLE_NAME+
            "("+ ContactContract.ContactEntry.USER_NAME+" text,"+ ContactContract.ContactEntry.MOBILE_NUM+
            " phone,"+ ContactContract.ContactEntry.PASSWORD+" text);";

    public static final String DROP_TABLE = " drop table if exists "+ ContactContract.ContactEntry.TABLE_NAME;

    public ContactDBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("Database operations","Database created...");

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.d("databse operations","table created ...");
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }

     public void addContact(String name,int num,String pass,SQLiteDatabase database) {
         ContentValues contentValues = new ContentValues();
         contentValues.put(ContactContract.ContactEntry.USER_NAME, name);
         contentValues.put(ContactContract.ContactEntry.MOBILE_NUM,pass);
         contentValues.put(ContactContract.ContactEntry.PASSWORD, pass);

         database.insert(ContactContract.ContactEntry.TABLE_NAME,null,contentValues);
         Log.d("database operations","one row is inserted...");

     }
       public String searchPass(String user_name)
    {
        db = this.getReadableDatabase();
       // String query = "select user_name and password from "+ ContactContract.ContactEntry.TABLE_NAME;
      //  Cursor cursor = db.rawQ(query,null);
        String[]  projections = {ContactContract.ContactEntry.USER_NAME, ContactContract.ContactEntry.PASSWORD};
        Cursor cursor = db.query(ContactContract.ContactEntry.TABLE_NAME,projections,null,null,
                null,null,null);
        Contac_tContract.ContactEntry.MATCHING_NAME = user_name;
        String a,b;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);

                if (a.equals(user_name))
                {
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
      return b;



    }



}
