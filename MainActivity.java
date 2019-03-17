package net.mysirg.listvwithimage;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] mtitles;
    String[] mdescription;
    int[] images ={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,
            R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9,R.drawable.pic10};

    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
       mtitles= res.getStringArray(R.array.titles);
      mdescription=   res.getStringArray(R.array.description);

        listView =(ListView)findViewById(R.id.listview);

        vivzAdapter adapter = new vivzAdapter(this,mtitles,images,mdescription);
        listView.setAdapter(adapter);



    }

    class  vivzAdapter extends  ArrayAdapter<String>{

        int[] imagess;
        String[] titleArray;
        String[] desc;

        public vivzAdapter(Context context, String[] titles, int[] imgs, String[] descriptionn)
        {
            super(context,R.layout.row_layout,R.id.textview1,titles);
            this.imagess=imgs;
            this.titleArray=titles;
            this.desc = descriptionn;


        }


        class MyviewHolder {


            ImageView myimage;
            TextView myTitle;
            TextView mydescription;

            public MyviewHolder(View v) {

                myimage = (ImageView)v.findViewById(R.id.imageview);

                myTitle =(TextView)v.findViewById(R.id.textview1);
                mydescription =(TextView)v.findViewById(R.id.textview2);

            }


        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            MyviewHolder holder = null;
            if (row==null) {

                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                 row = inflater.inflate(R.layout.row_layout, parent, false);
                 holder= new MyviewHolder(row);
                 row.setTag(holder);
                Log.d("vivz","Creating a new row");

            }else {

                holder = (MyviewHolder) row.getTag();
                Log.d("vivz","Recycling stuff");
            }


            holder.myimage.setImageResource(imagess[position]);
            holder.myTitle.setText(titleArray [position]);
            holder.mydescription.setText(desc[position]);
            return row;


        }
    }
}
