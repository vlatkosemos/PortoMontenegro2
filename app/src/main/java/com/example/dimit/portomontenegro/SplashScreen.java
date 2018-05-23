package com.example.dimit.portomontenegro;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SplashScreen extends Activity {

    Context context = this;
    int br=0;
   // UModuleResponse res;

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        InitializaAnimations();
        context=this;

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
             @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, MainPortoMontenegro.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);

    }


    public void InitializaAnimations()
    {
        // Spinner Loading Animation
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate_an);
        ImageView spiner = (ImageView) findViewById(R.id.spiner);
        spiner.startAnimation(animRotate);

        //Loading Layer
        RelativeLayout loading = (RelativeLayout) findViewById(R.id.loading_screen);
        // Prepare the View for the animation
        loading.setVisibility(View.VISIBLE);
        loading.setAlpha(1f);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                RelativeLayout loading = (RelativeLayout) findViewById(R.id.loading_screen);
                loading.animate()
                        .alpha(0.0f)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                RelativeLayout loading = (RelativeLayout) findViewById(R.id.loading_screen);
                                super.onAnimationEnd(animation);
                                loading.setVisibility(View.GONE);
                                loading.setAlpha(0f);
                            }
                        });

            }
        }, SPLASH_TIME_OUT);

        //Connection error message


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

//                boolean connected = false;
//                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
//                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
//                    //we are connected to a network
//                    connected = true;
//                }
//                else {
//                    TextView error_internet = (TextView) findViewById(R.id.info_message);
//                    error_internet.setText("Проблем со вчитување на податоците, ве молиме проверете ја вашата интернет конекција и рестартирајте ја апликацијата.");
//                }
            }
        }, 1000);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1) {
                //Toast.makeText(getApplicationContext(),res.podatoci,Toast.LENGTH_SHORT).show();
            }
        }
    };

//    private void startDialog(final UModuleRequest req)
//    {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                UHelper p = new UHelper(context);
//                res=p.GetPodatoci2(req);
//                handler.sendEmptyMessage(1);
//            }
//        }).start();
//    }
}
