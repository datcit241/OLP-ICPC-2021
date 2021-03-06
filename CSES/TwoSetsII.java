import java.io.*;
import java.util.*;

public class TwoSetsII {

	public static void main(String[] args) {
		solution1();
	}
	
	static void solution1() {
		int n = ni();
		
		int sum = (n % 2 == 0) ? (n + 1) * (n / 2) : (n * n - 1) / 2 + (n + 1) / 2;
		
		if (sum % 2 != 0) {
			System.out.print("0");
			return;
		}
		
		int halfSum = sum / 2;
		
		double[] arr3 = new double[halfSum + 1];
		
		for (int i = 1; i <= n; i++) {
			
			for (int j = halfSum; j >= i + 1; j--) {
				arr3[j] += arr3[j - i];
				if (Double.compare(arr3[j], 1000000007d) > 0) {
					arr3[j] -= 1000000007d;
				}
			}
			arr3[i] += 0.5d;
			
		}
		
		StringBuilder sb = new StringBuilder();

		sb.append((int) arr3[halfSum]);

		System.out.print(sb);
	}
	
	static void solution2() {
		int n = ni();
		
		int sum = (n % 2 == 0) ? (n + 1) * (n / 2) : (n * n - 1) / 2 + (n + 1) / 2;
		
		if (sum % 2 != 0) {
			System.out.print("0");
			return;
		}
		
		int halfSum = sum / 2;
		
		long[] arr = new long[halfSum + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = halfSum; j >= i + 1; j--) {
				arr[j] += arr[j - i];
				arr[j] %= 2000000014l;
			}
			arr[i]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append((arr[halfSum] / 2));

		System.out.print(sb);
	}
	
	static InputStream is = System.in;
	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}
	
	static boolean isSpaceChar2(int c) {
		return !(c >= 32 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}
	
	static String nextLine() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar2(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}
