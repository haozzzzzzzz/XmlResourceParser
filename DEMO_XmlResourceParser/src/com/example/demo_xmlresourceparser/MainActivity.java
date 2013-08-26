package com.example.demo_xmlresourceparser;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView myTextView=null;
	private Button myButton=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myTextView=(TextView) findViewById(R.id.textview1);
		myButton=(Button) findViewById(R.id.button1);
		
		myButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				int counter=0;
				
				Resources resources=getResources();
				XmlResourceParser xml=resources.getXml(R.xml.test);
				
				//转成字符串显示到TextView
				StringBuilder stringBuilder=new StringBuilder();
				
				try {
					while(xml.getEventType()!=XmlResourceParser.END_DOCUMENT)
					{
						if (xml.getEventType()==XmlResourceParser.START_TAG) {
							String name=xml.getName();
							if (name.equals("customer")) {
								counter++;
								
								
								stringBuilder.append("第"+counter+"条用户信息\n");
								stringBuilder.append("name : "+xml.getAttributeValue(0)+"\n");
								stringBuilder.append("age : "+xml.getAttributeValue(1)+"\n");
								stringBuilder.append("gender : "+xml.getAttributeValue(2)+"\n");
								stringBuilder.append("email : "+xml.getAttributeValue(3)+"\n");
							}
						}
						xml.next();
					}
					
					myTextView.setText(stringBuilder);
				} catch (XmlPullParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
