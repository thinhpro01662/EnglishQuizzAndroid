package org.o7planning.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class QuesAdapter extends BaseAdapter {

        private ArrayList<QuestList> question;
        private Context context;

        public QuesAdapter(ArrayList<QuestList> list, Context cont){
            this.question = list;
            this.context = cont;

        }

        @Override
        public int getCount() {
            return this.question.size();
        }

        @Override
        public Object getItem(int position) {
            return this.question.get(position);
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
                convertView = inf.inflate(R.layout.custom_test, null);

                holder = new ViewHolder();
                holder.ques = (TextView)convertView.findViewById(R.id.testquestion);
                holder.an1 = (TextView)convertView.findViewById(R.id.radioButton);
                holder.an2 = (TextView)convertView.findViewById(R.id.radioButton2);
                holder.an3 = (TextView)convertView.findViewById(R.id.radioButton3);
                holder.an4 = (TextView)convertView.findViewById(R.id.radioButton4);

                convertView.setTag(holder);
            }
            else {
                holder = (ViewHolder)convertView.getTag();
            }

            QuestList stu = question.get(position);
            holder.ques.setText(stu.getQues());
            holder.an1.setText(stu.getAn1());
            holder.an2.setText(stu.getAn2());
            holder.an3.setText(stu.getAn3());
            holder.an4.setText(stu.getAn4());
            return convertView;
        }

        private static class ViewHolder{
            private TextView ques;
            private TextView an1;
            private TextView an2;
            private TextView an3;
            private TextView an4;
        }

}

