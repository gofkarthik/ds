package ds_ref.greedyAlgorithms;
import java.util.Arrays;

public class CoinChangeProblemMain {

	public static void coinChangeProblem(int[] coins,int N){
		Arrays.sort(coins);
		int i=coins.length-1;
		while(true){
			int dM=coins[i--];
			int maxAmount=(N/dM)*dM;
			if(maxAmount > 0){
				System.out.println(dM+" "+(N/dM));
				N=N-maxAmount;
			}
			if(N ==0)break;
		}
	}
	public static void main(String[] args) {
		int [] coins = {1, 2, 5, 10, 50, 100, 500,1000};
		int amount = 2758;
		System.out.println("Coins available: "+Arrays.toString(coins));
		System.out.println("Target amount: "+ amount);
		CoinChangeProblem.coinChangeProblem(coins, amount);
		coinChangeProblem(coins,amount);
	}//end of method

}//end of class
