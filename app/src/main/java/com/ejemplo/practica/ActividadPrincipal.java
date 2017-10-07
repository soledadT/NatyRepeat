package com.ejemplo.practica;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.practica.R;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


public class ActividadPrincipal extends Activity {

	 ArrayList<String> test ;
     Bundle show ;
     private static ArrayList<ContenidoItem> nombreArrayList = new ArrayList<ContenidoItem>();
     int entrada = 0;
     MediaPlayer player = new MediaPlayer();
     private static List<String> list = new ArrayList<String>();
     int i = 0;
	 int a= 0;
	 private static int  CurrentSong=0;
	 private static int  contador=0;
	   
@Override  
protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.actividad_principal); 
        Context contexto = this;
        int contador = 0;
     

        Intent show2 = getIntent();
        show = getIntent().getExtras();
        
        test = show2.getStringArrayListExtra("EXTRA_NOMBRE");
   
        // si no se elegieron canciones en la segunda pantalla
        if (show == null) {
        	TextView mensajeInicial;
            mensajeInicial=(TextView)findViewById(R.id.textView2);
        	mensajeInicial.setText("Seleccione Canciones");
        	
        } else{
        	
        	 while (contador < test.size() )
             {
             	 ContenidoItem uno = new ContenidoItem(test.get(contador).toString(),contexto);
             	 nombreArrayList.add(uno);
             	 contador = contador + 1;
             }
        	
        	
        	
        	
      		  final TextView tv;
              
              tv=(TextView)findViewById(R.id.textView1);
              
              final ListView lv1 =(ListView)findViewById(R.id.listView1);  
              
             
              final AdaptadorItem adaptador = new AdaptadorItem  (this,nombreArrayList);
              
              
              lv1.setAdapter(adaptador);
              
              
          
          }
       }


    
 public void repetir(View view) {
	 
	  MediaPlay();
	
 };
 

 
 

 public void lanzar(View view) {
Intent i = new Intent(this, AgregarCancion.class );
startActivity(i);
}  
 
 
 public void MediaPlay(){
	
 	 
	 boolean a;
	 int b;
	 int c;
	 
	 a= player.isPlaying();
	 b=CurrentSong;
	 a= player.isPlaying();
	 c=nombreArrayList.size();
	 
	 
	 if (contador == 0){
		 contador = Integer.parseInt(nombreArrayList.get(CurrentSong).getContador());
	 }
	 
     if(!player.isPlaying() && CurrentSong <= nombreArrayList.size())
     {
        player.reset();
         try{
        	  
        	 if (contador <= Integer.parseInt(nombreArrayList.get(CurrentSong).getContador())){
               
               player.setDataSource(Environment.getExternalStorageDirectory().getPath() + "/Music/" + nombreArrayList.get(CurrentSong).getTitulo()
            		   
            		   
            		   );
               player.prepare();
               int length = player.getDuration();
               player.start();
               contador --;
               
               if (contador == 0){
                  if(CurrentSong < nombreArrayList.size())
                  {
                    CurrentSong ++;   
                  }
               }

             }
         }
         catch(Exception err)
         {
             @SuppressWarnings("unused")
             String error = err.getMessage();
         }

         player.setOnCompletionListener(completionListener);

     }
 }

     OnCompletionListener completionListener = new OnCompletionListener(){

     @Override
     public void onCompletion(MediaPlayer mp) {
         if(CurrentSong < nombreArrayList.size())
         {
             MediaPlay();
         }

     }

  };

    
 }



   
    
      
       

	

