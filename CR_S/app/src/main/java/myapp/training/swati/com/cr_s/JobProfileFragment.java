package myapp.training.swati.com.cr_s;


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
public class JobProfileFragment extends Fragment {

    private Button bnSave;
    EditText Title,Description,Requriment,Responsibity,Salary,Criteria;

    public JobProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_job_profile, container, false);

        bnSave = (Button) view.findViewById(R.id.bn_save);
        Title = (EditText) view.findViewById(R.id.txt_job_title);
        Description = (EditText) view.findViewById(R.id.txt_job_description);
        Requriment = (EditText) view.findViewById(R.id.txt_job_requirment);
        Responsibity = (EditText) view.findViewById(R.id.txt_key_responsiblity);
        Salary = (EditText) view.findViewById(R.id.txt_salary_range);
        Criteria = (EditText) view.findViewById(R.id.txt_criteria);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = Title.getText().toString();
                String description = Description.getText().toString();
                String requirment = Requriment.getText().toString();
                String responsibilty = Responsibity.getText().toString();
                String salary = Salary.getText().toString();
                String criteria = Criteria.getText().toString();



                Contact22DBHelper contact22DBHelper = new Contact22DBHelper(getActivity());
                SQLiteDatabase database = contact22DBHelper.getWritableDatabase();

                contact22DBHelper.addContact(title,description,requirment,responsibilty,Integer.parseInt(salary),Integer.parseInt(criteria),database);
                contact22DBHelper.close();
                Title.setText("");
                Description.setText("");
                Requriment.setText("");
                Responsibity.setText("");
                Salary.setText("");
                Criteria.setText("");


                Toast.makeText(getActivity(),"Contact saved successfully",Toast.LENGTH_SHORT).show();


            }
        });
        return  view;
    }

}
