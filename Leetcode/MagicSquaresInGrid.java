import java.util.*;

public class MagicSquaresInGrid{
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length<3 || grid[0].length<3)
        return 0;
        int count=0;

        //selecting 3x3 grids
        for(int i=0;i<=grid.length-3;i++){
            for(int j=0;j<=grid[0].length-3;j++){


                int flag=0;
                HashMap<Integer,Integer> m = new HashMap<>();
                int rowsum = 0,diasum = 0;

                //traversing the grids
                for(int k=i;k<i+3;k++){
                    int rsum=0;
                    for(int f=j;f<j+3;f++){
                        if(grid[k][f]>9 || grid[k][f]<=0){
                            flag++;
                            break;
                        }

                        //diagonal sum
                        if(i-k==j-f)
                        diasum+=grid[k][f];

                        //checking if the number present in the hashmap
                        if(m.containsKey(grid[k][f])){
                            flag++;
                            break;
                        }

                        //addding into the hashmap and adding rowsum
                        m.put(grid[k][f],1);
                        rsum+=grid[k][f];
                        System.out.print(grid[k][f]+" ");
                    }
                    System.out.println(rowsum+" "+rsum);

                    //checking rowsum
                    if(rowsum==0){
                        rowsum = rsum;
                    }else{
                        if(rowsum!=rsum){
                            flag++;
                            break;
                        }
                    }
                    System.out.println();
                }

                //if no flag and rowsum == diasum
                if(rowsum == diasum && flag==0){
                    for(int f=j;f<j+3;f++){
                        int csum = 0;
                        for(int k=i;k<i+3;k++){
                            csum+=grid[k][f];
                        }

                        //checking csum with rowsum
                        if(csum!=rowsum){
                            flag++;
                            break;
                        }
                    }
                }
                else{
                    flag++;
                }

                //adding count
                if(flag==0){
                    count++;
                }
            }
        }
        return count;
    }


}