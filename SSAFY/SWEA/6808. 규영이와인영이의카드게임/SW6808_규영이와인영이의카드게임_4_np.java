package ps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW6808_규영이와인영이의카드게임_4_np {
	static int T, win, lose, N = 9;
	static int[] input = new int[19];
	static int[] guCard = new int[9]; // 테케에서 고정
	static int[] inCard = new int[9]; // np 에 의해 스스로 순열의 경우의 수로 계속 바뀜

	static boolean[] select = new boolean[N];

	public static void main(String[] args) throws Exception {
//	    System.setIn(new FileInputStream("SWEA6808.txt"));
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());

	    for (int t = 1; t <= T; t++) {
	        // 초기화
	        win = 0;
	        lose = 0;
	        Arrays.fill(input, 0);

	        StringTokenizer st = new StringTokenizer(br.readLine());
	        // 규영이 카드
	        int num = 0;
	        for (int i = 0; i < N; i++) {
	            num = Integer.parseInt(st.nextToken());
	            guCard[i] = num;
	            input[num] = 1; // 인영이카드 설정
	        }
	        // 인영이 카드 - 순열의 src
	        num = 0; // 맨 앞, 계속 증가
	        for (int i = 1; i <= 18; i++) { // 규영이와 달리 인영이는 이미 정렬 되어 있음
	            if (input[i] == 0)
	                inCard[num++] = i;
	        }
	        
	        // 정렬
	        // 정렬한 결과도 하나의 경우의 수
	        // 인영이의 카드는 이미 정렬되어 있다. (작은수 -> 큰수) ( 가장 작은 수 )
	        // np 이용
	        while(true) {
	            // complete code
	            check();
	            if( !np() ) break;
	            
	        }
	        
	        
	        System.out.println("#" + t + " " + win + " " + lose);
	        
	    }

	}

	// 이거 외우기
	static boolean np() {

	    
	    int[] src = inCard;
	    int i = src.length - 1;
	    while( i > 0  && src[i-1] >= src[i]) --i;
	    if( i == 0) return false; // 더 이상 갈 수 없다.
	    
	    int j = src.length - 1;
	    while(src[i-1] >= src[j])  --j; // 1보다 더 큰수있는지?
	    swap(src, i-1, j);
	    
	    int k = src.length - 1;
	    while( i < k) {
	        swap(src, i++, k--);
	    }
	    
	    return true;        // 더 이상 해당 사항이 없을 때.
	}

	static void swap( int[] array, int i, int j ) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	}
	static void check() {
	    int guSum = 0;
	    int inSum = 0;
	    
	    for (int i = 0; i < N; i++) {
	        if( guCard[i] > inCard[i] ) guSum += guCard[i] + inCard[i];
	        else if ( guCard[i] < inCard[i]) inSum += guCard[i] + inCard[i];
	    }
	    if( guSum > inSum ) win++;
	    else if( guSum < inSum ) lose++;
	    
	    
	    
	}
	}
