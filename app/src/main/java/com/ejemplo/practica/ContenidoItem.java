package com.ejemplo.practica;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

public class ContenidoItem {
	private String titulo;
	private EditText entrada ;
	private EditText natalia ;
	private Button incrementar;
	private Button decrementar;
	private int contador = 1;
	
	 public ContenidoItem(String titulo, Context contexto){
		 
		    this.titulo = titulo;
		    this.natalia = new EditText(contexto);
		    this.natalia.setText(titulo);
	        entrada = new EditText(contexto);
	        incrementar= new Button(contexto);
	        decrementar = new Button(contexto);
	    }
	 
	    public String getTitulo(){
	        return titulo;
	    }
	 
	    public EditText getEntrada(){
	        return entrada;
	    }
	    
	    public Button getIncrementar(){
	        return incrementar;
	    }

	    public EditText getNatalia(){
	        return natalia;
	    }
	    
	    public Button getDecrementar(){
	        return decrementar;
	    }
	    
	    public void setEntradaTexto(String texto){
	        entrada.setText(texto);
	    }

	    public String getIncrementarText(){
	    	contador = contador + 1 ;
	    	 return Integer.toString(contador);
	    }
	    
	    public String getContador(){
	    
	    	 return Integer.toString(contador);
	    }
	    
	    public String getDecrementarText(){
	    	if (contador == 1){
	    		 return "1";
	    	}else{
	    		contador = contador - 1 ;
		    	 return Integer.toString(contador);
	    		
	    	}
	    	
	    }

}
