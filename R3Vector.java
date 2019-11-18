import java.util.Scanner;
public class R3Vector {
    Scanner in = new Scanner(System.in);

    private double x;
    private double y;
    private double z;

    public R3Vector(double x, double y, double z) {
        this.x = x; this.y = y; this.z = z;
    }
    public R3Vector() {
        System.out.println("Введите x: ");
        x = in.nextDouble();
        System.out.println("Введите y: ");
        y = in.nextDouble();
        System.out.println("Введите z: ");
        z = in.nextDouble();
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public void showXYZ() {
        System.out.println(getX());
        System.out.println(getY());
        System.out.println(getZ());
    }

    public static R3Vector plus(R3Vector a, R3Vector b) {
        return new R3Vector(a.x+b.x, a.y+b.y, a.z+b.z);
    }

    public static R3Vector minus(R3Vector a, R3Vector b) {
        return new R3Vector(a.x-b.x, a.y-b.y, a.z-b.z);
    }

    public static R3Vector multiplication(double k, R3Vector a) {
        return new R3Vector(k*a.x, k*a.y, k*a.z);
    }

    public static double scalarMultiplication(R3Vector a, R3Vector b) {
        return a.x*b.x + a.y*b.y + a.z*b.z;
    }

    public static R3Vector vectorMultiplication(R3Vector a, R3Vector b) {
        return new R3Vector(a.y*b.z-a.z*b.y, a.z*b.x-a.x*b.z, a.x*b.y-a.y*b.x);
    }

    public static R3Vector randomMultiplication(R3Vector a, R3Vector b, R3Vector c) {
        return new R3Vector(c.x*scalarMultiplication(a,b),c.y*scalarMultiplication(a,b),c.z*scalarMultiplication(a,b));
    }
}
