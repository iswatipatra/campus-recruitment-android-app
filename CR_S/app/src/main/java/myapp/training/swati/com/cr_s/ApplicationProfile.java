package myapp.training.swati.com.cr_s;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ApplicationProfile extends AppCompatActivity {

    private Button bnSave;
    EditText Id,Name,Mother_name,Email,Dob,Gender,Address,Phone_num,Ssc_board,Institute1,Ssc_marks,Hsc_board,Institute2,Hsc_marks,College_name,Fe,Se,Te,Be;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_profile);

        setContentView(R.layout.activity_application_profile);
        bnSave = (Button) findViewById(R.id.bn_save);
        Id = (EditText) findViewById(R.id.txt_PRNnumber);
        Name = (EditText) findViewById(R.id.txt_contact_name);
        Mother_name = (EditText) findViewById(R.id.txt_contact_mothername);
        Email = (EditText) findViewById(R.id.txt_contact_email);
        Dob = (EditText) findViewById(R.id.txt_contact_DOB);
        Gender = (EditText) findViewById(R.id.txt_contact_gender);
        Address = (EditText) findViewById(R.id.txt_contact_Address);
        Phone_num = (EditText) findViewById(R.id.txt_contact_number);
        Ssc_board = (EditText) findViewById(R.id.Board);
        Institute1 = (EditText) findViewById(R.id.School_name);
        Ssc_marks = (EditText) findViewById(R.id.marks);
        Institute2 = (EditText) findViewById(R.id.School_name2);
        Hsc_board = (EditText) findViewById(R.id.hsc_board);
        Hsc_marks = (EditText) findViewById(R.id.marks2);
        College_name = (EditText) findViewById(R.id.college_name);
        Fe = (EditText) findViewById(R.id.FE);
        Se = (EditText) findViewById(R.id.SE);
        Te = (EditText) findViewById(R.id.TE);
        Be = (EditText) findViewById(R.id.BE);
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

                Toast.makeText(getApplicationContext(),"Contact Saved successfully",Toast.LENGTH_SHORT).show();

            }
        });


    }

}
