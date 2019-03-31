
public class Heap {
    Integer arr[];
    Heap(){
        arr = new Integer[]{6, 8, 77, 38, 40, 100, 200, 138};
    }
    
    void traverse() {
        for (Integer i =0; i<arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print("\t");
        }
        System.out.println();
    }
    
    void swap(Integer p1, Integer p2) {
        Integer temp=arr[p1];
        arr[p1]=arr[p2];
        arr[p2]=temp;
    }
    
    void maxHeapify(Integer size, Integer pos) {
        Integer lc=2*pos+1;
        Integer rc=2*pos+2;
        Integer l=pos;
        if(rc < size)
            if(arr[rc] > arr[l])
                l = rc;
        if(lc < size)
            if(arr[lc] > arr[l])
                l = lc;
        if(l != pos) {
            swap(l, pos);
            maxHeapify(size, l);
        }
    }
    
    void buildMaxHeap(Integer size) {
        for (Integer i=size/2-1;i>=0;i--)
        {  
            maxHeapify(size,i); 
        }
    }
    
    void heapSort(Integer size) {
        buildMaxHeap(size);
        for(Integer i=size-1;i>=0;i--) {
            swap(0, i);
            maxHeapify(i,0);
        }
    }
    
    public static void main(String args[]) {
        Heap h=new Heap();
        h.traverse();
        h.heapSort(h.size());
        //h.maxHeapify(5);
        h.traverse();
    }

    private Integer size() {
        return arr.length;
    }
}