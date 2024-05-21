
package proyectopoo;

public class Objetos extends elementoGrafico {
    private boolean voyDerecha = true;
    public Objetos(int columna, int renglon, String ruta){//constructor
    setSprite(ruta);
    setColumna(columna);
    setRenglon(renglon);
    setTocado(false);//Variable boolean para saber si el objeto ha sido tocado
    }
  
   public void moverHorizontal(){//Mueve horizontalmente a las plataformas azules
       if(voyDerecha){
       setColumna(getColumna()+5);
       if(getColumna() >= 250){
       voyDerecha = false;
       }
       }else {
       setColumna(getColumna()-5);
       if(getColumna() <= -250){
       voyDerecha = true;
       }
       }
   }
}
