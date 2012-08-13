package com.tomprice.helloworld;

import java.util.Date;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	Button btn;
	ProgressBar progBar;

	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button1);
        progBar = (ProgressBar)findViewById(R.id.progressBar1);
    }

    /*
     * (non-Javadoc)
     * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    /*
     * Start an AsyncTask. Sleep for 5 secs and update the
     * button text
     */
    public void runAsyncTask(View theButton) {
    	new TestAsyncTask().execute();
    }
    
    private class TestAsyncTask extends AsyncTask<Void, Void, Void> {

    	/*
    	 * (non-Javadoc)
    	 * @see android.os.AsyncTask#onPreExecute()
    	 */
    	protected void onPreExecute() {
    		// TODO: show the progress bar
        	btn.setText(new Date().toString());
        	btn.setEnabled(false);
    		progBar.setVisibility(View.VISIBLE);
    		
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see android.os.AsyncTask#doInBackground(Params[])
    	 */
    	@Override
    	protected Void doInBackground(Void... params) {
    		try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		return null;
    	}
    	
    	/*
    	 * (non-Javadoc)
    	 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
    	 */
    	protected void onPostExecute(Void result) {
    		// TODO: hide the progress bar
    		progBar.setVisibility(View.INVISIBLE);
    		btn.setEnabled(true);
    	}
    	
    }
}
