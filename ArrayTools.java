/**
* <h1>Array Tools</h1>
* Array Tools contains different programs so you can
* manipulate arrays easily.
* <p>
*
* @author  Blythe Dineen
* @version 1.0
* @since   2017-17-11
*/


public class ArrayTools {

	public static void main(String args[]){
			double[] a = {1.0,3.0,5.0,7.0,9.0,10.0};
			double[] b = {5.5,6.4,3.3,80.6,12.1,111.0,4.0};

			//print arrays
			System.out.println("original array a:");
			printArray(a);
			System.out.println("original array b:");
			printArray(b);

			//reverse 1st array
			System.out.println("\nreverse:");
			printArray(reverse(a));

			//max value of 1st array
			System.out.println("\nmax of a:");
			System.out.println(findMax(a));

			//min value of 1st array
			System.out.println("\nmin of a:");
			System.out.println(findMin(a));

			//are 1st and 2nd array equal
			System.out.println("\na and b are equal:");
			System.out.println(areEqual(a,b));

			//average of 1st array
			System.out.println("\nmean of a:");
			System.out.println(mean(a));

			//scale values of 1st array
			System.out.println("\nscale a:");
			printArray(scale(a,0.5));

			//shuffle terms in 1st array
			System.out.println("\nshuffle a:");
			printArray(shuffle(a));

			//weighted addition of both arrays
			System.out.println("\nweighted add a and b:");
			printArray(add(a,b,0.8,0.2));

			//copy selected portion of 1st array
			System.out.println("\ncopy a:");
			printArray(copy(a,2,5));

			//remove selected portion of 1st array
			System.out.println("\ncut a:");
			printArray(cut(a,2,5));		
		}

//THE METHODS

	/**
   * This method is for printing arrays.
   * @param a[] This parameter is an array for printArray
   */

	public static void printArray (double a[]){
		for (int i = 0; i<a.length; i++){
			System.out.println(a[i]);
		}
	}

	/**
   * This method is for reversing arrays.
   * @param a[] This parameter is an array for reverse
   * @return b[]; an array that reverses the terms in a[].
   */

	public static double[] reverse (double a[]){
		double[] b = new double[a.length];
		for (int i = 0; i<a.length/2; i++){
			double temp = a[i];
			b[i] = a[a.length-1-i];
			b[a.length-1-i] = temp;
		}
		return b;
	}

	/**
   * This method is for finding the max of the array.
   * @param a[] This parameter is an array for max
   * @return max; the double value of the largest term in the array.
   */
 
	public static double findMax (double a[]){
		double max = Double.NEGATIVE_INFINITY;
		for (int i = 0; i<a.length; i++){
			if(a[i]>max){
				max = a[i];
			}
		}
		return max;
	}

	/**
   * This method is for finding the min of the array.
   * @param a[] This parameter is an array for min
   * @return min; the double value of the smallest term in the array.
   */

	public static double findMin (double a[]){
		double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i<a.length; i++){
			if(a[i]<min){
				min = a[i];
			}
		}
		return min;
	}	

	/**
   * This method is for finding if two arrays are equal.
   * @param a[] This parameter is the first array
   * @param b[] This parameter is the second array
   * @return boolean; whether each term in the array is the same
   */

	public static boolean areEqual (double a[], double b[]){
		if (a.length == b.length) {
			for (int i = 0; i<a.length; i++){
				if (a[i] != b[i]){
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
   * This method is for finding the average of the array.
   * @param a[] This parameter is the array inputted for average
   * @return average; the double value of the average of all the terms in the array array.
   */

	public static double mean (double a[]){
		double sum = 0.0;
		for (int i = 0; i<a.length; i++){
			sum+= a[i];
		}
		double average = sum/a.length;
		return average;
	}

	/**
   * This method is for scaling all the terms in the array by a certain scaling factor.
   * @param a[] This parameter is the array inputted to be scaled
   * @param c This parameter is a double value to scale the terms in a[] to produce b[]
   * @return b[]; The scaled array.
   */

	public static double[] scale (double a[], double c){
		double[] b = new double[a.length];
		for (int i = 0; i<a.length; i++){
			b[i] = a[i]*c;
		}
		return b;
	}

	/**
   * This method is for shuffling terms in an array.
   * @param a[] This parameter is the initial array.
   * @return b[]; The randomly shuffled array.
   */

	private static double[] shuffle(double a[]) {
		double[] b = new double[a.length];
		for (int i = 0; i<a.length; i++){
			b[i] = a[i];
		}
		for (int j = 0; j<b.length; j++){
			int random = (int) (Math.random()*a.length);
			swap(b,j, random);
		}
		return b;
	}

	/**
   * This method is for adding two arrays together in weighted proportions.
   * @param a[] This parameter is the first array.
   * @param b[] This parameter is the second array.
   * @param c This parameter is a double value to scale the terms in a[].
   * @param d This parameter is a double value to scale the terms in b[] and is equal to 1.0-c.
   * @return e[]; The combined array e[].
   */

	public static double[] add (double a[], double b[], double c, double d){
		double[] e;
		double shorter;
		if (a.length>b.length){
			e = new double[a.length];
			shorter = b.length;
		} else {
			e = new double[b.length];
			shorter = a.length;
		}

		for (int i = 0; i<e.length; i++){
			if(i<shorter){
				e[i] = a[i]*c + b[i]*d;
			} else {
				if(e.length == a.length){
					e[i] = a[i]*c + 0;
				} else if (e.length == b.length){
					e[i] = b[i]*d + 0;
				}
			}
		}
		return e;
	}

	/**
   * This method is for returning a smaller portion of the original array.
   * @param a[] This parameter is the array inputted to be copied.
   * @param b This parameter is the number term in a[] to begin d[].
   * @param c This parameter is the number term in a[] to terminate d[].
   * @return d[]; The copied array.
   */

	public static double[] copy (double a[], int b, int c){
		double[] d = new double[c-b];
		for (int i = 0; i<d.length; i++){
			d[i] = a[i+b];
		}
		return d;
	}

	/**
   * This method is for cutting a portion of the array out.
   * @param a[] This parameter is the initial array.
   * @param b This parameter is the first number term in a[] to be removed
   * @param c This parameter is the last number term in a[] to be removed.
   * @return d[]; The shortened array.
   */

	public static double[] cut (double a[], int b, int c){
		double[] d = new double[a.length-(c-b)];
		int count = 0;
		for (int i = 0; i<a.length; i++){
			if (i<b || i>(c-1)){
				d[count] = a[i];
				count++;
			}
		}
		return d;
	}

	/**
   * This method is for swapping two terms in an array.
   * @param a[] This parameter is the initial array.
   * @param c This parameter is the inputted number term of the first term to be switched.
   * @param d This parameter is the inputted number term of the second term to be switched.
   */

	private static void swap (double a[], int c, int d){
		double m = a[c];
		a[c] = a[d];
		a[d] = m;
		//printArray(a);
	}

}