public class Ejercicio1 {
    int caras;
    int ultimaCara;
    public Ejercicio1(int caras){
        this.caras = caras;
    }
    public Ejercicio1(){
        this.caras = 6;
    }
    public int getCaras(){
        return this.caras;
    }
    public int getUltimaCara(){
        return this.ultimaCara;
    }
    public void setCaras(int caras){
        this.caras = caras;
    }
    public int tirarDado(){
        this.ultimaCara = (int) (Math.random() * this.caras) + 1;
        return this.ultimaCara;
    }
    public static void main(String[] args) {
        Ejercicio1 dado1 = new Ejercicio1();
        Ejercicio1 dado2 = new Ejercicio1(10);
        Ejercicio1 dado3 = new Ejercicio1(12);
        int suma = 0;
        while (suma < 20){
            suma = dado1.tirarDado() + dado2.tirarDado() + dado3.tirarDado();
            System.out.println("La suma de los dados es: " + suma);
        }
    }



}
