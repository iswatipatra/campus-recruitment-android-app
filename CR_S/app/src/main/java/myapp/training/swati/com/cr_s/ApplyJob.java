package myapp.training.swati.com.cr_s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ApplyJob extends AppCompatActivity implements BlankFragment4.OnDbOplisterner3{

    //Contact2DBHelper helper = new Contact2DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_job);

        if(findViewById(R.id.fragment_container3)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            BlankFragment4 blankFragment4 = new BlankFragment4();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container3,blankFragment4).commit();
        }

    }

    @Override
    public void dBOpPerformed3(int method) {

       switch (method)
        {
            case 0:
                Toast.makeText(getApplicationContext(),"applied successfully",Toast.LENGTH_SHORT).show();
                break;
        }

    }


  /*  public void apply(View view){
        EditText a = (EditText)findViewById(R.id.txt_job_title);
        String str = a.getText().toString();


        helper.searchPass(str);
    }*/




}
