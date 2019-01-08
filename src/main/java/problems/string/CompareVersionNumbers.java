package problems.string;

/**
 * Created by kiryl_zayets on 12/26/18.
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");


        int l1 = levels1.length;
        int l2 = levels2.length;

        int l = Math.max(l1, l2);

        for (int i = 0; i < l; i++) {
            Integer val1 = (i <= l1 - 1) ? Integer.valueOf(levels1[i]) : 0;
            Integer val2 = (i <= l2 - 1) ? Integer.valueOf(levels2[i]) : 0;
            int comp = val1.compareTo(val2);
            if (comp != 0) return comp;
        }

        return 0;

    }

    public static void main(String[] args) {
        CompareVersionNumbers cvn = new CompareVersionNumbers();

        System.out.print(cvn.compareVersion("1.0.1", "1"));
    }

}
