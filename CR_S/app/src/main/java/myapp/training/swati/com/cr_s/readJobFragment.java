package myapp.training.swati.com.cr_s;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class readJobFragment extends Fragment {
    private TextView Txt_display;

    public readJobFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_job, container, false);
        Txt_display = view.findViewById(R.id.txt_display);
        readProfile();
        return view;
    }




    private void readProfile()
    {
        Contact22DBHelper contact22DBHelper = new Contact22DBHelper(getActivity());
        SQLiteDatabase database = contact22DBHelper.getReadableDatabase();



        Cursor cursor = contact22DBHelper.readProfile(database);
        String info = "";

        //  if(cursor.moveToFirst()) {
        while (cursor.moveToNext()) {



            String title = cursor.getString(cursor.getColumnIndex(Contact2Contract.ContactEntry.Job_Title));
            String descriptions = cursor.getString(cursor.getColumnIndex(Contact2Contract.ContactEntry.Job_description));
            String requirements = cursor.getString(cursor.getColumnIndex(Contact2Contract.ContactEntry.Job_requriments));
            String responsibity = cursor.getString(cursor.getColumnIndex(Contact2Contract.ContactEntry.Key_responsibility));
            String salary = cursor.getString(cursor.getColumnIndex(Contact2Contract.ContactEntry.Salary_range));
            String criteria = cursor.getString(cursor.getColumnIndex(Contact2Contract.ContactEntry.Criteria));


            info = info + "\n" + "JOB TITLE :" + title + "\nDESCRIPTIONS :" + descriptions + "\nREQUIREMENTS : " + requirements + "\nRESPONSIBILITY : " + responsibity + "\nSALARY : " + salary + "\nCRITERIA : " + criteria +"\n\n\n";
        }


        Txt_display.setText(info);

        contact22DBHelper.close();

    }

}



