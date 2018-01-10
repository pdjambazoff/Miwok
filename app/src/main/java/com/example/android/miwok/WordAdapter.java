package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Beast on 1/7/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColorResourceId;
    public WordAdapter(Activity context, ArrayList<Word> wordList, int category_colors) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, wordList);
        mColorResourceId = category_colors;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    //Colors: numbers: "#FD8E09", family: "#"
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWords = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView mWord = (TextView) listItemView.findViewById(R.id.word_one_mk);

        // set this text on the name TextView
        mWord.setText(currentWords.getMiwokWord());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView eWord = (TextView) listItemView.findViewById(R.id.word_one_eng);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        eWord.setText(currentWords.getTranslation());


        //Find the ImageView in the list_item.xml
        ImageView imgWord = (ImageView) listItemView.findViewById(R.id.image_word);
        if(currentWords.hasImage()) {
            // Get the version number from the current Word object and
            // set this image on the number TextView
            imgWord.setImageResource(currentWords.getImageRosourceID());
            imgWord.setBackgroundColor(Color.parseColor("#FFF7DA"));
        }
        else {
            imgWord.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews )
        // so that it can be shown in the ListView
        return listItemView;
    }
}
