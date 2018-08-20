package com.example.brand_000.battech;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Tejrai on 2017-04-07.
 */

public class FileList extends AppCompatActivity{
    GridView gridView;
    ArrayList<File> list;
    FileAdapter adapter = null;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_list);

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new FileAdapter(this, R.layout.file_item,FileList.this);
        gridView.setAdapter(adapter);

        //GET THE DATA FROM SQLITE
        Cursor cursor = FileActivity.sqLiteHelper.getData("SELECT * FROM FILE");
        list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String desc = cursor.getString(1);
            byte[] image = cursor.getBlob(2);

            list.add(new File(id,desc,image));
        }

        adapter.notifyDataSetChanged();

    }
}
