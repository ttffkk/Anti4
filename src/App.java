public class App {
    public char[4][4] arr;
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
    public static void Placex(int a, int b){
        arr[a][b] = "X";
    }
    public static void Placeo(int a, int b){
        arr[a][b] = "O";
    }
    public static void checker()
}
