package sorts;

public class quicksort {

    public static void main(String[] args) {
        int c[] = {6, 9, 2, 8, 7, 3, 1, 4, 5};
        sort(c, 0, c.length-1);

        // print array
        printArray(c);
    }

    // sort
    public static void sort(int c[], int start, int end){
        if(start < end) {
            int pi = partition(c, start, end);
            sort(c, start, pi-1);
            sort(c, pi+1, end);
        }
    }

    // sort - partition
    public static int partition(int c[], int start, int end){
        //System.out.println("start-"+start);
        //System.out.println("end-"+end);
        int pe = c[end];
        int pi = start;

        for(int i=start; i<=end-1; i++){
            //System.out.println(i+"-"+c[i]);
            if(c[i]<pe){
                swap(c, pi, i);
                pi++;
            }
        }

        swap(c, pi, end);
        System.out.print(". pi-"+pi);
        return pi;
    }

    // sort - swap
    public static void swap(int c[], int pos1, int pos2){
        //System.out.println("swap:"+pos1+","+pos2);
        //System.out.println("swap val:"+c[pos1]+","+c[pos2]);
        int temp = c[pos1];
        c[pos1] = c[pos2];
        c[pos2] = temp;
    }

    public static void printArray(int c[]) {
        System.out.println("\n\noutput:");
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
    }
}
