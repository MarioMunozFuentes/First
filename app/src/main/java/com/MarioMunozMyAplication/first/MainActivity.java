package com.MarioMunozMyAplication.first;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

/**
 * @author MarioMuñozFuentes
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting a la vista que aplicamos un menu contextual
        //y la registramos
        TextView mycontent= (TextView) findViewById(R.id.textTap);
        registerForContextMenu(mycontent);
    }

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
                    .make(mLayaut, "fancy a Snac while you refres?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1= Snackbar.make(mLayaut, "Action is restored!", Snackbar.LENGTH_LONG);
                            snackbar1.show();
                        }
                    });
                snackbar.show();


            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Item downloed", Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
