package myapp.training.swati.com.cr_s;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private Button bnSave;
    EditText Id,Name,Mother_name,Email,Dob,Gender,Address,Phone_num,Ssc_board,Institute1,Ssc_marks,Hsc_board,Institute2,Hsc_marks,College_name,Fe,Se,Te,Be;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        bnSave = (Button) view.findViewById(R.id.bn_save);
        Id = (EditText) view.findViewById(R.id.txt_PRNnumber);
        Name = (EditText) view.findViewById(R.id.txt_contact_name);
        Mother_name = (EditText) view.findViewById(R.id.txt_contact_mothername);
        Email = (EditText) view.findViewById(R.id.txt_contact_email);
        Dob = (EditText) view.findViewById(R.id.txt_contact_DOB);
        Gender = (EditText) view.findViewById(R.id.txt_contact_gender);
        Address = (EditText) view.findViewById(R.id.txt_contact_Address);
        Phone_num = (EditText) view.findViewById(R.id.txt_contact_number);
        Ssc_board = (EditText) view.findViewById(R.id.Board);
        Institute1 = (EditText) view.findViewById(R.id.School_name);
        Ssc_marks = (EditText) view.findViewById(R.id.marks);
        Institute2 = (EditText) view.findViewById(R.id.School_name2);
        Hsc_board = (EditText) view.findViewById(R.id.hsc_board);
        Hsc_marks = (EditText) view.findViewById(R.id.marks2);
        College_name = (EditText) view.findViewById(R.id.college_name);
        Fe = (EditText) view.findViewById(R.id.FE);
        Se = (EditText) view.findViewById(R.id.SE);
        Te = (EditText) view.findViewById(R.id.TE);
        Be = (EditText) view.findViewById(R.id.BE);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = Id.getText().toString();
                String name = Name.getText().toString();
                String mother_name = Mother_name.getText().toString();
                String email = Email.getText().toString();
                String dob = Dob.getText().toString();
                String gender = Gender.getText().toString();
                String address = Address.getText().toString();
                String phone_num = Phone_num.getText().toString();
                String ssc_board = Ssc_board.getText().toString();
                String institute1 = Institute1.getText().toString();
                String ssc_marks = Ssc_marks.getText().toString();
                String hhc_board = Hsc_board.getText().toString();
                String institute2 = Institute2.getText().toString();
                String hsc_marks_ = Hsc_marks.getText().toString();
                String college_name = College_name.getText().toString();
                String fe = Fe.getText().toString();
                String se = Se.getText().toString();
                String te = Te.getText().toString();
                String be = Be.getText().toString();


                Contact2DBHelper contact2DBHelper = new Contact2DBHelper(getActivity());
                SQLiteDatabase database = contact2DBHelper.getWritableDatabase();

                 contact2DBHelper.addContact(Integer.parseInt(id),name,mother_name,email,dob,gender,address,Integer.parseInt(phone_num),ssc_board,institute1,Integer.parseInt(ssc_marks),hhc_board,institute2,Integer.parseInt(hsc_marks_),college_name,Integer.parseInt(fe),Integer.parseInt(se),Integer.parseInt(te),Integer.parseInt(be),database);
                 contact2DBHelper.close();
                 Id.setText("");
                 Name.setText("");
                 Mother_name.setText("");
                 Email.setText("");
                 Dob.setText("");
                 Gender.setText("");
                    Address.setText("");
                    Phone_num.setText("");
                    Ssc_board.setText("");
                    Hsc_board.setText("");
                    Institute2.setText("");
                    Hsc_marks.setText("");
                    College_name.setText("");
                    Fe.setText("");
                    Se.setText("");
                    Te.setText("");
                    Be.setText("");

                Toast.makeText(getActivity(),"Contact saved successfully",Toast.LENGTH_SHORT).show();


            }
        });
        return view;
    }

}
