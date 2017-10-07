																																											package com.ejemplo.practica;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.practica.R;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class AgregarCancion extends Activity {
	
	public static String EXTRA_NOMBRE = "" ;
	private EditText et;
	
	public static  List<String> listaCanciones;
	
	 public  ArrayList<String> test = new ArrayList<String>();
	 private ListView lv;
	   
	    private String listview_array[] = { "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN" };
	    private ArrayList<String> array_sort = new ArrayList<String>();
	    int textlength = 0;
	    
	 @Override  
	    protected void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        et = (EditText) findViewById(R.id.EditText01);
	        setContentView(R.layout.agregar_cancion); 
	        
	        
	        // Array TEXTO donde guardaremos los nombres de los ficheros
	        final List<String> item = new ArrayList<String>();
	 
	        //Defino la ruta donde busco los ficheros
	        File f = new File(Environment.getExternalStorageDirectory() + "/Music/");
	        //Creo el array de tipo File con el contenido de la carpeta
	        File[] files = f.listFiles();
	 
	        //Hacemos un Loop por cada fichero para extraer el nombre de cada uno
	        for (int i = 0; i < files.length; i++)
	 
	        {
	            //Sacamos del array files un fichero
	            File file = files[i];
	 
	            //Si es directorio...
	            if (file.isDirectory())
	 
	                item.add(file.getName() + "/");
	 
	            //Si es fichero...
	            else
	 
	                item.add(file.getName());
	        }
	        
	        //Localizamos y llenamos la lista con el array
	        ListView lstOpciones = (ListView) findViewById(R.id.listView1);
	        ArrayAdapter<String> fileList = new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_multiple_choice, item);
	        lstOpciones.setAdapter(fileList);
	        lstOpciones.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	        
	       
	        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	        	
        	public void onItemClick(AdapterView<?> arg0, View v,final int position,long arg3) {
        	 
        		 //  SELECCION DEL ITEM (OPCION)
                String Seleccion= arg0.getItemAtPosition(position).toString();
                 test.add(Seleccion);
    
             
        	}
        	
        	});
 
	        
	        et.addTextChangedListener(new TextWatcher() {
	            public void afterTextChanged(Editable s) {
	                // Abstract Method of TextWatcher Interface.
	            }
	 
	            public void beforeTextChanged(CharSequence s, int start, int count,
	                    int after) {
	                // Abstract Method of TextWatcher Interface.
	            }
	 
	            public void onTextChanged(CharSequence s, int start, int before, int count) {
	                textlength = et.getText().length();
	                array_sort.clear();
	                 
	                for (int i = 0; i < item.size(); i++) {
	                    if (textlength <= item.get(i).length()) {
	                        if (et.getText().toString().equalsIgnoreCase((String) item.get(i).subSequence(0, textlength))) {
	                            array_sort.add(item.get(i));
	                        }
	                    }
	                }
	                 
	                lv.setAdapter(new ArrayAdapter<String>(AgregarCancion.this, android.R.layout.simple_list_item_1,  item));
	            }
	        });
	        
	        
	  }
	 
	   public void volver(View view) {
		   
	        Intent i = new Intent(this, ActividadPrincipal.class );
	        
	        i.putStringArrayListExtra("EXTRA_NOMBRE", (ArrayList<String>) test);
	        
	        startActivity(i);
	  } 
}
