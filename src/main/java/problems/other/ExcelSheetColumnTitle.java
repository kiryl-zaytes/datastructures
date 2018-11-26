package problems.other;

/**
 * Created by kiryl_zayets on 11/24/18.
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n = n / 26;
        }

        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        ExcelSheetColumnTitle ecx = new ExcelSheetColumnTitle();
        System.out.print(ecx.convertToTitle(701));
    }

}
