/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alg2bruteforcevsdivideandconquer;

/**
 *
 * @author drew
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] array = {1,-89,-6,5,8,20,23,61,-56,-94,21,15};
        
        //BruteForce(array);
        System.out.println(DivideAndConquer(array,0,array.length-1 ));
    }
    
    public static int BruteForce(int[] A){
        
        int sum=0;
        int max=Integer.MIN_VALUE;
        int maxi=0, maxj=0;
        
        for(int i = 0; i < A.length; i++){
         sum=0;
         
            for(int j=i;j<A.length;j++){
               sum+=A[j];
               if(sum>max){
                max=sum;
                maxj=j;
                maxi=i;
               }
            }  
        }
        System.out.println(maxi+" - "+maxj);
        return max;
       }
    
    
    public static int DivideAndConquer(int[] A, int l, int h){
    
  if(l>h)
   return 0;
  if(l==h)
   return A[l];

  
  int m=(int) Math.floor((double)((l+h)/2));
  int max=0;
  
  max=DivideAndConquer(A, l, m);
  max=Math.max(max,DivideAndConquer(A, m+1, h));
  
  
  int L=0;
  int R=0;
  int S=0;
  int minj = 0;
  int mini = 0;
  for(int i=m;i>=l;i--){
   S+=A[i];
   //System.out.println(l+" - "+h);
   
   if(S>L){
       L=S;
       mini = i;
   }
  }
  R=S=0;
  for(int i=m+1;i<=h;i++){
   S+=A[i];
   
   if(S>R){
       R=S;
       minj = i;
   }
  }
  max=Math.max(max, L+R);
  
  System.out.println(mini+" - "+minj);
  return max;     
 
  
 }
        
    
}
