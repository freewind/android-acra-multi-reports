package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MyActivity extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    private static class MyTask extends AsyncTask<Void, Void, Void> {
        static int i;

        @Override
        protected Void doInBackground(Void... params) {
            try {
                int current = i++;
                Thread.sleep(1000);
                throw new RuntimeException("test exception from task " + current);
            } catch (InterruptedException e) {
                //
            }
            return null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (int i = 0; i < 10; i++) {
            new MyTask().execute();
        }
    }

    public void toNext(View v) {
        Intent intent = new Intent(this, MyActivity2.class);
        startActivityForResult(intent, 0);
    }

}
