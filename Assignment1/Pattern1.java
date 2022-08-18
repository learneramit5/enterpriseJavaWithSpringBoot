package assignment1;

public class Pattern1 {

	public static void main(String[] args) {
		int n =5;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(i ==0 || i == n-1 || j == (n-1)/2)
					System.out.print("i ");
				else
					System.out.print("  ");
			}
			System.out.print("	");
			
			for(int j=0; j<n; j++) {
				if(j ==0 || j == n-1 || i ==j)
					System.out.print("N ");
				else
					System.out.print("  ");
			}
			
			System.out.print("	");
			
			for(int j=0; j<n; j++) {
				if(i ==0 || i == (n-1)/2 || i == n-1 || j== 0)
					System.out.print("E ");
				else
					System.out.print("  ");
			}
			
			System.out.print("	");
			
			for(int j=0; j<n; j++) {
				if(j== 0 || i == n-1 || j== n-1)
					System.out.print("U ");
				else
					System.out.print("  ");
			}
			
			
			System.out.print("    ");
			
			for(int j=0; j<n; j++) {
				if ((i == 0 || i == (n-1) / 2)
		                && j < (n-1) - 1 || j==0 || i-j == (n-1)/2 || j == (n-1)/2 +1 && i == (n-1)/2-1)
		                System.out.print("R ");
		            else
		                System.out.print(" ");
			}
			
			System.out.print("	");
			
			for(int j=0; j<n; j++) {
				if(j== 0 && i != 0 && i != (n-1) || i ==0 && j != 0 && j != (n-1) || j== n-1 && i != 0 && i != (n-1) || i == n-1 && j != 0 && j != (n-1))
					System.out.print("O ");
				else
					System.out.print("  ");
			}
			
			System.out.print("	");
			
			for(int j=0; j<n; j++) {
				if(j ==0 || j == n-1 || i ==j)
					System.out.print("N ");
				else
					System.out.print("  ");
			}
			
			System.out.println();
		}
	}

}
