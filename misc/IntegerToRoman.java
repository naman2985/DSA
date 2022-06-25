package misc;

import java.util.HashMap;

public class IntegerToRoman {
	public String intToRoman(int num) {
        HashMap<Integer,String> map=new HashMap<>();
        StringBuilder roman=new StringBuilder("");
        int rep,div=1000;
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        while(num>0){
            if(num>=9*div){
                roman.append(map.get(div));
                roman.append(map.get(10*div));
                num-=9*div;
            }
            if(num>=5*div){
                roman.append(map.get(5*div));
                num-=5*div;
            }
            rep=num/div;
            num%=div;
            if(rep==4){
                roman.append(map.get(div));
                roman.append(map.get(5*div));
            }
            else{
                for(int i=0;i<rep;i++) roman.append(map.get(div));
            }
            div/=10;
        }
        return roman.toString();
    }
}
