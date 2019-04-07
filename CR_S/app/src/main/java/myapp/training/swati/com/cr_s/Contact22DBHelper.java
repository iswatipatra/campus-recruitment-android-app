package myapp.training.swati.com.cr_s;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Contact22DBHelper extends SQLiteOpenHelper{

    SQLiteDatabase db;
    public static final String DATABASE_NAME = "job_db";
    public static final int DATABASE_VERSION = 1;

    public static final String CREATE_TABLE = "create table "+ Contact2Contract.ContactEntry.TABLE_NAME+
            "("+ Contact2Contract.ContactEntry.Job_Title+" text,"+ Contact2Contract.ContactEntry.Job_description+
            " text,"+ Contact2Contract.ContactEntry.Job_requriments+" text,"+ Contact2Contract.ContactEntry.Key_responsibility+" text,"+ Contact2Contract.ContactEntry.Salary_range+" number,"+ Contact2Contract.ContactEntry.Criteria+" number);";

    public static final String DROP_TABLE = " drop table if exists "+ Contact2Contract.ContactEntry.TABLE_NAME;

    public Contact22DBHelper(Context context)
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

    public void addContact(String title,String description,String requriment,String responsibility,int salary,int criteria,SQLiteDatabase database) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Contact2Contract.ContactEntry.Job_Title,title);
        contentValues.put(Contact2Contract.ContactEntry.Job_description,description);
        contentValues.put(Contact2Contract.ContactEntry.Job_requriments,requriment);
        contentValues.put(Contact2Contract.ContactEntry.Key_responsibility,responsibility);
        contentValues.put(Contact2Contract.ContactEntry.Salary_range,salary);
        contentValues.put(Contact2Contract.ContactEntry.Criteria,criteria);

        database.insert(Contact2Contract.ContactEntry.TABLE_NAME,null,contentValues);
        Log.d("database operations","one row is inserted...");

    }


    public Cursor readProfile(SQLiteDatabase database)
    {
        String[] projections = {Contact2Contract.ContactEntry.Job_Title, Contact2Contract.ContactEntry.Job_description, Contact2Contract.ContactEntry.Job_requriments, Contact2Contract.ContactEntry.Key_responsibility, Contact2Contract.ContactEntry.Salary_range, Contact2Contract.ContactEntry.Criteria};
        Cursor cursor = database.query(Contact2Contract.ContactEntry.TABLE_NAME,
                projections,null,null,null,null,null);
        //     db = this.getReadableDatabase();

      //  String query = "select * from "+ Contact2Contract.ContactEntry.TABLE_NAME+" where "+ Contac_tContract.ContactEntry.USER_NAME+  " = '"+ Contac_tContract.ContactEntry.MATCHING_NAME+ "'";

      //  Cursor cursor = database.rawQuery(query,null);


        return cursor;

    }


    public Cursor readApplicant(SQLiteDatabase database)
    {
       /* String[] projections = {Contac_tContract.ContactEntry.PRN, Contac_tContract.ContactEntry.USER_NAME, Contac_tContract.ContactEntry.MOTHER_NAME, Contac_tContract.ContactEntry.EMAIL, Contac_tContract.ContactEntry.ADDRESS, Contac_tContract.ContactEntry.DOB, Contac_tContract.ContactEntry.GENDER,Contac_tContract.ContactEntry.PHONE_NUM, Contac_tContract.ContactEntry.SSC, Contac_tContract.ContactEntry.INSTITUTE_NAME1, Contac_tContract.ContactEntry.MARKS_SSC, Contac_tContract.ContactEntry.HSC, Contac_tContract.ContactEntry.INSTITUTE_NAME2, Contac_tContract.ContactEntry.MARKS_HSC, Contac_tContract.ContactEntry.FE_MARKS, Contac_tContract.ContactEntry.SE_MARKS, Contac_tContract.ContactEntry.TE_MARKS, Contac_tContract.ContactEntry.BE_MARKS};
        Cursor cursor = database.query(Contac_tContract.ContactEntry.TABLE_NAME,
                projections,null,null,null,null,null);*/
        //     db = this.getReadableDatabase();
        db = this.getReadableDatabase();
        String query = "select * from "+ Contact2Contract.ContactEntry.TABLE_NAME+" where "+ Contact2Contract.ContactEntry.Job_Title+  " = '"+ Contact2Contract.ContactEntry.MATCHING_NAME+ "'";

        Cursor cursor = database.rawQuery(query,null);


        return cursor;

    }
}
