package icesi.i2t.imagenesytexto;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ImageView galeria;
    int contador=1;
    int[] array_imagenes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        galeria = (ImageView) findViewById(R.id.galeria);
        array_imagenes = new int[]{R.drawable.foto1, R.drawable.foto2
                                    , R.drawable.foto3, R.drawable.foto4, R.drawable.foto5};

        //Poner listener de toque
        galeria.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText(getApplicationContext(), "Tap", Toast.LENGTH_SHORT).show();
                galeria.animate().setDuration(500).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        //Es la acción que ocurre luego del fading
                        galeria.setBackgroundResource(array_imagenes[contador]);
                        contador++;
                        if(contador == 5) contador=0;
                        galeria.animate().alpha(1).setDuration(500);
                    }
                });
                return false;
            }
        });
        

        int foto1 = R.drawable.foto1;
        galeria.setBackgroundResource(foto1);

    }


}
