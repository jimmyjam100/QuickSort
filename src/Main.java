import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
	static int[] quickSort(int[] i, int start, int end, PrintWriter writer) {
		if (end - start == 1) {
			if (i[start] > i[end]) {
				int store = i[start];
				i[start] = i[end];
				i[end] = store;
			}
			//System.out.println(Arrays.toString(i));
		}
		
		else if(start < end) {
		int j = end-1;
		boolean cont = true;
		int k;
		for (k = start; k <= j; k++) {
			if (i[k] > i[end]) {
				cont = true;
				while(cont) {
					if(j <= k) 
					{
						cont = false;
					}
					else if(i[j] < i[end]) {
						cont = false;
						int store = i[j];
						i[j] = i[k];
						i[k] = store;
					}
					j--;
				}
				
			}
		}
		k--;
		if(i[k] > i[end]) {
			int store = i[k];
			i[k] = i[end];
			i[end] = store;
			//System.out.println(Arrays.toString(i));
			i = quickSort(i, start, k-1,writer);
			i = quickSort(i, k+1, end, writer);
		}
		else {
			int store = i[k+1];
			i[k+1] = i[end];
			i[end] = store;
			//System.out.println(Arrays.toString(i));
			i = quickSort(i, start, k, writer);
			i = quickSort(i, k+2, end, writer);
		}
	}
		writer.println(Arrays.toString(i));
		return i;
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		int size = 100;
		int[] i = new int[size];//{4, 5, 2, 3, 1};
		Random rand = new Random();
		for (int j = 0; j < size; j++) {
			i[j] = rand.nextInt(1000);
		}
		writer.println(Arrays.toString(i));
		i = quickSort(i, 0, size-1, writer);
		writer.close();

	}
}
