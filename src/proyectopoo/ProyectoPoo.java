/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopoo;
import edu.epromero.util.LienzoStd;
import java.awt.Color;
import java.awt.Font;
import java.lang.Thread.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class ProyectoPoo {
    
 
    public static void main(String[] args) {
    Juego partida = new Juego();
    partida.ventana();//Incialisa a Cheroe, y muestra el lienzo
    Entrada e = new Entrada();
    partida.geneadorDeObjetos(); //Genera los elementos Graficos (plataformas, bichos)
          
    while(true){ //Ciclo while, aqui se ejecuta el juego
     partida.pintarEnPantalla();
     int tecla = e.recibirtecla(LienzoStd.fuePulsadaTecla(37), LienzoStd.fuePulsadaTecla(39)); //Variable int. recibe un valor que da el movimiento horizontal de Chore
     partida.mover(tecla); //Resive la variable tecla, para el movimiento de Cheroe
     partida.saltar();//Metodo saltar, hace que Cheroe suba
     partida.detectarColision();// Metodo para detectar la colision de Cheroe con los elementos graficos (plataformas, bichos)
     
     try{Thread.sleep(1);}catch(InterruptedException ex){}
     LienzoStd.mostrar(0);
     LienzoStd.limpia(); //Pinta los elementos graficos
     
     if(!partida.termimarJuego()){///Metodo de control if, si las vidas del Cheore llegan a cero, se muestra una pantalla para el final del juego
        for(int j =5; j>=0;j--){// Ciclo for que mostrara el fin del juego, y mostrara un contador para el reinicio del juego
        Font texto=new Font("Arial Black", Font.BOLD, 36);
        LienzoStd.ponFuente(texto);
        LienzoStd.ponColorLapiz(Color.red);
        LienzoStd.texto(0, 40, "Moriste");
        LienzoStd.texto(0, 0, "Fin del juego");
        LienzoStd.texto(0, -40, "Continuara en..."+j);
        try{Thread.sleep(1500);}catch(InterruptedException ex){}
        LienzoStd.mostrar(1);        LienzoStd.limpia();
        }
        partida.ventana();
        partida.geneadorDeObjetos();
        }
        }
        
    }
    
}
