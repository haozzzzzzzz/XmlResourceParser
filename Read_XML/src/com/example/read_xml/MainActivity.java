package com.example.read_xml;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.Toast;

import com.example.read_xml.data.XMLParser2;
import com.example.read_xml.entity.Europe2012;

public class MainActivity extends Activity {

	private EuropeCupExpandableListViewAdapter adapter=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		XMLParser2 xmlParser=XMLParser2.getInstance(this);
		Europe2012 europe2012=xmlParser.getEurope2012();
		
		// 创建ExpandableListViewAdapter
		adapter=new EuropeCupExpandableListViewAdapter(this, europe2012.getGroups().get(0));
		
		ExpandableListView expandableListView=(ExpandableListView) findViewById(R.id.expandableListView);
		
		//将ExpandableListViewAdapter传入ExpandableListView
		expandableListView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
