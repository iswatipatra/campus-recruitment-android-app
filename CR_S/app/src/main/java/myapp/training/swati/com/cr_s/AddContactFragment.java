package myapp.training.swati.com.cr_s;


import android.app.Activity;
import android.content.Context;
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
public class AddContactFragment extends Fragment {

    private Button bnSave ;
    EditText Name,Num,Pass;
    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);
        bnSave = view.findViewById(R.id.bn_save);
        Name =  view.findViewById(R.id.txt_contact_name);
        Num = view.findViewById(R.id.txt_contact_num);
        Pass = view.findViewById(R.id.txt_contact_pass);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = Name.getText().toString();
                String num = Num.getText().toString();
                String pass = Pass.getText().toString();

                ContactDBHelper contactDBHelper = new ContactDBHelper(getActivity());
                SQLiteDatabase database = contactDBHelper.getWritableDatabase();
                contactDBHelper.addContact(name,Integer.parseInt(num),pass,database);
                contactDBHelper.close();

                Name.setText("");
                Num.setText("");
                Pass.setText("");

                Toast.makeText(getActivity(),"Contact saved successfully..",Toast.LENGTH_SHORT).show();
            }
        });
        return  view;
    }

}
