package com.theocean.lamcong;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;


import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NhanvienActivity extends Activity
{
	Button btnxong;
	Button btnthem;
	EditText edtennv;
	ListView lvtennv;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhanvien);
	    final ArrayList tennhanvien =new ArrayList();
	
		anhxa();
		
	
		final SharedPreferences luuthongtin = getSharedPreferences("bonho", Context.MODE_PRIVATE);
	    final SharedPreferences.Editor editor = luuthongtin.edit();
	    
		int sonhanvien = luuthongtin.getInt("sonhanvien",-1);
		for(int i = sonhanvien;i >= 0; i--){
			tennhanvien.add(luuthongtin.getString("tennhanvien"+i,""));
		}
		
		
		
		final ArrayAdapter adnhanvien = new ArrayAdapter(
			NhanvienActivity.this,
			android.R.layout.simple_list_item_1,
			tennhanvien);
		lvtennv.setAdapter(adnhanvien);
		
		btnthem.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View view)
				{
					String strname = edtennv.getText().toString();
					
					
					
					tennhanvien.add(strname);
					edtennv.setText("");
					adnhanvien.notifyDataSetChanged();
					return;
				}
			});
		// bat su kien long click va xoa ten nhan vien khoi shareprefences
		lvtennv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

				@Override
				public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
											   int pos, long id)
				{
					// TODO 
					
					tennhanvien.remove(pos);
					adnhanvien.notifyDataSetChanged();

					return true;
				}
			});


		btnxong.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View view)
				{//can sua lai ten bien thu hai cua intent
					
					editor.clear();
					int numberofloop = tennhanvien.size() - 1;
					editor.putInt("sonhanvien",numberofloop);
					editor.apply();
					for(int i =numberofloop;i>=0;i--){
						editor.putString("tennhanvien"+i,(String)tennhanvien.get(i));
						
						editor.apply();
					}
					
				
				
				
					Intent intent = new Intent(NhanvienActivity.this , PickdateActivity.class);
					startActivity(intent);
					return;
				}

			});
		return;
	}
	public void anhxa()
	{
		lvtennv = (ListView)findViewById(R.id.lvten);
		btnxong = (Button)findViewById(R.id.btnxong);
		btnthem = (Button)findViewById(R.id.btnthem);
		edtennv = (EditText)findViewById(R.id.txtnhanten);
		return;
	}
	
	
	
}
