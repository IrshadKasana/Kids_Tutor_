package java.com.example.kidstutor;

/**
 * Created by Irshad Kasana on 7/16/2020.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.core.content.ContextCompat;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourseid;
    public WordAdapter(Context context, ArrayList<Word> words,int colorResourseId) {
        super(context, 0, words);
        mColorResourseid=colorResourseId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position,convertView,parent);
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        }
        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getmMiwoktranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getmDefaulttranslation());

        ImageView imageView=(ImageView)listItemView.findViewById(R.id.image_view);
        if (currentWord.hasImage()){
            imageView.setImageResource(currentWord.getmResourseId());}
        else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer =listItemView.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),mColorResourseid);
        textContainer.setBackgroundColor(color);

        return listItemView;


    }
}
