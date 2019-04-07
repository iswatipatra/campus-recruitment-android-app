package myapp.training.swati.com.cr_s;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CompanyLogin extends AppCompatActivity  implements HomeFragment3.OnDbOpListener3 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_login);

        if(findViewById(R.id.fragment_container3)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            HomeFragment3  homeFragment3 = new HomeFragment3();

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container3,homeFragment3).commit();
        }
    }


    @Override
    public void dBOpPerformed3(int method) {

        switch (method) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container3, new JobProfileFragment()).addToBackStack(null).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container3, new JobViewFragment()).addToBackStack(null).commit();
                break;


        }
    }
}
