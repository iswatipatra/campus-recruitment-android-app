package myapp.training.swati.com.cr_s;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactsFragment extends Fragment {

    private TextView Txt_display;
    public ReadContactsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_read_contacts, container, false);
        Txt_display = view.findViewById(R.id.txt_display);
        readProfile();
        return view;
    }


      //  if(cursor.moveToFirst()) {



                private void readProfile()
                {
                    Contact2DBHelper contact2DBHelper = new Contact2DBHelper(getActivity());
                    SQLiteDatabase database = contact2DBHelper.getReadableDatabase();

                    Cursor cursor = contact2DBHelper.readProfile(database);
                    String info = "";

                    while (cursor.moveToNext()) {

                        String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.PRN)));
                    String name = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.USER_NAME));
                String mother_name = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.MOTHER_NAME));
                String email = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.EMAIL));

                String dob = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.DOB));
                String gender = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.GENDER));
                String address = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.ADDRESS));
                String phone_no = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.PHONE_NUM)));
                String ssc = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.SSC));
                String institute1 = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.INSTITUTE_NAME1));
                String marks_ssc = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.MARKS_SSC)));
                String hsc = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.HSC));
                String institute2 = cursor.getString(cursor.getColumnIndex(Contac_tContract.ContactEntry.INSTITUTE_NAME2));
                String marks_hsc = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.MARKS_HSC)));
                String fe = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.FE_MARKS)));
                String se = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.SE_MARKS)));
                String te = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.TE_MARKS)));
                String be = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.BE_MARKS)));
                info = info + "\n\n" + "ID: " + id + "\n\nName: " + name + "\n\nMother_name: " + mother_name + "\n\nEMAIL: " + email + "\n\nADDRESS: " + address + "\n\nDOB: " + dob + "\n\nPHONE_no: " + phone_no + "\n\nSSC_BOARD: " + ssc + "\n\nINSTUTITE1: " + institute1 + "\n\nSSC_MARKS: " + marks_ssc + "\n\nHSC_BOARD: " + hsc + "\n\nINSTUTE2: " + institute2 + "\n\nHSC_MARKS: " + marks_hsc + "\n\nFE: " + fe + "\n\nSE: " + se + "\n\nTE: " + te + "\n\nBE: " + be;

            }


        Txt_display.setText(info);

            contact2DBHelper.close();

    }

}
