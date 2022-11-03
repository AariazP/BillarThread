package model;

public class Partida {

    private Integer puntosJugador1=0;
    private Integer puntosJugador2=0;
    private boolean disponible;

    private boolean acabaJugador1 = false;
    private boolean acabaJugador2 = false;

    public synchronized void jugar1(Integer puntosJugador1) {
        while(disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.puntosJugador1 += puntosJugador1;
        System.out.println("Juega el jugador 1..........." );
        System.out.println(" realiza un total de " + puntosJugador1 + " puntos\n");
        this.disponible = true;
        notify();
    }

    public synchronized void jugar2(Integer puntosJugador2) {
        while(!disponible){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       this.puntosJugador2 += puntosJugador2;
        System.out.println("juega el jugador 2..........." );
        System.out.println(" realiza un total de " + puntosJugador2 + " puntos\n");
        this.disponible = false;
        notify();
    }

    public Integer getPuntosJugador1() {
        return puntosJugador1;
    }


    public Integer getPuntosJugador2() {
        return puntosJugador2;
    }

    public boolean isAcabaJugador2() {
        return acabaJugador2;
    }

    public void setAcabaJugador2(boolean acabaJugador2) {
        this.acabaJugador2 = acabaJugador2;
    }

    public boolean isAcabaJugador1() {
        return acabaJugador1;
    }

    public void setAcabaJugador1(boolean acabaJugador1) {
        this.acabaJugador1 = acabaJugador1;
    }
}
