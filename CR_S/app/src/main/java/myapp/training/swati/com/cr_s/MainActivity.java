package myapp.training.swati.com.cr_s;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Homefragment.OnDbOpListener{

    ContactDBHelper helper = new ContactDBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }

            Homefragment homefragment = new Homefragment();
             getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,homefragment).commit();
        }



    }


    @Override
    public void dBOpPerformed(int method) {

        switch (method){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AddContactFragment()).addToBackStack(null).commit();
                break;

            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ApplicantFragment()).addToBackStack(null).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CompanyFragment()).addToBackStack(null).commit();
                break;
        }
    }


    public void sendMessage(View view)
    {

        EditText a = (EditText)findViewById(R.id.txt_contact_name);
        String str = a.getText().toString();
        EditText b = (EditText)findViewById(R.id.txt_contact_pass);
        String pass = b.getText().toString();

        String password = helper.searchPass(str);

          if(pass.equals(password))
          {
              Intent intent = new Intent(this,ApplicantLogin.class);
              intent.putExtra("Uername",str);
              startActivity(intent);
          }
           else
          {
              Toast temp = Toast.makeText(MainActivity.this,"Username and pasword dont match",Toast.LENGTH_SHORT);
              temp.show();
          }


       /* EditText a = (EditText)findViewById(R.id.txt_contact_name);
        String str = a.getText().toString();
        EditText b = (EditText)findViewById(R.id.txt_contact_pass);
        String pass = b.getText().toString();
     Cursor cursor =  helper.readProfile(str,pass);

     if( cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.USER_NAME)) == str  && cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.PASSWORD)) == pass )
     {
         Intent intent = new Intent(this,ApplicantLogin.class);
         intent.putExtra("Uername",str);
         startActivity(intent);
     }else
     {
         Toast temp = Toast.makeText(MainActivity.this,"Username and pasword dont match",Toast.LENGTH_SHORT);
         temp.show();
     }
*/


    }

   public  void sendMessage2(View view)
    {

        EditText a = (EditText)findViewById(R.id.txt_contact_name);
        String str = a.getText().toString();
        EditText b = (EditText)findViewById(R.id.txt_contact_pass);
        String pass = b.getText().toString();

        String password = helper.searchPass(str);

        if(pass.equals(password))
        {
            Intent intent = new Intent(this,CompanyLogin.class);
            intent.putExtra("Uername",str);
            startActivity(intent);
        }
        else
        {
            Toast temp = Toast.makeText(MainActivity.this,"Username and pasword dont match",Toast.LENGTH_SHORT);
            temp.show();
        }


    }


}
