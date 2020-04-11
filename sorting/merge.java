class merge{
    public static void main(String args[]) {
        int ar[] = new int[]{2, 4, 5, 1, 0, 7};
        merge obj = new merge();
        obj.part(0, 6, ar);
    }
    void part(int low, int high, int ar[]) {
        merge obj = new merge();
        if(low>=high) return;
        obj.part(low, (high-low)/2 - 1, ar);
        for(int i = low; i < (high-low)/2; i++) System.out.print(ar[i]);
        System.out.println();
        //obj.part((high-low)/2,high, ar);
        for(int i = (high-low)/2; i < high; i++) System.out.print(ar[i]);
        System.out.println();
    }
}