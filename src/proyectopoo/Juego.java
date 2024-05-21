
package proyectopoo;

import edu.epromero.util.LienzoStd;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

public class Juego {
   
    public Cheroe doodle;
    private elementoGrafico [] elementos;
    private Objetos [] arregloDeObjetos;
    private int plataformaColisionada = -400;

    
    
  Random numero = new Random();
    public void ventana(){//muestra la ventana
        arregloDeObjetos = new Objetos[150];
        doodle = new Cheroe(0,-300, false); //Inicar doodle
        LienzoStd.ponTamanioLienzo(500, 700);
        LienzoStd.ponEscalaX(-250, 250);
        LienzoStd.ponEscalaY(-350,350);
        
    }
    
    public void geneadorDeObjetos(){
       int columnaRandom = numero.nextInt(-250, 250);///Variable int, genera un valor aleatorio para asiganar un colunmna a los elementos graficos
        int renglonRandom = numero.nextInt(+100,300);///Variable int, genera un valor aleatorio para asiganar un Renglon a los elementos graficos
             
        arregloDeObjetos[0] =  new Objetos(columnaRandom, 0, "src\\sprites\\RampaVerde.jpg");// Se instancia la primera plataforma  
        for(int i = 1; i <=  arregloDeObjetos.length-1; i++){
            
        if(i % 8 == 0){//Instancia las plaformas cafes
          columnaRandom = numero.nextInt(-250, 250);
          arregloDeObjetos[i] =  new Objetos(columnaRandom,  arregloDeObjetos[i-1].getRenglon()+50, "src\\sprites\\bicho1.jpg"); 
          
        }else if(i % 5 == 0){//Instancia las plataformas azules
         arregloDeObjetos[i] =  new Objetos(columnaRandom, renglonRandom, "src\\sprites\\RampaAzul.jpg");
        
        }else if(i % 3 == 0){//Instancia las platformas cafes
        arregloDeObjetos[i] = new Objetos(columnaRandom, renglonRandom, "src\\sprites\\RampaCafe.jpg");
       
        }else if(i % 1 == 0){//Instancia las plataformas verdes
         arregloDeObjetos[i] = new Objetos(columnaRandom, renglonRandom, "src\\sprites\\RampaVerde.jpg");
        
        }
        
        if(!(i % 8 == 0)){//Para que las plataformas no se encimen, se actualiza el valor de renglonRandom columnaRandom
        renglonRandom = numero.nextInt(renglonRandom+100,renglonRandom+400);
        columnaRandom = numero.nextInt(-250, 250);
        }
        }
    }

    
    public void pintarEnPantalla(){
        
    doodle.pintar();// Pinta a Cheroe
     for(int i = 0; i <= arregloDeObjetos.length-1; i++){//Ciclo for, pinta los elmenotos graficos
     arregloDeObjetos[i].pintar();
     
     if(i % 8 == 0 && !(i == 0)){
     }else if(i % 5 == 0 && !(i == 0)){//moviento de las plataformas azules
        arregloDeObjetos[i].moverHorizontal();
    }

    if(plataformaColisionada >= -350 ){// Metodo de control if, cuado Cheroe pisa una plataformas, esta bajara hacia abajo de la pantalla
       arregloDeObjetos[i].setBajando(true);
       arregloDeObjetos[i].setRenglon(arregloDeObjetos[i].getRenglon()-30);

     }else if(plataformaColisionada <= -350){
      arregloDeObjetos[i].setBajando(false);}
     }
       plataformaColisionada = plataformaColisionada -30;//Cantidad de renglones que bajan las plataformas por ciclo de ejecucion en ProyectoPoo
        
       ///Pinta en pantalla la puntuacion de CHeroe
        Font fuente=new Font("Arial Black", Font.BOLD, 16);
        LienzoStd.ponFuente(fuente);
        LienzoStd.ponColorLapiz(Color.BLACK);
        LienzoStd.texto(LienzoStd.pideLimiteXMax()-100, (LienzoStd.pideLimiteYMin()+30), "Puntucion: "+doodle.getPuntuacion());
        //////
    }
    
    
    
    public void mover(int te){
    doodle.mover(te);//Metodo mover, recibe el un valor Int, para el moviento horizontal de Cheroe
    }
    
    public void detectarColision(){
    for(int i = 0; i <=  arregloDeObjetos.length-1; i++){//Ciclo for, manda la posicion de los elementos graficos, si Cheroe toca a alguno se deteca colision
        doodle.detectarColision(arregloDeObjetos[i].getColumna()-53, arregloDeObjetos[i].getColumna()+53, arregloDeObjetos[i].getRenglon()+10, arregloDeObjetos[i].getRenglon()-10);
        
       if(i% 8 == 0 && !(i== 0)){//Detecta la colsion con los bichos
        doodle.tocarBicho(arregloDeObjetos[i].getColumna()-30, arregloDeObjetos[i].getColumna()+30, arregloDeObjetos[i].getRenglon()+30, arregloDeObjetos[i].getRenglon()-15);
       }
       
        if(doodle.isColision() && !arregloDeObjetos[i].isBajando() && !(i % 8 == 0)){
              if(i % 8 == 0 && !(i== 0)){
              }else if(i% 5 == 0){//if vacios, evita que las plataformas sean confudidas
              }else if(i % 3 == 0){
               if(arregloDeObjetos[i].isTocado()){
                  arregloDeObjetos[i].setRenglon(-500);
                  }else{//cambia el sprite de la plataforma cafe, cuando estas son colisionadas
       arregloDeObjetos[i].setSprite("src\\sprites\\RampaCafeRota.jpg");
                  }
        }else if(i % 1 == 0 || i == 0){//if vacio, evita que las plataformas sean confudidas
        }
              
    plataformaColisionada = arregloDeObjetos[i].getRenglon();//variable int, que guarda la altura de la ultima plataforma que se colisiono, esto para que las plataformas bajen

            doodle.setColision(false);//La colision de Cheroe vuelve a false, para que pueda volver a colisionar
            
if(!arregloDeObjetos[i].isTocado()){//Cuando haya una colision a una plataforma, se marcara como tocado a dicha plataforma, y se subiera en 10 la variable puntuacion de Cheroe
             arregloDeObjetos[i].setTocado(true);
             doodle.setPuntuacion(doodle.getPuntuacion()+10);
             System.out.println(doodle.getPuntuacion());
}
    }
     }
    
    }
   
    public void saltar(){
    doodle.saltar();
    }
    
    
    
    public boolean termimarJuego(){//Se termina el juego si Cheroe cae, o si Cheroe toca a un bicho
    if(doodle.getRenglon() <= -399 || !doodle.isVivo()){
     doodle.setVivo(false);
     return false;
    }
    return true;
    }
    
    
    
    }
    
    
    

    
    

