package com.ejemplo.practica;

import java.util.ArrayList;

import com.example.practica.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdaptadorItem extends ArrayAdapter<ContenidoItem> {
	ArrayList<ContenidoItem> datos;
	
			 
	 public AdaptadorItem(Context context, ArrayList<ContenidoItem> datos) {
	        super(context, R.layout.lista_item_cancion, datos);
	        this.datos= datos;
	        
	       
	    }
	 
	

		public View getView(final int position, View convertView, ViewGroup parent) {
	    	//Obteniendo una instancia del inflater
	        //LayoutInflater inflater = (LayoutInflater)getContext()
	                //.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        
	        LayoutInflater inflater = LayoutInflater.from(getContext());
	        View listItemView = inflater.inflate(R.layout.lista_item_cancion, null);
	        
	        
	        
	       
	        @SuppressWarnings("unused")
			ContenidoItem item = (ContenidoItem)getItem(position);
	        
	        TextView lblTitulo = (TextView)listItemView .findViewById(R.id.txtLabel);
	        lblTitulo.setText(datos.get(position).getTitulo());
	         
	        
	        final TextView natalia = (TextView)listItemView .findViewById(R.id.txtnatalia);
	        natalia.setText(datos.get(position).getContador());
	        
	        
	         
	        
	        Button incrementar = (Button)listItemView .findViewById(R.id.btnIncrementar);
	        
	        
	        @SuppressWarnings("unused")
			Button decrementar= (Button)listItemView .findViewById(R.id.BtnDecrementar);
	       
	        incrementar.setOnClickListener(new OnClickListener() {
				
				
				public void onClick(View arg0) {
					natalia.setText(datos.get(position).getIncrementarText());
					
				}
			} );
	   
	        
decrementar.setOnClickListener(new OnClickListener() {
				
				
				public void onClick(View arg0) {
					natalia.setText(datos.get(position).getDecrementarText());
					
				}
			} );
	        
	        
	      
	      
	        
	        return(listItemView );
	      }
		
		@Override
	    public int getCount() {
	        return datos.size();
	    }

	    @Override
	    public ContenidoItem getItem(int posicion) {
	        return datos.get(posicion);
	    }

	    @Override
	    public long getItemId(int posicion) {
	        return posicion;
	    }
		
		
		
}
