package digi.coders.quizapp;

import android.content.Context;
import android.content.SharedPreferences;

import digi.coders.quizapp.Models.Model;

public class SharedPref {

    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASSWORD="password";
    private static final String SHARED_PREFERENCE="quiz";

    private static SharedPref mInstance;
     static Context mcontext;

    public SharedPref() {
    }

    private SharedPref(Context context){
        mcontext=context;

    }
//   public static synchronized SharedPref getInstance(Context context) {
//      // if (mInstance == null) {
//           mInstance = new SharedPref(context);
//      // }
//       return mInstance;
//   }
//
   public  static synchronized SharedPref getInstance(Context context)
   {
       if (mInstance==null){
          mInstance=new SharedPref(context);
       }
       return mInstance;
   }

   public void setuser(Model model){
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_NAME, model.getName());
        editor.putString(KEY_EMAIL, model.getEmail());
        editor.putString(KEY_PASSWORD, model.getPassword());
       editor.apply();
   }

   public  Model  getuser(){
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE);

       return new Model(
               sharedPreferences.getString(KEY_NAME,null),
               sharedPreferences.getString(KEY_EMAIL,null),
               sharedPreferences.getString(KEY_PASSWORD,null)
       );
   }
   public boolean isLoggedIn(){
        SharedPreferences sharedPreferences=mcontext.getSharedPreferences(SHARED_PREFERENCE,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PASSWORD,null)!=null;
   }
}
