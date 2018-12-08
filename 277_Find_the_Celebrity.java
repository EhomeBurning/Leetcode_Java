public class Lc277_Find_the_Celebrity {
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

    public int findCelebrity(int n) {
        if (n < 2) {
            return -1;
        }

        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (candidate != i && knows(candidate, i)) {
                return -1;
            } else if (candidate != i && !knows(i, candidate)) {
                return -1;
            }
        }
        return candidate;


    }
}