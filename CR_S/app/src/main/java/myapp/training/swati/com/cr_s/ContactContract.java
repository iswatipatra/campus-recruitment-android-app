package myapp.training.swati.com.cr_s;

import java.security.PublicKey;

public final class ContactContract {

    //public static ContactEntry ContactEntry;

    private ContactContract(){}


              public static class ContactEntry {
                  public static final String TABLE_NAME = "contact_info";

                  public static final String USER_NAME = "user_name";
                  public static final String MOBILE_NUM = "mobile_num";
                  public static final String PASSWORD = "password";
              }

    }
