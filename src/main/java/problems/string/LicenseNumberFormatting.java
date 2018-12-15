package problems.string;

/**
 * Created by kiryl_zayets on 12/4/18.
 */
public class LicenseNumberFormatting {

    public String licenseKeyFormatting(String S, int K) {
        if (S.length() == 0 || K <= 0 || (S.length() == 1 && S.equals("-"))) return S.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '-') sb.append(S.charAt(i));
        }
        int l = sb.length();
        int r = l % K;
        int w = l / K;

        while (w > 1) {
            w--;
            sb.insert(r + (w * K), '-');
        }

        if (r != 0) sb.insert(l % K, '-');

        return sb.toString().toUpperCase();
    }


    public static void main(String[] args) {

        LicenseNumberFormatting lnf = new LicenseNumberFormatting();
        lnf.licenseKeyFormatting("-", 2);

    }
}
