package com.example.kiki.App;

import android.content.Context;
import android.content.SharedPreferences;

public class Constants {
   public static String NAME="name",EMAIL="email",ADDRESS="address",PHONE_NO="phone_no";
   public static String ECOM_DB = "ecom_db";


   /* //Stripe payment gateway key's
    public static String SECRET_KEY = "sk_test_51L40KuSHPRq8AwlNJBx8WyyJQTVwePQhahqFK20477OeWsWYExenllVfMjH5lxHPSPiCx159kdFKWQ9ELw5JTm3z00JzBXIGWC";
    public static String PUBLISH_KEY = "pk_test_51L40KuSHPRq8AwlNY9v8LwG9tNkdGvaEh6uHQdbWwrfSDnfrdOGq3qv9ZGFtrnA6IXDlXXpVBVZVKl8NQfZ3SuCg00huMVaSD2";

    //Google pay Payement gateway
    public static String GOOGLE_PAY_PACKAGE_NAME = "com.google.android.apps.nbu.paisa.user";
    public static int GOOGLE_PAY_REQUEST_CODE = 123;*/

    public void getString(String key, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ECOM_DB, Context.MODE_PRIVATE);
        sharedPreferences.getString(key, "");

    }

    public void setString(String key, String value, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ECOM_DB, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value); // Storing string
        editor.apply();

    }


}
