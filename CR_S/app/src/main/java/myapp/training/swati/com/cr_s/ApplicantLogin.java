package myapp.training.swati.com.cr_s;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ApplicantLogin extends AppCompatActivity implements HomeFragment2.OnDbOplisterner2 {

    Contact2DBHelper helper = new Contact2DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applicant_login);

        if(findViewById(R.id.fragmant_container2)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            HomeFragment2  homeFragment2 = new HomeFragment2();

            getSupportFragmentManager().beginTransaction().add(R.id.fragmant_container2,homeFragment2).commit();
        }
    }

    @Override
    public void dBOpPerformed2(int method) {

        switch (method)
        {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_container2,new BlankFragment()).addToBackStack(null).commit();
                break;

            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_container2,new ReadContactsFragment()).addToBackStack(null).commit();
             break;

            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_container2,new readJobFragment()).addToBackStack(null).commit();
                break;



        }
    }

    public void viewJob(View view)
    {
        Intent intent = new Intent(this,ApplyJob.class);
        startActivity(intent);
    }



   /* public  void nextMessage(View view)
    {

        Intent intent = new Intent(this,ApplicationProfile.class);

        startActivity(intent);
    }
*/

  /*  public void apply(View view){
        EditText a = (EditText)findViewById(R.id.txt_job_title);
        String str = a.getText().toString();


        helper.searchPass(str);
    }
*/


}
