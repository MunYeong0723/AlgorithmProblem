import java.util.Scanner;

class Trie {
//    boolean is_end = false;
    Trie[] children = new Trie[4];
    Trie(){}

    public int char_to_index(char key){
        switch (key){
            case 'A' : return 0;
            case 'C' : return 1;
            case 'G' : return 2;
            case 'T' : return 3;
            default: return -1;
        }
    }

    public boolean insert(char[] marker, int m) {
        Trie now = this;

        for(int i = 0; i < m; i++){
            int index = char_to_index(marker[i]);
            if(index == -1) return false;

            if(now.children[index] != null) { now = now.children[index]; } // 해당 char이 이미 tree에 있는 경우
            else {
                now.children[index] = new Trie();
                now = now.children[index];
            }
        }
        return true;
    }

    public Trie find(char key, Trie now){
        return now.children[char_to_index(key)];
    }

    public int searh_DNA(char[] dna, int n, int m) {
        int count = 0;
        for(int i = 0; i <= n-m; i++){
            Trie now = this;
            for(int j = i; j < i+m; j++) {
                now = find(dna[j], now);
                if(now == null) break;
            }
            if(now != null) count++;
        }
        return count;
    }
}
public class _10256 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt(); // 문자열의 길이
            int m = sc.nextInt(); // marker의 길이
            sc.nextLine();

            String tp = sc.nextLine();
            char[] DNA = tp.toCharArray();
            String tmp = sc.nextLine();
            char[] marker = tmp.toCharArray();

            Trie tree = new Trie();
            // tree에 marker 모든 경우 insert
            tree.insert(marker, m);
            for(int size = 2; size <= m; size++){
                for(int left = 0; left <= m-size; left++){
                    char[] one_marker = new char[m];

                    int index = 0;
                    while(index < left) one_marker[index] = marker[index++];
                    int right = left+size-1;
                    while(right >= left) one_marker[index++] = marker[right--];
                    while(index < m) one_marker[index] = marker[index++];

                    tree.insert(one_marker, m);
                }
            }
            System.out.println(tree.searh_DNA(DNA, n, m));
        }
    }
}
