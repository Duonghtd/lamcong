package com.theocean.lamcong;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import java.io.*;


public class MainActivity extends Activity
{

	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Button btnnew = (Button) findViewById(R.id.btnmknew);

		btnnew.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View view)
				{
					Intent intent = new Intent(MainActivity.this , PickdateActivity.class);
					startActivity(intent);
					return;
				}

			});
		return;
	}
}

