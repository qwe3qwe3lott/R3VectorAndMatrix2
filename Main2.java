public class Main2 {
    public static void main(String[] args) {
        R3Vector a = new R3Vector(1,1,1);
        R3Vector b = new R3Vector(5,8,-3);
        R3Vector.plus(a,b).showXYZ();
        R3Vector c = new R3Vector();
        R3Vector.randomMultiplication(a,b,c).showXYZ();

        Matrix2 aa = new Matrix2(4);
        aa.showMatrix();
        System.out.println(aa.opred(aa));
        Matrix2.reverseMatrix(aa).showMatrix();
    }
}
