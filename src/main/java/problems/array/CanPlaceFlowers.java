package problems.array;

/**
 * Created by kiryl_zayets on 12/21/18.
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n==0) return true;
        if (n > flowerbed.length) return false;

        for (int i = 0; i < flowerbed.length;) {
            if (flowerbed[i] == 1) i+=2;
            else if ((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                if (--n == 0) return true;
                i+=2;
            }
            else i+=1;
        }
        return n==0;
    }

    public static void main(String[] args){
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        System.out.print(cpf.canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
    }
}
