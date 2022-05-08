public class Yatzy {

    public static int chance(int die1, int die2, int die3, int die4, int die5)
    {
        int total = 0;
        total += die1;
        total += die2;
        total += die3;
        total += die4;
        total += die5;
        return total;
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int die1, int die2, int die3, int die4, int die5) {
        int sum = 0;
        if (die1 == 1) sum++;
        if (die2 == 1) sum++;
        if (die3 == 1) sum++;
        if (die4 == 1) sum++;
        if (die5 == 1)
            sum++;

        return sum;
    }

    public static int twos(int die1, int die2, int die3, int die4, int die5) {
        int sum = 0;
        if (die1 == 2) sum += 2;
        if (die2 == 2) sum += 2;
        if (die3 == 2) sum += 2;
        if (die4 == 2) sum += 2;
        if (die5 == 2) sum += 2;
        return sum;
    }

    public static int threes(int die1, int die2, int die3, int die4, int die5) {
        int sum = 0;
        if (die1 == 3) sum += 3;
        if (die2 == 3) sum += 3;
        if (die3 == 3) sum += 3;
        if (die4 == 3) sum += 3;
        if (die5 == 3) sum += 3;
        return sum;
    }

    protected int[] dice;
    public Yatzy(int die1, int die2, int die3, int die4, int _5)
    {
        dice = new int[5];
        dice[0] = die1;
        dice[1] = die2;
        dice[2] = die3;
        dice[3] = die4;
        dice[4] = _5;
    }

    public int fours()
    {
        int sum = 0;
        for (int i = 0; i != 5; i++) {
            if (dice[i] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes()
    {
        int sum = 0;
        for (int i = 0; i < dice.length; i++)
            if (dice[i] == 6)
                sum = sum + 6;
        return sum;
    }

    public static int score_pair(int die1, int die2, int die3, int die4, int die5)
    {
        int[] counts = new int[6];
        counts[die1-1]++;
        counts[die2-1]++;
        counts[die3-1]++;
        counts[die4-1]++;
        counts[die5-1]++;
        int i;
        for (i = 0; i != 6; i++)
            if (counts[6-i-1] >= 2)
                return (6-i)*2;
        return 0;
    }

    public static int two_pair(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = new int[6];
        tallies[die1-1]++;
        tallies[die2-1]++;
        tallies[die3-1]++;
        tallies[die4-1]++;
        tallies[die5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (tallies[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = new int[6];
        tallies[die1-1]++;
        tallies[die2-1]++;
        tallies[die3-1]++;
        tallies[die4-1]++;
        tallies[die5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = new int[6];
        tallies[die1-1]++;
        tallies[die2-1]++;
        tallies[die3-1]++;
        tallies[die4-1]++;
        tallies[die5-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = new int[6];
        tallies[die1-1] += 1;
        tallies[die2-1] += 1;
        tallies[die3-1] += 1;
        tallies[die4-1] += 1;
        tallies[die5-1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = new int[6];
        tallies[die1-1] += 1;
        tallies[die2-1] += 1;
        tallies[die3-1] += 1;
        tallies[die4-1] += 1;
        tallies[die5-1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int die1, int die2, int die3, int die4, int die5)
    {
        boolean hasTwoOfAKind = false;
        int i;
        int twoOfAKindSum = 0;
        boolean hasThreeOfAKind = false;
        int threeOfAKindSum = 0;

        int[] tallies = new int[6];
        tallies[die1-1] += 1;
        tallies[die2-1] += 1;
        tallies[die3-1] += 1;
        tallies[die4-1] += 1;
        tallies[die5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                hasTwoOfAKind = true;
                twoOfAKindSum = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                hasThreeOfAKind = true;
                threeOfAKindSum = i+1;
            }

        if (hasTwoOfAKind && hasThreeOfAKind)
            return twoOfAKindSum * 2 + threeOfAKindSum * 3;
        else
            return 0;
    }
}