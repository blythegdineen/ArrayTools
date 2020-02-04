public class ArrayTools {
	public static void printArray (double a[]) {
		for (int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static double max(double a[]) {
		double max = Double.NEGATIVE_INFINITY;
		for (int i = 0; i<a.length; i++) {
			if (a[i] > max) max = a[i];
		}
		return max;
	}


	public static double min(double a[]) {
		double min = Double.POSITIVE_INFINITY;
		for (int i = 0; i<a.length; i++) {
			if (a[i] < min) min = a[i];
		}
		return min;
	}

	public static double mean(double a[]) {
		double sum = 0.0;
		for (int i= 0; i< a.length; i++) {
			sum +=a[i];
		}
		double average = sum/a.length;
		return average;
	}

	public static double[] copy(double a[]) {
		double[] b = new double[a.length];
		for (int i = 0; i< a.length; i++) {
			b[i] = a[i];
		}
		return b;
	}

	public static double[] reverse(double a[]) {
		double[] b = new double[a.length];
		for (int i = 0; i<a.length/2; i++) {
			double temp = a[i];
			b[i] = a[a.length -1 -i];
			b[a.length-i-1] = temp; 
		}
		return b;
	}

	public static boolean areEqual (double a[], double b[]) {
		if (a.length == b.length) {
			for (int i = 0; i< a.length; i++) {
				if (a[i] != b[i]) {
					return false;
				} 
			}
			return true;
		} else {return false;}
	}

	public static double[] scale(double a[], double c) {
		double[] b = new double[a.length];
		for (int i = 0; i<a.length; i++) {
			b[i] = a[i]*c;
		}
		return b;
	}

	public static double[] add(double a[], double b[], double c, double d) {
		double[] e;
		if (a.length > b.length) {
			e = new double[a.length];
		} else {
			e = new double[b.length];
		}

		for (int i = 0; i< e.length; i++) {
			e[i] = a[i]*c + b[i]*d;
		}

		return e;
	}

	public static double[] copy(double a[], int b, int c) {
		double[] d = new double[c-b];
		for (int i = 0; i<d.length; i++) {
			d[i] = a[i+b];
		}
		return d;
	}

	public static double[] cut(double a[], int b, int c) {
		double[] d = new double[a.length- (c-b)];
		int counter = 0;
		for (int i = 0; i<a.length; i++) {
			if (i < b || i > (c-1)) {
				d[counter] = a[i];
				counter++;
			}
		} 
		return d;
	}

	private static void swap(double a[], int c, int d) {
		double e = a[d];
		a[d] = a[c];
		a[c] = e;
	}

	private static double[] shuffle(double a[]) {
		int random = (int) (Math.random()*a.length);
		double[] b = new double[a.length];
		for (int i = 0; i<a.length; i++){
			b[i] = a[i];
		}
		for (int j = 0; j<b.length; j++){
			swap(a,j, random);
		}
	}

	public static void main(String args[]) {
        double[] a = {1.0, 3.0, 5.0, 7.0, 9.0, 10.0};
        double[] b = {2.0, 23, 72, 19, 54, 45};
        System.out.println("original:");
        printArray(a);

        System.out.println("\nreverse:");
        printArray(reverse(a));

        System.out.println("\ncopy:");
        printArray(copy(a, 2, 5));

        System.out.println("\ncut:");
        printArray(cut(a, 2, 4));

        System.out.println("\nswap:");
        swap(a, 3, 5);

    }

}