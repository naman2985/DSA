package hashing;

import java.util.HashMap;

public class BalloonEverywhere {
	public static int maxInstance(String s) {
        // Code here
        HashMap<Character,Integer> count = new HashMap<>();
        int n = s.length(),instances = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int temp = 0;
            char c = s.charAt(i);
            if(count.containsKey(c)) temp = count.get(c);
            count.put(s.charAt(i),temp+1);
        }
        if(!(count.containsKey('b') && count.containsKey('a') && count.containsKey('l') && count.containsKey('o') && count.containsKey('n')))
            return 0;
        
        instances = Math.min(instances, count.get('b'));
        instances = Math.min(instances, count.get('a'));
        instances = Math.min(instances, count.get('n'));
        instances = Math.min(instances, count.get('o')/2);
        instances = Math.min(instances, count.get('l')/2);
        return instances;
    }
}
