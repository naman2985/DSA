package string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacter {
	static public int firstUniqChar(String s) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Character,Boolean> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),false);
            }
            else{
                map.put(s.charAt(i),true);
                q.add(i);
            }
        }
        for(int i=0;i<n;i++){
            if(map.get(s.charAt(i))) return i;
        }
        return -1;
    }
}
