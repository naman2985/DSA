package graph;

import java.util.Arrays;

public class AlienDictionary {
	char [] str;   // create a character array
	void create(int K){
		char x='a'; 
		for(int i=0;i<K;i++){
			str[i]=x;
			x++;
		}
	}
   
	int getindex(char Z){
		for(int i=0;i<str.length;i++){
			if(str[i]==Z){
				return i;
			}
		}
		return 0;
	}
   
	void swap(String s1,String s2 ){
		int size=Math.min(s1.length(),s2.length());
		int idx1;
		int idx2;
		char tmp=0;
		for(int i=0;i<size;i++){
			if(s1.charAt(i)!=s2.charAt(i)){
				idx1=getindex(s1.charAt(i));
				idx2=getindex(s2.charAt(i));
				if(idx1>idx2){
					tmp=str[idx1];
					str[idx1]=str[idx2];
					str[idx2]=tmp;
				}
				return ;
			}
		}    
	}
	public String findOrder(String [] dict, int N, int K)
	{
       // Write your code here
		str=new char[K];
		create(K);
		for(int j=0;j<K;j++)
			for(int i=0;i<N-1;i++)
				swap(dict[i],dict[i+1]);
		return Arrays.toString(str);
	}
	public static void main(String[] args) {
		
	}
}
