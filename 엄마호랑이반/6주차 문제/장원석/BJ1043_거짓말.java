import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1043_거짓말 {

	static int[] parent;

	// 집합의 root node를 찾는다
	static int find(int x) {
		// 자기자신과 같다 = 루트노드
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	// 두 집합을 하나로 합친다
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b)
			parent[b] = a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int truthNum = Integer.parseInt(st.nextToken());

		// 진실을 아는 사람이 없다면 모든 파티에서 구라 가능
		if (truthNum == 0) {
			System.out.println(M);
			return;
		}

		int truth = Integer.parseInt(st.nextToken());
		for (int i = 1; i < truthNum; i++) {
			union(truth, Integer.parseInt(st.nextToken()));
		}

		List<List<Integer>> parties = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int partyNum = Integer.parseInt(st.nextToken());

			ArrayList<Integer> party = new ArrayList<>();

			// 파티의 첫 번째 사람
			int first = Integer.parseInt(st.nextToken());
			party.add(first);

			// 파티 참석자들을 하나의 그룹으로
			for (int j = 1; j < partyNum; j++) {
				int person = Integer.parseInt(st.nextToken());
				party.add(person);
				union(first, person);
			}

			parties.add(party);
		}

		int answer = 0;
		// 각 파티에서 거짓말 가능 여부 확인
		for (List<Integer> party : parties) {
			boolean canLie = true;

			for (int person : party) {
				if (find(person) == find(truth)) {
					canLie = false;
					break;
				}
			}

			if (canLie)
				answer++;
		}
		
		System.out.println(Arrays.toString(parent));
		System.out.println(parties);

		System.out.println(answer);
	}

}
