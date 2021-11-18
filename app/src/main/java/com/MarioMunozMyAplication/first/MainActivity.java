package com.MarioMunozMyAplication.first;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.snackbar.Snackbar;

/**
 * @author MarioMuñozFuentes
 */
public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting a la vista que aplicamos un menu contextual
        //y la registramos
        //TextView mycontent= (TextView) findViewById(R.id.textTap);
        //registerForContextMenu(mycontent);


        swipeLayout= findViewById(R.id.mainswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        miVisorWeb= (WebView) findViewById(R.id.vistaWeb);
        //registerForContextMenu(miVisorWeb);

        miVisorWeb.getSettings().setBuiltInZoomControls(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com");
    }

    protected SwipeRefreshLayout.OnRefreshListener
        mOnRefreshListener= new SwipeRefreshLayout.OnRefreshListener(){
        @Override
        public void onRefresh(){
            Toast toast0= Toast.makeText(MainActivity.this, "Hi there!! I don`t exist :)", Toast.LENGTH_LONG);
            toast0.show();

            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                /* Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
                toast.show();
                return true; sacan un mensaje*/
                ConstraintLayout mLayaut= findViewById(R.id.myMainConstraint);
                Snackbar snackbar= Snackbar
                    .make(mLayaut, "fancy a Snac while you refres?", Snackbar.LENGTH_SHORT)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1= Snackbar.make(mLayaut, "Action is restored!", Snackbar.LENGTH_LONG);
                            snackbar1.show();
                        }
                    });
                snackbar.show();
                return true;


            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Item downloed", Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();

        if (id == R.id.camera){
            Toast toast= Toast.makeText(this, "Infecting", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id== R.id.action_settings){
            Toast toast= Toast.makeText(this, "Fixing", Toast.LENGTH_LONG);
        }
        return super.onOptionsItemSelected(item);
    }
}
