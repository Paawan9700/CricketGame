import java.util.concurrent.ThreadLocalRandom;

public class GenerateRandom {
    int[] runsOrWicket = {0, 1, 2, 3, 4, 5, 6, 7};
    int[] batsmanDist = {1, 3, 5, 6, 7, 5, 6, 2};
    int[] bowlerDist = {1, 2, 2, 2, 1, 2, 1, 4};

    private int findCeil(int[] prefix, int r, int low, int high){
        while (low < high){
            int mid = low + (high - low) / 2;
            if(prefix[mid] < r){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (prefix[low] >= r) ? low : 0;
    }

    private int myRandom(int[] runsOrWicket, int[] freq, int n){
        int[] prefix = new int[n + 1];
        prefix[0] = freq[0];
        for(int i = 1; i < n; ++i){
            prefix[i] = prefix[i - 1] + freq[i];
        }

        int r = ((int)(Math.random() * 323567) % prefix[n - 1]) + 1;
        int index = findCeil(prefix, r, 0, n - 1);

        return runsOrWicket[index];
    }

    public int giveRandomNumber(int isBatsman){
        if(isBatsman == 1){
            return myRandom(runsOrWicket, batsmanDist, runsOrWicket.length);
        } else {
            return myRandom(runsOrWicket, bowlerDist, runsOrWicket.length);
        }
    }
}
