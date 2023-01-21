package cs526_hw2;

public class practice {
	public static int method2(int a, int n) {  // assume equal‐length arrays -> n = size of array 
		  
          if (n < 1) return 1;
          else {
             int x = n;
              while( x >= 1) {
                 a = a + a;
                 x--;
                 }
             
           return (a + method2(a, n-1));
          
	}
 }
	public static void main(String[] args) {
		System.out.println(method2(2,3));
	}
}
