public class App {
    public int[][] arr;
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    
    public static void printer(){
        for(int z=0;z<arr.size;z++){
            for(int y=0;y<arr[z].size;y++){
                System.out.print(arr[z][y]);
            }
            System.out.println();
        }
    }
}
