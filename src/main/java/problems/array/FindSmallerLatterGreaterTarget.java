package problems.array;

/**
 * Created by kiryl_zayets on 10/22/18.
 */
public class FindSmallerLatterGreaterTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        char res= helper(letters, 0, letters.length-1, target);

        if (res <= target ) return letters[0];
        return res;

    }


    private char helper(char[] letters, int l, int h, char target) {
        if ( l == h) return letters[l];
        int m = l + (h-l)/2;
        if (target < letters[m]) return helper(letters, l, m, target);
        else return helper(letters, m+1, h, target);
    }


    public static void main(String[] args){
        FindSmallerLatterGreaterTarget fsgt = new FindSmallerLatterGreaterTarget();
        System.out.print(fsgt.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
    }

}
