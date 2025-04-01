public class Pixel {
    private int x;
    private int y;
    private int cor;

    public Pixel(int x, int y, int cor){
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getCor(){
        return cor;
    }
}
