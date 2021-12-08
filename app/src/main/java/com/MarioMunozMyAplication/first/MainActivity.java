package com.MarioMunozMyAplication.first;

import android.content.DialogInterface;
import android.content.Intent;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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

        //casting a la vista que aplicamos un menu contextual y la registramos
        //TextView mycontent= (TextView) findViewById(R.id.textTap);
        //registerForContextMenu(mycontent);

        //Referenciamos al WebView con su ID, creado anteriormente (private WebView miVisorWeb)
        miVisorWeb= (WebView) findViewById(R.id.vistaWeb);
        registerForContextMenu(miVisorWeb);

        //encima del WebView(xml) tenemos lo que hace refresh
        //mOnRefreshListener es un metodo qe va a refrescar sacando un toast...
        swipeLayout= findViewById(R.id.mainswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        //cargar una imagen desde una pagina web externa
        miVisorWeb.getSettings().setBuiltInZoomControls(true); //se puede hacer zoom a la imagen
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com"); //se dice desde que url vienen proporcionadas las imagenes
    }

    //---------------------- METODO REFRESH --------------------
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

    //AQUI CREAMOS EL MENU CONTEXTUAL QUE TIENE "COPY" Y "DOWNLOAD" Y "NEW"
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    //
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // ITEM COPY
            case R.id.item1:
                /* Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
                toast.show();
                return true; sacan un mensaje*/
                ConstraintLayout mLayaut= findViewById(R.id.myMainConstraint);
                Snackbar snackbar= Snackbar
                    .make(mLayaut, "fancy a Snac while you refres?", Snackbar.LENGTH_SHORT) //si pinchamsoe en copy aparece este mensaje
                    .setAction("DESHACER", new View.OnClickListener() { //a la derecha del mensaje anterior aparece esto
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1= Snackbar.make(mLayaut, "Action is restored!", Snackbar.LENGTH_LONG);
                            snackbar1.show();
                        }
                    });
                snackbar.show();
                return true;

            //ITEM DOWNLOAD
            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Item downloed", Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    // ------------------ MENU MAIN ---------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // ---------------- MENU AL PULSAR SOBRE EL DESPLEGABLE Y LUEGO AL SING OUT
    public void showAlertDialogButtonClicked(MainActivity MainActivity){
        MaterialAlertDialogBuilder builder= new MaterialAlertDialogBuilder(this);
        //el dialogo estandar tiene el titulo/icono pero podemos sustituirlo con un xml
        builder.setTitle("Achtung!"); //Titulo que aparece
        builder.setMessage("Where do you go?"); //Mensaje de a continuacion del titulo
        builder.setIcon(R.drawable.usericon); //Icono que aparece a la izquierda del titulo
        builder.setCancelable(false);
        // un XML a medida para el diálogo
        //builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        //add the buttons
        builder.setPositiveButton("SignUp", new DialogInterface.OnClickListener() {
        @Override
            public void onClick(DialogInterface dialog, int which){
            // do something like...
            Intent intent = new Intent(MainActivity.this, SingUp.class);
            startActivity(intent);
            dialog.dismiss();
        }
        });
        builder.setNeutralButton("Other", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                dialog.dismiss();
            }
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    //dependiendo de cual elijamos al pulsar en un icono y otro, nos sacara un mensaje y otro
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.lupa) { //referenciamos a la "lupa" del menu_main, es decir, a como hemos llamado a la lupa de id.
        //showAlertDialogButtonClicked(Main.this);
            Toast toast = Toast.makeText(this, "Buscar", Toast.LENGTH_LONG); //elegimos el mensae que aparece
            toast.show();
        }
        if (id == R.id.tuerca) {
            Toast toast = Toast.makeText(this, "Ajustes", Toast.LENGTH_LONG);
            toast.show();
        }
        if (id == R.id.singout) {
            showAlertDialogButtonClicked(MainActivity.this); //si pulsamos sobre singup nos aparece el dialogo de alerta
        }
        return super.onOptionsItemSelected(item);
    }

}
