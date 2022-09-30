package com.example.invictus_shubham;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class AdapterClassForListing extends RecyclerView.Adapter<AdapterClassForListing.ViewHolderClass>{

    //Making RecyclerView Clickable
    private OnRecyclerViewClickListener listener;
    public interface OnRecyclerViewClickListener
    {
        void onItemClick(int position);
    }

    public void OnRecyclerViewClickListener(OnRecyclerViewClickListener listener)
    {
        this.listener = listener;
    }

    //Constructor to accept the data
    public String[] books, authors;
    public int[] images;
    public AdapterClassForListing(String[] books, String[] authors, int[] images)
    {
        this.books = books;
        this.authors = authors;
        this.images = images;
    }

    //3 Methods of the AdapterClass
    @NonNull
    @NotNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType)
    {
        //LayoutInflater to create views
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listing_layout, parent, false);
        //The small layout made for each view is passed kin the ViewHolder
        return new ViewHolderClass(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterClassForListing.ViewHolderClass holder, int position)
    {
        //Binding the data with the ViewHolder
        String titleText = books[position];
        String authorText = authors[position];
        int imageResource = images[position];

        holder.textPart.setText(titleText);
        holder.subTextPart.setText(authorText);
        holder.imagePart.setImageResource(imageResource);
    }

    @Override
    public int getItemCount()
    {
        //Getting the Count of 'the amount of Data given'
        return books.length;
    }

    //ViewHolderClass created inside the AdapterClass
    public static class ViewHolderClass extends RecyclerView.ViewHolder{

        //Objects created to assign the IDs of the Items present in the small Layout made for the Views
        ImageView imagePart;
        TextView textPart;
        TextView subTextPart;
        Button button;

        //Constructor of the ViewHolderClass
        public ViewHolderClass(@NonNull @org.jetbrains.annotations.NotNull View itemView, OnRecyclerViewClickListener listener) {
            super(itemView);
            imagePart = itemView.findViewById(R.id.image);
            textPart = itemView.findViewById(R.id.text);
            subTextPart = itemView.findViewById(R.id.subText);
            button = itemView.findViewById(R.id.button);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null && getAdapterPosition()!=RecyclerView.NO_POSITION)
                    {
                        listener.onItemClick(getAdapterPosition());
                    }
                }
            });
        }
    }
}
