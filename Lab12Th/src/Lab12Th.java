public class Lab12Th {

    /** HOUSE ROBBERS BOTTOM UP
     *
     * After getting 15/16 on A7's autograder one too many times, you
     * have decided to turn to a life of crime.
     *
     * You have decided to do some good old fashion breaking and entering
     * to make a dishonest living and choice a nice suburban neighborhood.
     *
     * There's a catch though! The cops will catch you if you rob 2 houses
     * that are adjacent and you will go to jail if you get caught.
     *
     * You must find the most amount of money you can steal without getting
     * caught!
     *
     * TL;DR choose the correct, non-adjacent houses to rob that will
     * result in the highest possible number
     *
     * ex: [1, 0, 1, 4, 1] returns 5
     *
     * IMPORTANT: This is BOTTOM UP so NO RECURSION!
     *
     * @param houses array of payoffs of robbing houses at index i
     * @return maximum amount of payoff from robbing the houses without getting caught.
     */
    static int houseRobbersBottomUp(int[] houses) {
        //TODO
        if (houses == null || houses.length == 0) {
            return 0;
        }
        int houseLength = houses.length;
        int[] DynamicP = new int[houseLength];
        DynamicP[0] = Math.max(0, houses[0]);
        if (houseLength > 1) {
            DynamicP[1] = Math.max(houses[0], houses[1]);
        }
        for(int i = 2; i < houseLength; i++) {
            if (houses[i] + DynamicP[i-2] > DynamicP[i-1]) {
                DynamicP[i] = houses[i] + DynamicP[i-2];
            } else {
                DynamicP[i] = DynamicP[i-1];
            }
        }
        return DynamicP[houseLength - 1];
    }


    /** KNAPSACK TOP DOWN AND BOTTOM UP
     *
     * You inevitably got greedy when robbing houses and robbed 2
     * adjacent houses and got caught. (I told you not to do that!)
     * Now you must flee from the police.
     *
     * You have a problem though! You can only carry so much in
     * your trusty knapsack.
     *
     * After laying all your items out, you decided to make 2 lists
     * of how much each items weighs and how important each item is.
     *
     * You must now figure out the most of the best items you can
     * take. Better hurry, I hear sirens!
     *
     * TL;DR Return the optimal payoff without going over capacity.
     *
     * ex:
     *  capacity = 4
     *  weights = [2, 2, 3]
     *  profits = [1, 1, 3]
     *  n = 3
     *
     *  returns 3 because 3 is the highest payoff you can get
     *          without overfilling the knapsack. Taking items
     *          at index 0 and 1 result in a payoff of 2 and is
     *          suboptimal and therefore not valid.
     *
     * IMPORTANT: you must implement this TWICE. Once TOP DOWN
     * (recursion) and once BOTTOM UP (iteration)
     *
     * @param capacity most amount of weight you can carry
     * @param weights array of the weights of the ith item
     * @param profits array of the payoffs of taking the ith item.
     * @param n number of items
     * @return the highest possible payoff with the fullest knapsack.
     */

    static int knapSackTopDown(int capacity, int weights[], int profits[], int n)
    {
        //TODO
        // Base case: if there are no items or no capacity, the profit is 0
        if (n == 0 || capacity == 0) {
            return 0;
        }
        int withItem = 0;
        if(weights[n-1] <= capacity){
            withItem = profits[n-1] + knapSackTopDown(capacity-weights[n-1], weights, profits, n-1);
        }
        int withoutItem = knapSackTopDown(capacity, weights, profits, n-1);

        return Math.max(withItem, withoutItem);
    }

    static int knapSackBottomUp(int capacity, int weights[], int profits[], int n)
    {
        //TODO
        int bUp[][] = new int[n+1][capacity+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j<=capacity; j++){
                if(i == 0 || j == 0){
                    //if on a zero
                    bUp[i][j] = 0;
                }else if(weights[i-1] <= j){
                    bUp[i][j] = Math.max(profits[i-1]+bUp[i-1][j-weights[i-1]], bUp[i-1][j]);
                }else{
                    //use val in row above
                    bUp[i][j] = bUp[i-1][j];
                }
            }
        }
        return bUp[n][capacity];
    }



}
