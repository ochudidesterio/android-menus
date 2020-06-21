package com.example.menue;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    androidx.appcompat.view.ActionMode mActionMode;
    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.action_menu_context,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.actionMode1:
                    Toast.makeText(MainActivity.this,"action mode 1", Toast.LENGTH_LONG).show();
                    mode.finish();
                    return true;
                case R.id.actionMode2:
                    Toast.makeText(MainActivity.this,"action mode 2", Toast.LENGTH_LONG).show();
                    mode.finish();
                    return true;
                case R.id.actionMode3:
                    Toast.makeText(MainActivity.this,"action mode 3", Toast.LENGTH_LONG).show();
                    mode.finish();
                    return true;
                default:
                    return false;

            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView);
        this.registerForContextMenu(textView);
        Button button = (Button)findViewById(R.id.buttonAction);
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mActionMode != null){
                return false;
                }
                mActionMode = startSupportActionMode((androidx.appcompat.view.ActionMode.Callback) mActionModeCallback);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItem1:
                Toast.makeText(this,"menu item 1 selected",Toast.LENGTH_LONG).show();
                return  true;
            case R.id.menuItem2:
                Toast.makeText(this,"menu item 2 selected",Toast.LENGTH_LONG).show();
                return  true;
            case R.id.menuItem3:
                Toast.makeText(this,"menu item 3 selected",Toast.LENGTH_LONG).show();
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floating_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.contextItem1:
                Toast.makeText(this,"context 1 selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.contextItem2:
                Toast.makeText(this,"context 2 selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.contextItem3:
                Toast.makeText(this,"context 3 selected",Toast.LENGTH_LONG).show();
                return true;
        }
            return super.onContextItemSelected(item);
    }
}
