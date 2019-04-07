package myapp.training.swati.com.cr_s;


import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
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
public class BlankFragment4 extends Fragment implements View.OnClickListener {

    private Button bnSave;
   OnDbOplisterner3 dbOplisterner3;
    EditText Name;

    public BlankFragment4() {
        // Required empty public constructor
    }

   public interface OnDbOplisterner3 {
        public void dBOpPerformed3(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank_fragment4, container, false);
        bnSave = view.findViewById(R.id.bn_save);
       bnSave.setOnClickListener(this);
        Name =  view.findViewById(R.id.txt_job_title);
        // readApplicant();
        Contact2Contract.ContactEntry.MATCHING_NAME =   Name.getText().toString();
        return view;
    }

  /*  private void readApplicant()
    {
        Contact22DBHelper contact22DBHelper = new Contact22DBHelper(getActivity());
        SQLiteDatabase database = contact22DBHelper.getReadableDatabase();



        Cursor cursor = contact22DBHelper.readApplicant(database);
        while(cursor.moveToNext())
        {
            bnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Toast.makeText(getActivity(),"applied successfully..",Toast.LENGTH_SHORT).show();
                }
            });
        }
        Toast.makeText(getActivity(),"applied successfully",Toast.LENGTH_SHORT).show();

        contact22DBHelper.close();

    }*/

   @Override
    public void onClick(View view) {

            switch (view.getId()){
                case R.id.bn_save:

                    dbOplisterner3.dBOpPerformed3(0);
                    break;
            }
        }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity  activity = (Activity)context;

        try{
            dbOplisterner3 = (OnDbOplisterner3) activity;
        }catch (ClassCastException e)
        {
            throw  new ClassCastException(activity.toString()+"must implement method.");
        }

    }
}

