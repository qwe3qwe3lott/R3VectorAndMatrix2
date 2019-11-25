import java.util.Scanner;
public class Matrix2 {
    Scanner in = new Scanner(System.in);

    private int m;
    private double[][] matrix;
    private double opred;
//Построить матрицу любого порядка с вводом данных с клавиатуры
    public Matrix2(int m) {
        this.m = m;
        this.matrix = new double[this.m][this.m];
        System.out.println("Заполните матрицу: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                this.matrix[i][j] = in.nextInt();
            }
        }
    }
//Построить матрицу на основе готовой матрицы, с удаленем одного столбца и одной строки
    public Matrix2(int m, double[][] matrix, int q, int s) {
        int h = 0;
        int p = 0;
        this.m = m - 1;
        this.matrix = new double[this.m][this.m];
        for (int j = 0; j < this.m; j++) {
            if(j == s) h++;
            for (int i = 0; i < this.m; i++) {
                if(q == p) p++;
                this.matrix[i][j] = matrix[p][h];
                p++;
            }
            p = 0;
            h++;
        }
    }
// Построить матрицу на основе готовой матрицы
    public Matrix2(int m, double[][] matrix) {
        this.m = m;
        this.matrix = matrix;
    }
// Вывести элементы матрицы
    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "      ");
            }
        }
        System.out.println();
    }
// Сумма матриц
    public static Matrix2 plus(Matrix2 a, Matrix2 b) {
        double[][] matrix = new double[a.m][a.m];
        for (int i = 0; i < a.m; i++) {
            for (int j = 0; j < a.m; j++) {
                matrix[i][j] = a.matrix[i][j] + b.matrix[i][j];
            }
        }
        return new Matrix2(a.m, matrix);
    }
// Разность матриц
    public static Matrix2 minus(Matrix2 a, Matrix2 b) {
        double[][] matrix = new double[a.m][a.m];
        for (int i = 0; i < a.m; i++) {
            for (int j = 0; j < a.m; j++) {
                matrix[i][j] = a.matrix[i][j] - b.matrix[i][j];
            }
        }
        return new Matrix2(a.m, matrix);
    }
// Умножение матрицы на число
    public static Matrix2 numberMultiplication(Matrix2 a, double b) {
        for (int i = 0; i < a.m; i++) {
            for (int j = 0; j < a.m; j++) {
                a.matrix[i][j] = a.matrix[i][j] * b;
            }
        }
        return a;
    }
// Произведение матриц
    public static Matrix2 multiplication(Matrix2 a, Matrix2 b) {
        double[][] matrix = new double[a.m][a.m];
        for (int i = 0; i < a.m; i++) {
            for (int j = 0; j < a.m; j++) {
                for (int s = 0; s < a.m; s++) {
                    matrix[i][j] += a.matrix[i][s] * b.matrix[s][j];
                }
            }
        }
        return new Matrix2(a.m, matrix);
    }
// Определитель матрецы
    public double opred(Matrix2 a) {
        this.opred = 0;
        if (a.m < 3) {
            this.opred = a.matrix[0][0]*a.matrix[1][1] - a.matrix[0][1]*a.matrix[1][0];
        } else {
            for(int s = 0; s < a.m; s++) {
                if (s%2 == 0) {
                    this.opred += a.matrix[0][s]*new Matrix2(a.m, matrix, 0, s).opred(new Matrix2(a.m, matrix, 0, s));
                } else {
                    this.opred -= a.matrix[0][s]*new Matrix2(a.m, matrix, 0, s).opred(new Matrix2(a.m, matrix, 0, s));
                }
            }
        }
        return this.opred;
    }
// Обратная матрица
    public static Matrix2 reverseMatrix(Matrix2 a) {
        double[][] matrix = new double[a.m][a.m];
        if (a.opred(a) == 0) {
            System.out.println("Определитель равен нулю - матрица не обратилась!");
        } else if (a.m == 2) {
            matrix[0][0] = a.matrix[1][1];
            matrix[1][1] = a.matrix[0][0];
            matrix[0][1] = -a.matrix[0][1];
            matrix[1][0] = -a.matrix[1][0];
        } else {
            for (int i = 0; i < a.m; i++) {
                for (int j = 0; j < a.m; j++) {
                    if((i+j)%2 == 0) {
                        matrix[i][j] = new Matrix2(a.m, a.matrix, j, i).opred(new Matrix2(a.m, a.matrix, j, i));
                    } else {
                        matrix[i][j] = -(new Matrix2(a.m, a.matrix, j, i).opred(new Matrix2(a.m, a.matrix, j, i)));
                    }
                    new Matrix2(a.m,matrix).showMatrix();
                }
            }
        }
        System.out.println(a.opred(a));
        System.out.println(1/a.opred(a));
        return numberMultiplication(new Matrix2(a.m,matrix),(1/a.opred(a)));
    }
}

