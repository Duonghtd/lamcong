package com.theocean.lamcong;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class PickdateActivity extends Activity
{

	Button btnxong ;
	EditText edsongay ;
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickdate);

		anhxa();
		
		btnxong.setOnClickListener(new View.OnClickListener(){
			    @Override
				public void onClick(View view)
				{
					int songaymotthang = Integer.parseInt(edsongay.getText().toString());

					Intent intent = new Intent(PickdateActivity.this , NhanvienActivity.class);
					Bundle bundle = new Bundle();
					//sap xep cac loai hang
					bundle.putBoolean("",true);
					
					bundle.putInt("laysongay", songaymotthang);
					intent.putExtras(bundle);
					startActivity(intent);
					



					return;
				}

			});
		return;
	}
	public void anhxa()
	{
		btnxong = (Button) findViewById(R.id.xong);
		edsongay = (EditText) findViewById(R.id.edsongay);
		return;
	}
}
