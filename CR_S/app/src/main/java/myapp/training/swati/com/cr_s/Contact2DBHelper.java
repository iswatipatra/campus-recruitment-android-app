package myapp.training.swati.com.cr_s;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

public class Contact2DBHelper extends SQLiteOpenHelper {

    SQLiteDatabase db;
    public static final String DATABASE_NAME = "userprofile_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table "+ Contac_tContract.ContactEntry.TABLE_NAME+
            "("+ Contac_tContract.ContactEntry.PRN+" number,"+ Contac_tContract.ContactEntry.USER_NAME+" text,"+
            Contac_tContract.ContactEntry.MOTHER_NAME+" text,"+ Contac_tContract.ContactEntry.EMAIL+" text,"+
            Contac_tContract.ContactEntry.DOB+" text,"+ Contac_tContract.ContactEntry.GENDER+" text,"+
            Contac_tContract.ContactEntry.ADDRESS+" text,"+ Contac_tContract.ContactEntry.PHONE_NUM+" number,"

            + Contac_tContract.ContactEntry.SSC+" text,"+ Contac_tContract.ContactEntry.INSTITUTE_NAME1+" text,"+
            Contac_tContract.ContactEntry.MARKS_SSC+" number,"+ Contac_tContract.ContactEntry.HSC+" text,"+
            Contac_tContract.ContactEntry.INSTITUTE_NAME2+" text,"+ Contac_tContract.ContactEntry.MARKS_HSC+" number,"+
            Contac_tContract.ContactEntry.COLLEGE_NAME+" text,"+ Contac_tContract.ContactEntry.FE_MARKS+" number,"+ Contac_tContract.ContactEntry.SE_MARKS+" number,"+ Contac_tContract.ContactEntry.TE_MARKS+" number,"+ Contac_tContract.ContactEntry.BE_MARKS+" number);";


    public static final String DROP_TABLE = " drop table if exists "+ Contac_tContract.ContactEntry.TABLE_NAME;

    public Contact2DBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.d("database operations","one row inserted ...");

    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("database operations","table created ...");
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);


    }


    public void addContact(int prn,String name,String mothers_name,String email,String dob,String gender,String address,int num,String ssc, String institute1, int i, String hsc, String institute2, int i1, String college_name, int i2, int i3, int i4, int i5,SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contac_tContract.ContactEntry.PRN, prn);
        contentValues.put(Contac_tContract.ContactEntry.USER_NAME, name);
        contentValues.put(Contac_tContract.ContactEntry.MOTHER_NAME, mothers_name);
        contentValues.put(Contac_tContract.ContactEntry.EMAIL, email);
        contentValues.put(Contac_tContract.ContactEntry.DOB, dob);
        contentValues.put(Contac_tContract.ContactEntry.GENDER, gender);
        contentValues.put(Contac_tContract.ContactEntry.ADDRESS, address);
        contentValues.put(Contac_tContract.ContactEntry.PHONE_NUM, num);
        contentValues.put(Contac_tContract.ContactEntry.SSC,ssc);
        contentValues.put(Contac_tContract.ContactEntry.INSTITUTE_NAME1,institute1);
        contentValues.put(Contac_tContract.ContactEntry.MARKS_SSC,i);
        contentValues.put(Contac_tContract.ContactEntry.HSC,hsc);
        contentValues.put(Contac_tContract.ContactEntry.INSTITUTE_NAME2,institute2);
        contentValues.put(Contac_tContract.ContactEntry.MARKS_HSC,i1);
        contentValues.put(Contac_tContract.ContactEntry.COLLEGE_NAME,college_name);
        contentValues.put(Contac_tContract.ContactEntry.FE_MARKS,i2);
        contentValues.put(Contac_tContract.ContactEntry.SE_MARKS,i3);
        contentValues.put(Contac_tContract.ContactEntry.TE_MARKS,i4);
        contentValues.put(Contac_tContract.ContactEntry.BE_MARKS,i5);







        database.insert(Contac_tContract.ContactEntry.TABLE_NAME,null,contentValues);
        Log.d("database operations","one row is inserted...");

    }


    public Cursor readProfile(SQLiteDatabase database)
    {
       /* String[] projections = {Contac_tContract.ContactEntry.PRN, Contac_tContract.ContactEntry.USER_NAME, Contac_tContract.ContactEntry.MOTHER_NAME, Contac_tContract.ContactEntry.EMAIL, Contac_tContract.ContactEntry.ADDRESS, Contac_tContract.ContactEntry.DOB, Contac_tContract.ContactEntry.GENDER,Contac_tContract.ContactEntry.PHONE_NUM, Contac_tContract.ContactEntry.SSC, Contac_tContract.ContactEntry.INSTITUTE_NAME1, Contac_tContract.ContactEntry.MARKS_SSC, Contac_tContract.ContactEntry.HSC, Contac_tContract.ContactEntry.INSTITUTE_NAME2, Contac_tContract.ContactEntry.MARKS_HSC, Contac_tContract.ContactEntry.FE_MARKS, Contac_tContract.ContactEntry.SE_MARKS, Contac_tContract.ContactEntry.TE_MARKS, Contac_tContract.ContactEntry.BE_MARKS};
        Cursor cursor = database.query(Contac_tContract.ContactEntry.TABLE_NAME,
                projections,null,null,null,null,null);*/
      //     db = this.getReadableDatabase();

       String query = "select * from "+ Contac_tContract.ContactEntry.TABLE_NAME+" where "+ Contac_tContract.ContactEntry.USER_NAME+  " = '"+ Contac_tContract.ContactEntry.MATCHING_NAME+ "'";

       Cursor cursor = database.rawQuery(query,null);


        return cursor;

    }




    public Cursor checkPresent(SQLiteDatabase database)
    {
        String query = "select "+ Contac_tContract.ContactEntry.PRN +" from "+ Contac_tContract.ContactEntry.TABLE_NAME+" where "+ Contac_tContract.ContactEntry.USER_NAME+ "= '"+ Contac_tContract.ContactEntry.MATCHING_NAME+ "'";
        Cursor cursor = database.rawQuery(query,null);
        return  cursor;
    }

 public void searchPass(String title)
    {
        Contact2Contract.ContactEntry.MATCHING_NAME = title;

    }
}
