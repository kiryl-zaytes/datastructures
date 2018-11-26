package problems.other;

/**
 * Created by kiryl_zayets on 11/24/18.
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {

        int n = 0;
        int i = 0;
        int l = s.length();
        while (i != l) {
            n = n * 26 + (s.charAt(i++) - 'A' + 1);
        }
        return n;
    }


    public static void main(String[] args) {
        ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
        System.out.print(e.titleToNumber("A"));
    }

}
