package ds.reference.graph.matrix;

public class MatrixBasics {

    public static void main(String[] args) {
        int[][] a=new int[3][3];

        int count=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j]=count++;

            }

        }
        System.out.println("lenght or no of rows in matrix "+a.length);
        //if its guaranteed all columns have same value then print only the first colum
        System.out.println("lenght or no of columns in matrix "+a[0].length);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

        //no of diagonals in matrix
        /*
            0 1 2 3
            0 a b c
            1 d e f
            2 g h i
            3 k j l

            diagonals
            a    --
            db    starts from first element in row
            gec
            khf  -- --
            ji         starts from second elemtn in row
            l    --

            but khf comes twice
            so no of diagonals in matrix = forallrows one diagonal + forall columns1 diagonal -1(becuase one diagonal comes twice)

            total no of diagonals = m+n-1

            fo find next elemtn in diagonal
            //i row index j col index
            i=i-1
            j=j+1

            and for printing diagonals you have to take only first row and columns
         */
        //diagonl row wise
        for (int i = 0; i < a.length; i++) {
            int m=i;
            int n=0;
            while(m >=0){
                System.out.print(a[m][n]+" ");
                m=m-1;
                n=n+1;
            }
            System.out.println();
        }
      //every diaggonal ends in last column
        //every diagonal starts in last row
        for (int i = 1; i < a[0].length-1; i++) {
            int m=a.length-1;
            int n=i;
            while(n <=a[0].length-1){
                System.out.print(a[m][n]+" ");
                m=m-1;
                n=n+1;
            }
            System.out.println();

        }
    }

}
