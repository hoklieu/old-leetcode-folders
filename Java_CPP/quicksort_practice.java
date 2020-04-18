    public static void qs(int[] num,int beg, int end) {
        //base case:
        if (beg >= end) {
            return;
        }
        int left = beg;
        int right = end;
        int partition = partition(num,left,right);
        //num[partition] is in place
        qs(num,left,partition - 1);
        qs(num,partition + 1,right);
    }

    private static int partition(int[] num,int left,int right) {
        int lptr = left;
        int rptr = right;
        //element to be swaped in place after partition
        int pivot = num[right];

        while (true) {
            while (num[lptr] < pivot) lptr ++;
            while (rptr > left && num[--rptr] > pivot);
            //partially sorted, then exit
            if (lptr >= rptr) break;
            //else, swpa lptr and rptr
            else {swap(num,lptr,rptr);}
        }
        //move pivot to where it should be
        swap(num,lptr,right);
        return lptr;
    }

    private static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    public static void main(String[] args) {
        int[] tobemerged = new int[]{1,3,43,23,44,32,34};
//        int[] result = mergeSort(tobemerged);
        qs(tobemerged,0,tobemerged.length - 1);
        for (int i = 0; i < tobemerged.length; i++) {
            System.out.println(tobemerged[i]);
        }
    }