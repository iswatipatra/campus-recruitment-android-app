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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment2 extends Fragment implements View.OnClickListener {

    private Button BnCreate,Bnview,BnJob,BnApply;
    OnDbOplisterner2 dbOplisterner2;

    public HomeFragment2() {
        // Required empty public constructor
    }

    public interface OnDbOplisterner2
    {
        public void dBOpPerformed2(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_fragment2, container, false);
        BnCreate = view.findViewById(R.id.bn_save1);
        BnCreate.setOnClickListener(this);
        Bnview = view.findViewById(R.id.bn_save2);
        Bnview.setOnClickListener(this);
        BnJob = view.findViewById(R.id.bn_save3);
        BnJob.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.bn_save1:

                 String id = null;

                Contact2DBHelper contact2DBHelper = new Contact2DBHelper(getActivity());
                SQLiteDatabase database = contact2DBHelper.getReadableDatabase();
                Cursor cursor = contact2DBHelper.checkPresent(database);
                while(cursor.moveToNext()) {
                     id = Integer.toString(cursor.getInt(cursor.getColumnIndex(Contac_tContract.ContactEntry.PRN)));
                }
                if(  id == null) {
                    dbOplisterner2.dBOpPerformed2(0);
                }else
                {
                       Toast.makeText(getActivity(),"Profile is already created",Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.bn_save2:
                dbOplisterner2.dBOpPerformed2(1);
                break;

            case R.id.bn_save3:
                dbOplisterner2.dBOpPerformed2(2);


        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try{
            dbOplisterner2 = (OnDbOplisterner2) activity;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+" must implpleent that method..");
        }

    }
}
