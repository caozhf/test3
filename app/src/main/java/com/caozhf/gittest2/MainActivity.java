package com.caozhf.gittest2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String[] arr = new String[]{"a","b","c"};
    private Button Dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arr);
        spinner.setAdapter(adapter);
    }

    private void initView() {
        spinner = (Spinner) findViewById(R.id.spinner);
    }

    public void PopMenu(View view){
        View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.menu_i, null, false);
        Button btn1 = view1.findViewById(R.id.btn1);
        Button btn2 = view1.findViewById(R.id.btn2);
        PopupWindow popw = new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT,true);
        popw.setTouchable(true);
        popw.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popw.showAsDropDown(view,100,0);
    }

    public void Dialog(View view){
        registerForContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.my_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit){
            Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
        }if(item.getItemId() == R.id.share){
            Toast.makeText(MainActivity.this,"2",Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
