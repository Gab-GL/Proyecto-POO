package proyectopoo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author gabri
 */
public class Cheroe extends elementoGrafico {
  private int puntuacion = 0;
  private boolean vivo = true;
  private boolean cayendo;
  private boolean colision = false;
  
  
  public Cheroe (int columna, int renglon, boolean cayendo){//Constructor de Cheroe
  sprite = "src\\sprites\\Doodle.jpg";
  setColumna(columna);
  setRenglon(renglon);
   }
    
    public void detectarColision (int puntoColisionIzquierdo, int puntoColisionDerecho, int puntoDeColisionAlto, int puntoDeColisionBajo){//Metodo para detectar la colision con las plataformas, recibe las cordenadas de las esquinas de las plataformas
    if((cayendo == true) && ((puntoColisionIzquierdo <= getColumna() && puntoColisionDerecho >= getColumna()) || (puntoColisionIzquierdo <= getColumna()+49 && puntoColisionDerecho >= getColumna()+49) || (puntoColisionIzquierdo <= getColumna()-49 && puntoColisionDerecho >= getColumna()-49)) && (puntoDeColisionAlto >= getRenglon()-49 && puntoDeColisionBajo <= getRenglon()-49) ){   
        System.out.println("colision");
        cayendo = false;
        colision = true;
    }
    
    }
        public void tocarBicho(int puntoColisionIzquierdo, int puntoColisionDerecho, int puntoDeColisionAlto, int puntoDeColisionBajo){//Metodo para detectar la colision con los bichos, recibe las cordenadas de las esquinas de las plataformas
            if(((puntoColisionIzquierdo <= getColumna() && puntoColisionDerecho >= getColumna()) || (puntoColisionIzquierdo <= getColumna()+49 && puntoColisionDerecho >= getColumna()+49) || (puntoColisionIzquierdo <= getColumna()-49 && puntoColisionDerecho >= getColumna()-49)) && (puntoDeColisionAlto >= getRenglon()-49 && puntoDeColisionBajo <= getRenglon()+49) ){   
                 setVivo(false);
            }
       
        }

    public void mover(int e){//metodo para mover horizontalmente a Cheroe, recive valores de la entrada
    setColumna(getColumna() + e);
    if(getColumna()+45 < -270){//evta que CHeroe salga de la pantalla
    setColumna(270);
    }
    if(getColumna()-45 > 270){
    setColumna(-270);
    }
    
    }
     
    public void saltar(){
        if((getRenglon() <= 117) && cayendo == false){//Hace que Cheroe suba
            setRenglon(getRenglon()+ 10);
        }
        
        
        
        if(getRenglon()>= 117){//Cuando Cheroe alcanza la altura maxima, este empieza a caer
        cayendo = true;
        
        }
        
           if(getRenglon() >= -399 && cayendo == true){//Cantidad de renglones que baja, cuando Cheroe baja
       setRenglon(getRenglon()- 7);
   }
           
        
    }

    
    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public boolean isCayendo() {
        return cayendo;
    }

    public void setCayendo(boolean cayendo) {
        this.cayendo = cayendo;
    }

    public boolean isColision() {
        return colision;
    }

    public void setColision(boolean colision) {
        this.colision = colision;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    
}
