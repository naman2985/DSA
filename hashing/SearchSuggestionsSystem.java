package hashing;
import java.util.*;
// leetcode #1268
public class SearchSuggestionsSystem {
	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestions=new ArrayList<>();
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        Arrays.sort(products);
        int m=searchWord.length(),n=products.length;
        for(int i=0;i<n;i++){
            int l=products[i].length();
            for(int j=0;j<m && j<l;j++){
                String sub=products[i].substring(0,j+1);
                if(!map.containsKey(sub))
                    map.put(sub,new ArrayList<>());
                map.get(sub).add(i);
            }
        }
        for(int i=0;i<m;i++){
            suggestions.add(new ArrayList<>());
            String sub=searchWord.substring(0,i+1);
            if(map.containsKey(sub)){
                for(int j=0;j<map.get(sub).size()&&j<3;j++){
                    suggestions.get(i).add(products[map.get(sub).get(j)]);
                }
            }
        }
        return suggestions;
    }
}
