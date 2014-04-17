package com.maple.scheduleraw.View;


import java.util.List;

import com.maple.scheduleraw.R;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class IndexPeriodAdapter extends ArrayAdapter<String> {
    private Context        context;
    private List<String>   list;
    private LayoutInflater inflater;

    public IndexPeriodAdapter(Context context, int layoutId, List<String> list) {
        super(context, layoutId, list);
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null)
            view = inflater.inflate(R.layout.period_list_adapter, parent, false);
        else
            view = convertView;

        TextView tv;
        tv = (TextView) view.findViewById(R.id.tv_index_period);
        tv.setText(list.get(position));
//        tv.setBackgroundColor(position < Settings.NUMBER_OF_PERIOD / 2 ?
//                context.getResources().getColor(R.color.morning_color) :
//                context.getResources().getColor(R.color.afternoon_color));
        tv.setTextColor(position < 10 / 2 ?
                Color.BLUE :
                Color.RED);
        return view;
    }
}