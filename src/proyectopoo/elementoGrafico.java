/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package proyectopoo;
import edu.epromero.util.Imagen;
import edu.epromero.util.LienzoStd;
public class elementoGrafico {
   protected boolean tocado;
   protected int columna;
   protected int renglon;
   protected String sprite;
   protected boolean bajando = false;
   
    public void pintar()//pinta los elemenotos graficos
   {
       Imagen dib = new Imagen(sprite);
   LienzoStd.dibujo(getColumna(), getRenglon(), dib );
   }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public boolean isTocado() {
        return tocado;
    }

    public void setTocado(boolean tocado) {
        this.tocado = tocado;
    }

    public boolean isBajando() {
        return bajando;
    }

    public void setBajando(boolean bajando) {
        this.bajando = bajando;
    }
   
  
 
}
