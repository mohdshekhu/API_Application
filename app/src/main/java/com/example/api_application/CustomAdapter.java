package com.example.api_application;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private JSONArray localDataSet;
    Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView user_id;
        private final TextView id;
        private final TextView body;
        private final TextView title;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            user_id = (TextView) view.findViewById(R.id.user_id);
            id=(TextView) view.findViewById(R.id.id);
            body=(TextView) view.findViewById(R.id.body);
            title=(TextView) view.findViewById(R.id.title);
        }



        public TextView getUser_id() {
            return user_id;
        }

        public TextView getId() {
            return id;
        }

        public TextView getBody() {
            return body;
        }

        public TextView getTitle() {
            return title;
        }
    }


//step 1
    // Initialize the dataset of the Adapter.
    public CustomAdapter(JSONArray dataSet) {
        localDataSet = dataSet;
    }


// step 2
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }



//step 3
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        try {
            JSONObject jsonObject=localDataSet.getJSONObject(position);
            viewHolder.getUser_id().setText("USER_ID :-  "+jsonObject.getString("userId"));
            viewHolder.getId().setText("ID :-  "+jsonObject.getString("id"));
            viewHolder.getTitle().setText("TITLE :-  "+jsonObject.getString("title"));
            viewHolder.getBody().setText("BODY :-  "+jsonObject.getString("body"));

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "Something went Wrong", Toast.LENGTH_SHORT).show();
        }
//        viewHolder.getTextView().setText(localDataSet[position]);
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.length();
    }
}

