package com.example.read_xml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.read_xml.entity.Group;
import com.example.read_xml.entity.GroupHolder;

public class EuropeCupExpandableListViewAdapter extends
		BaseExpandableListAdapter {

	private Context context = null;
	private Group group = null;

	public EuropeCupExpandableListViewAdapter(Context context, Group group) {
		this.context = context;
		this.group = group;
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		String teamName = group.getTeams().get(arg1).getName();
		return group.findGamesByTeamName(teamName).get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return arg0 * 100 + arg1;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		String teamName = group.getTeams().get(arg0).getName();
		return group.findGamesByTeamName(teamName).size();
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return group.getTeams().get(arg0);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return group.getTeams().size();
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

		TextView textView = new TextView(context);
		textView.setText("Games..");
		return textView;
	}


	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		// TODO Auto-generated method stub
		View view = arg2;
		GroupHolder groupHolder = null;
		if (view == null) {
			LayoutInflater layoutInflater = LayoutInflater.from(context);
			view = layoutInflater.inflate(R.layout.team_item, null);

			groupHolder = new GroupHolder();
			groupHolder.team_A = (TextView) view.findViewById(R.id.team_A);
			groupHolder.team_D = (TextView) view.findViewById(R.id.team_D);
			groupHolder.team_F = (TextView) view.findViewById(R.id.team_F);
			groupHolder.team_L = (TextView) view.findViewById(R.id.team_L);
			groupHolder.team_order = (TextView) view
					.findViewById(R.id.team_order);
			groupHolder.team_Pts = (TextView) view.findViewById(R.id.team_Pts);
			groupHolder.team_W = (TextView) view.findViewById(R.id.team_W);
			groupHolder.team_icon = (ImageView) view
					.findViewById(R.id.team_icon);
			view.setTag(groupHolder);
		} else {
			groupHolder = (GroupHolder) view.getTag();
		}
		groupHolder.team_A.setText(group.getTeams().get(arg0).getA());
		groupHolder.team_D.setText(group.getTeams().get(arg0).getD());
		groupHolder.team_F.setText(group.getTeams().get(arg0).getF());
		groupHolder.team_L.setText(group.getTeams().get(arg0).getL());
		groupHolder.team_order.setText(arg0 + 1 + "");
		groupHolder.team_Pts.setText(group.getTeams().get(arg0).getPts());
		groupHolder.team_W.setText(group.getTeams().get(arg0).getW());

		int imgId = context.getResources().getIdentifier(
				group.getTeams().get(arg0).getName().toLowerCase(), "drawable",
				context.getPackageName());

		groupHolder.team_icon.setBackgroundResource(imgId);

		return view;
	}
}
