package com.example.brand_000.battech;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Tejrai on 2017-04-07.
 */

public class FileAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private ArrayList<File> fileArrayList;

    public FileAdapter(Context context, int layout, FileList fileArrayList) {
        this.context = context;
        this.layout = layout;
        this.fileArrayList = fileArrayList;
    }
    @Override
    public int getCount() {
        return fileArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return fileArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        ImageView imageView;
        TextView txtdescription;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = new ViewHolder();

        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);

            holder.txtdescription = (TextView) row.findViewById(R.id.textdesc);
            holder.imageView = (ImageView)row.findViewById(R.id.imgItem);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        File file = fileArrayList.get(position);

        holder.txtdescription.setText(file.getDescription);
        byte[] imgFile = file.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(imgFile, 0, imgFile.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }

}
