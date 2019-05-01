package problems.array;

/**
 * Created by kiryl_zayets on 12/21/18.
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers1(int[] flowerbed, int n) {

        if (n == 0) return true;
        if (n > flowerbed.length) return false;

        for (int i = 0; i < flowerbed.length; ) {
            if (flowerbed[i] == 1) i += 2;
            else if ((i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                if (--n == 0) return true;
                i += 2;
            } else i += 1;
        }
        return n == 0;
    }


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 0) return false;
        if (n == 1 && flowerbed.length == 1 && flowerbed[0] == 0) return true;
        if (n == 1 && flowerbed.length == 1 && flowerbed[0] == 1) return false;

        int j = 1;
        int length = flowerbed.length - 1;

        for (int i = 0; i < flowerbed.length; i++) {
            while (j < length && flowerbed[j] != 1) j++;
            int size = j - i - 1;
            i = j - 1;
            j++;
            if (size >= 3) {
                if (size % 2 == 0) n -= (size / 2) - 1;
                else n -= size / 2;
                if (n <= 0) return true;
            }
        }

        int nn = (flowerbed[length] == 0 &&
                flowerbed[length - 1] == 0) ? --n : n;
        return nn == 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        System.out.print(cpf.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 1));
    }
}
