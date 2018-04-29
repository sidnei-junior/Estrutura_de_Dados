/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenwicktree;

/**
 *
 * @author C6-PROF
 */
public class FenwickTree {

    private int value;
    private int leftSize;
    private FenwickTree left;
    private FenwickTree right;

    //================================
    // Construtores
    public FenwickTree(int value) {
        this.value = value;
        leftSize = 0;
        left = null;
        right = null;
    }

    public FenwickTree(int leftSize, FenwickTree left, FenwickTree right) {
        this.value = left.value + right.value;
        this.leftSize = leftSize;
        this.left = left;
        this.right = right;
    }

    //================================
    public int getValue() {
        return value;
    }

    public int getLeftSize() {
        return leftSize;
    }

    public FenwickTree getLeft() {
        return left;
    }

    public FenwickTree getRight() {
        return right;
    }

    // =================================
    // na aula
    public void increment(int i, int delta) {
        //Falta testar
        value += delta;
        if (leftSize > i) {
            left.increment(i, delta);
        } else if (right != null) {
            right.increment(i - leftSize, delta);
        }
    }

    public int prefixSum(int upto) {
        //Falta testar
        int sum = 0;
        if (upto == 0) {
            return sum;
        }
        if (leftSize == 0) {
            return value;
        }

        if (upto >= leftSize) {
            sum += left.value;
            sum += right.prefixSum(upto - leftSize);
        } else {
            sum += left.prefixSum(upto);
        }

        return sum;
    }

    public int between(int lo, int hi) {

        return prefixSum(hi) - prefixSum(lo);
    }

    @Override
    public String toString() {
        // Não testado
        String aux = "[";
        aux += this.value + ", " + this.leftSize;
        if (this.left != null) {
            aux += ", " + this.left.toString();
        }
        if (this.right != null) {
            aux += ", " + this.right.toString();
        }
        aux += "]";
        return aux;
    }

    static FenwickTree allZeros(int n) {
        if (n == 0) {
            return null;
        }
        if (n == 1) {
            return new FenwickTree(0);
        }
        int m = n / 2;
        return new FenwickTree(n - m, allZeros(n - m), allZeros(m));
    }

    public int size() {
        int sum = 0;
        sum += leftSize;

        if (right != null) {
            sum += right.size();
        } else {
            sum += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        // teste de correcao
        FenwickTree T = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
                new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
                new FenwickTree(1, new FenwickTree(3),
                        new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
        System.out.println("Arvore this : " + T);
        System.out.println("Soma das folhas entre lo e hi : ");
        System.out.print("------|  ");
        for (int lo = 0; lo <= 6; lo++) {
            System.out.print("|lo = " + lo + " ");
        }
        System.out.println();
        for (int hi = 0; hi <= 6; hi++) {
            System.out.print("hi = " + hi + "|  ");
            for (int lo = 0; lo <= hi; lo++) {
                System.out.print("|" + T.between(lo, hi) + "     ");
                if (T.between(lo, hi) < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        //*/
    }

}
