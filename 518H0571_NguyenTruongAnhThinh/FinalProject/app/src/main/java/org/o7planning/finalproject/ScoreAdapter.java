package org.o7planning.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ScoreAdapter extends BaseAdapter {
    private ArrayList<user_score_list> scorelist;
    private Context context;

    public ScoreAdapter(ArrayList<user_score_list> list, Context cont){
        this.scorelist = list;
        this.context = cont;

    }

    @Override
    public int getCount() {
        return this.scorelist.size();
    }

    @Override
    public Object getItem(int position) {
        return this.scorelist.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.score_custom, null);

            holder = new ScoreAdapter.ViewHolder();
            holder.user = (TextView)convertView.findViewById(R.id.namescore);
            holder.type = (TextView)convertView.findViewById(R.id.typesocre);
            holder.score1 = (TextView)convertView.findViewById(R.id.score);
            convertView.setTag(holder);
        }
        else {
            holder = (ScoreAdapter.ViewHolder)convertView.getTag();
        }

        user_score_list stu = scorelist.get(position);
        holder.user.setText(stu.getUser());
        holder.type.setText(stu.getType());
        holder.score1.setText(""+stu.getScore());
        return convertView;
    }

    private static class ViewHolder{
        private TextView user;
        private TextView type;
        private TextView score1;
    }

}
