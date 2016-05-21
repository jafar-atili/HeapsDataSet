
/**
 * Created by JafarAtili on 08/05/2016.
 */
public class S {


    //heapMax is the Maximum number of elements we can hold in our Data Set
    private static int heapMax = 1000;

    //heapSize is the current number of data we have
    private static int heapSize = 0;

    //our data set will hold our data in both Max-Heap and Min-Heap, the number will be recorded as a Value,
    //Value is an object with two attributes, 1. Val - which is the actual number 2. pointer - integer points to the location of the current number in the other heap (Arr).
    private static Value maxHeap[];
    private static Value minHeap[];


    //empty constructor, no need for him as all of our methods are static methods
    public S (){

    }


    //Build our Data Set
    public static void Build(int L[]){


        initiliazeHeaps(L);

        //regular Heap algorithm to build Max and Min heap in O(n)
        BuildMaxHeap(maxHeap);
        BuildMinHeap(minHeap);
    }

    //regular algorithm of Build-Max-Heap that building a maximum heap in O(n)
    public static void BuildMaxHeap(Value A[]) {
       int heapLong = heapSize - 1;
        for (int i = heapLong / 2; i >= 0; i--) {
            MaxHeapify(A, i);
        }
    }

    //regular algorithm of Build-Min-Heap that building a minimum heap in O(n)
    public static void BuildMinHeap(Value A[]){
        int heapLong = heapSize - 1;
        for (int i = heapLong / 2; i >= 0; i--) {
            MinHeapify(A, i);
        }
    }


    //initializing both Heaps by copying input Array to heaps and setting pointers - O(n)
    public static void initiliazeHeaps(int A[]){

        maxHeap = new Value[heapMax];
        minHeap = new Value[heapMax];
        heapSize = A.length;

        for (int i = 0 ; i < heapSize ; i++) {
            maxHeap[i] = new Value(A[i], i);
            minHeap[i] = new Value(A[i], i);
        }
    }

    //MinHeapify is reference method used by buildMinHeap - O(logN)
    public static void MinHeapify(Value A[], int i){
        int l,r , minimalest;
        l = Left(i);
        r = Right(i);
        if (l < heapSize && A[l].getVal() < A[i].getVal())
            minimalest = l;
        else
            minimalest = i;
        if (r < heapSize && A[r].getVal() < A[minimalest].getVal())
            minimalest = r;
        if (minimalest != i) {
            Exchange(A, i, minimalest, false);
            MinHeapify(A, minimalest);
        }

    }

    //MaxHeapify is a reference method used by BuildMaxHeap - O(logN)
    public static void MaxHeapify(Value A[], int i){
        int l,r, largest;
        l = Left(i);
        r = Right(i);
        if (l < heapSize && A[l].getVal() > A[i].getVal())
            largest = l;
        else
            largest = i;
        if (r < heapSize && A[r].getVal() > A[largest].getVal())
            largest = r;
        if (largest != i) {
            Exchange(A, i, largest ,true);
            MaxHeapify(A, largest);
        }

    }

    //return the Left son of i in heap
    public static int Left(int i){
        return (2*i) + 1;
    }

    //return Right son of i in heap
    public static int Right(int i){
        return (2*i) + 2;
    }


    //Exchange two indexes in Arr that holding the heap, and update the pointer of the value in the other Arr
    public static void Exchange (Value A[], int i, int j, boolean max) {

        if (max) {
            Value temp = new Value(0, 0);
            minHeap[A[j].getPointer()].setPointer(i);
            minHeap[A[i].getPointer()].setPointer(j);
            temp.copy(A[i]);
            A[i].copy(A[j]);
            A[j].copy(temp);
        }

        else
        {
            Value temp = new Value(0, 0);
            maxHeap[A[j].getPointer()].setPointer(i);
            maxHeap[A[i].getPointer()].setPointer(j);
            temp.copy(A[i]);
            A[i].copy(A[j]);
            A[j].copy(temp);
        }
    }



    //print MaxHeap arr (Value and the pointer of each)
    public static String PrintMaxHeap(){
        String s ="Max Heap:  ";
        for (int i = 0 ; i < heapSize ; i++)
           s = s + "["+maxHeap[i].getVal() +"] -> "+maxHeap[i].getPointer()+" , ";
        return s;
    }


    //Print MinHeap arr (Value and the pointer of each)
    public static String PrintMinHeap(){
        String s = "Min Heap:  ";
        for (int i = 0 ; i < heapSize ; i++)
            s = s +"["+minHeap[i].getVal() +"] -> "+minHeap[i].getPointer()+" , ";
        return s;
    }

    public static String Print(){
        String s = "";
        for (int i = 0 ; i < heapSize ; i++)
            s = s +"["+maxHeap[i].getVal() +"] , ";
        return s;
    }


    //FindingMax number in our data set in O(1) - as this number will be located in the first index of maxHeap
    public static int FindMax(){
        return maxHeap[0].getVal();
    }

    //Finding Min numbe in our data set in O(1) - as this number will be located always in the first index of MinHeap
    public static int FindMin(){
        return minHeap[0].getVal();
    }



    //Delete Max number in our data set (maxHeap), then remove it from other heap (minHeap), and re-arrange heap structure in both Arrays - O(logn)
    public static int DeleteMax (){
        int maximun = FindMax();
        int max = 0;
        int maxPointerInMinHeap = maxHeap[max].getPointer();
        int last = heapSize -1;

        if (heapSize < 1)
            System.out.print("Heap underflow\n");

        else {

            Exchange(maxHeap, max, last, true);
            Exchange(minHeap, maxPointerInMinHeap, last, false);

            heapSize--;

            MaxHeapify(maxHeap, 0);
            MinHeapify(minHeap, maxPointerInMinHeap);
            return  maximun;
        }
            return 0;

    }

    //Delete Min number in our data set (minHeap), then remove it from other heap (maxHeap), and re-arrange heap structure in both Arrays - O(logn)
    public static int DeleteMin(){
        int minimum = FindMin();
        int min = 0;
        int minPointerInMaxHeap = minHeap[min].getPointer();
        int last = heapSize -1;

        if (heapSize < 1)
            System.out.print("Heap underflow\n");

      else{

        Exchange(minHeap, min, last , false);
        Exchange(maxHeap, minPointerInMaxHeap, last, true);

        heapSize --;

        MinHeapify(minHeap, min);
        MaxHeapify(maxHeap, minPointerInMaxHeap);
        return minimum;}
        return 0;
    }



    public static void HeapIncreaseKey(Value[] A, int i){
        while (i > 0  && A[getParent(i)].getVal() < A[i].getVal()){
            Exchange(A, getParent(i), i, true);
            i = getParent(i);
        }

    }

    //return parent index of i
    public static int getParent(int i){
        if (i == 1)
            return 0;
        if (i % 2 == 0)
        return i/2 - 1;
        else return i/2 + 1;

    }


    //Inserting a number into both heaps and maintaining the heap structure for both by the reference methods
    public static void Insert( int key){
        heapSize ++;
        maxHeap[heapSize-1] = new Value(key, heapSize-1);
        minHeap[heapSize-1] = new Value(key, heapSize-1);
        //reference method to bubble up the inserted number to the correct place
        HeapIncreaseKey(maxHeap, heapSize-1);
        HeapDecreaseKey(minHeap, heapSize-1);
    }



    public static void HeapDecreaseKey(Value[] A, int i){
        while (i > 0 && A[getParent(i)].getVal() > A[i].getVal()){
            Exchange(A, getParent(i), i, false);
            i = getParent(i);
        }
    }


}
