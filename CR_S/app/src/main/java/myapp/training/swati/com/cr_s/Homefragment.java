package myapp.training.swati.com.cr_s;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Homefragment extends Fragment implements View.OnClickListener {

    private Button BnStud,BnComp,BnSign;
    OnDbOpListener dbOpListener;
    public Homefragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListener
    {
        public void dBOpPerformed(int method);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homefragment, container, false);
        BnSign = view.findViewById(R.id.bn_save3);
        BnSign.setOnClickListener(this);

        BnStud = view.findViewById(R.id.bn_save1);
        BnStud.setOnClickListener(this);

        BnComp = view.findViewById(R.id.bn_save2);
        BnComp.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.bn_save3:
                dbOpListener.dBOpPerformed(0);
                break;

            case R.id.bn_save1:
                dbOpListener.dBOpPerformed(1);
                break;

            case R.id.bn_save2:
                dbOpListener.dBOpPerformed(2);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity =  (Activity) context;
        try {
            dbOpListener = (OnDbOpListener) activity;
        }
        catch (ClassCastException e)
        {
            throw  new ClassCastException(activity.toString()+ "must implement the interface method..");
        }
    }
}
