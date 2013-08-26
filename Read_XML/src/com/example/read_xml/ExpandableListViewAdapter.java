package com.example.read_xml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

	private Context context=null;
	private String[] groupStrings=null;
	public ExpandableListViewAdapter(Context context,String[]groupStrings)
	{
		this.context=context;
		this.groupStrings=groupStrings;
	}
	
	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groupStrings.length;
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}


	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		// TODO Auto-generated method stub
		return new TextView(context);
	}
	
	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		// TODO Auto-generated method stub
		View view=null;
		if (arg2==null) {
			LayoutInflater layoutInflater=LayoutInflater.from(context);
			view=layoutInflater.inflate(R.layout.team_item, null);
		}
		else {
			view=arg2;
		}
		return view;
	}

}
