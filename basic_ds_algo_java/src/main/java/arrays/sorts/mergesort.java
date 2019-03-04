package arrays.sorts;


public class mergesort {

    public static void main(String args[]){

        int a[] = {1, 2, 4};
        int b[] = {3, 5, 6};
        int c[] = {5, 7, 2, 3, 8};
        //int c[] = {5, 7};

        c = sort(c);

        System.out.println("output:");
        for(int i = 0; i<c.length; i++){
            System.out.println(c[i]);
        }
    }

    public static int[] sort(int c[]){
        int cLen = c.length;

        if(cLen<2){
            System.out.println(c[0]);
            return c;
        }


        int mid = cLen/2;
        int aLen = mid;
        int bLen = cLen-mid;

        int a[] = new int[aLen];
        int b[] = new int[bLen];

        for(int i=0; i<mid; i++){
            a[i] = c[i];
        }

        for(int i=0; i<bLen; i++){
            b[i] = c[i+mid];
        }

        a = sort(a);
        b = sort(b);
        c = merge(a, b);

        return c;
    }

    public static int[] merge(int a[], int b[]){
        int na = a.length;
        int nb = b.length;
        int nc = na + nb;

        int ka = 0;
        int kb = 0;
        int kc = 0;

        int c[] = new int[nc];

        while(ka<na && kb<nb){
            if(a[ka]<b[kb]){
                c[kc] = a[ka];
                ka++;
            }
            else{
                c[kc] = b[kb];
                kb++;
            }

            kc++;
        }

        while(ka<na){
            c[kc++] = a[ka];
            ka++;
        }

        while(kb<nb){
            c[kc++] = b[kb];
            kb++;
        }

        return c;
    }
}
