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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment3 extends Fragment  implements View.OnClickListener  {

    private TextView Txt_display;
    private Button BnCreate,BnView;
    OnDbOpListener3 dbOpListener3;
    public HomeFragment3() {
        // Required empty public constructor
    }

    public interface OnDbOpListener3
    {
        public void dBOpPerformed3(int method);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment3, container, false);
        BnCreate = view.findViewById(R.id.bn_save1);
        BnCreate.setOnClickListener(this);

        BnView = view.findViewById(R.id.bn_save2);
        BnView.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.bn_save1:
                dbOpListener3.dBOpPerformed3(0);
                break;

            case R.id.bn_save2:

                Contact22DBHelper contact22DBHelper = new Contact22DBHelper(getActivity());
                SQLiteDatabase database = contact22DBHelper.getReadableDatabase();
                Cursor cursor = contact22DBHelper.readApplicant(database);
               while (cursor.moveToNext()) {




               }
                dbOpListener3.dBOpPerformed3(1);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity =  (Activity) context;
        try {
            dbOpListener3 = (OnDbOpListener3) activity;
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(activity.toString()+ "must implement the interface method..");
        }
    }

}
