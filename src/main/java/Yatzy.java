public class Yatzy {

    protected int[] dice;

    public Yatzy(int die1, int die2, int die3, int die4, int die5)
    {
        dice = new int[5];
        dice[0] = die1;
        dice[1] = die2;
        dice[2] = die3;
        dice[3] = die4;
        dice[4] = die5;
    }

    public int chance()
    {
        int total = 0;
        for(int die: dice) {
            total += die;
        }
        return total;
    }

    public int yatzy()
    {
        int[] counts = new int[dice.length + 1];
        for (int die : dice)
            counts[die - 1]++;
        for (int count : counts)
            if (count == 5)
                return 50;
        return 0;
    }

    public int ones() {
        int sum = 0;
        for (int die: dice)
            if (die == 1) sum += 1;
        return sum;
    }

    public int twos() {
        int sum = 0;
        for (int die: dice)
            if (die == 2) sum += 2;
        return sum;
    }

    public int threes() {
        int sum = 0;
        for (int die: dice)
            if (die == 3) sum += 3;
        return sum;
    }

    public int fours()
    {
        int sum = 0;
        for (int die : dice)
            if (die == 4)
                sum = sum + 4;
        return sum;
    }

    public int fives()
    {
        int sum = 0;
        for (int die : dice)
            if (die == 5)
                sum = sum + 5;
        return sum;
    }

    public int sixes()
    {
        int sum = 0;
        for (int die : dice)
            if (die == 6)
                sum = sum + 6;
        return sum;
    }

    public static int score_pair(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = tallies(die1, die2, die3, die4, die5);
        for (int i = 0; i != 6; i++)
            if (tallies[6 - i - 1] >= 2)
                return (6 - i) * 2;
        return 0;
    }

    public static int two_pair(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = tallies(die1, die2, die3, die4, die5);
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (tallies[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public static int four_of_a_kind(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = tallies(die1, die2, die3, die4, die5);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i + 1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = tallies(die1, die2, die3, die4, die5);
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 3)
                return (i + 1) * 3;
        return 0;
    }

    public static int smallStraight(int die1, int die2, int die3, int die4, int die5)
    {
        int[] tallies = tallies(die1, die2, die3, die4, die5);
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
        int[] tallies = tallies(die1, die2, die3, die4, die5);
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1 &&
                tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int die1, int die2, int die3, int die4, int die5)
    {
        boolean hasTwoOfAKind = false;
        int twoOfAKindSum = 0;
        boolean hasThreeOfAKind = false;
        int threeOfAKindSum = 0;

        int[] tallies = tallies(die1, die2, die3, die4, die5);

        for (int i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                hasTwoOfAKind = true;
                twoOfAKindSum = i + 1;
            }

        for (int i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                hasThreeOfAKind = true;
                threeOfAKindSum = i + 1;
            }

        if (hasTwoOfAKind && hasThreeOfAKind)
            return twoOfAKindSum * 2 + threeOfAKindSum * 3;
        else
            return 0;
    }

    private static int[] tallies(int die1, int die2, int die3, int die4, int die5) {
        int[] tallies = new int[6];
        tallies[die1 - 1] += 1;
        tallies[die2 - 1] += 1;
        tallies[die3 - 1] += 1;
        tallies[die4 - 1] += 1;
        tallies[die5 - 1] += 1;
        return tallies;
    }
}