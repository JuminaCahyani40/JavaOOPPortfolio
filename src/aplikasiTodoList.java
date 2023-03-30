public class aplikasiTodoList {

    public static String[] model = new String[10];


    //    variabel scanner dengan tipe data scanner, input system.in digunakan untuk menerima inputan dari user
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        viewShowTodoList();
    }

    /*
    Menampilkan todo List
     */
    public static void showTodoList(){
        System.out.println("TODOLIST");
        for(var i = 0;i < model.length;i++){
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

//    test method showTodoList
    public static void testShowTodoList(){
//        agar dapat terlihat hasilnya maka harus menambahkan data terlebih dahulu
        model[0] = "Belajar java";
        model[1] = "belajar javascript";

//        kemudian ditampilkan
        showTodoList();
    }

//    Menambah todo Ke List
    public static void addTodoList(String todo){

//        cek apakah model penuh?
        var penuh = true;
        for(var i = 0;i < model.length; i++){
            if(model[i] == null){
                penuh = false;
                break;
            }
        }

//        jika penuh maka resize ukuran model array menjadi 2x lipat

//        code ini akan menghapus data array yang tersimpan sebelumnya
//        model = new String[model.length * 2];


//        agar data dalam array sebelumnya tidak hilang, maka data disimpan dahulu di variabel temporary

        if (penuh){
            var temp = model;
            model = new String[model.length * 2];

            for(int i = 0; i < temp.length; i++){
                model[i]=temp[i];
            }
        }

//        Menambahkan data todo ke list dan tidak boleh ada yang kosong sehingga
//        tambahkan ke posisi yang data array nya null

        for(var i = 0; i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

//    test addTodoList
    public static void testAddTodoList(){
        for(int i = 0; i < 25; i++){
            addTodoList("Percobaan ke-" + i);
        }

        showTodoList();
    }


//    Mneghapus todo dari list
    public static boolean removeTodoList(Integer number){
//        menghapus number dimulai dari 1, sedangkan dari array nya dimulai dari 0
        if((number - 1) >= model.length){
            return false;
            //        jika sebelumnya model null atau tidak ada datanya, maka 
        } else if (model[number-1] == null) {
            return false;
        } else {
//            code ini masih belum menggeser angka jika todo list nya dihapus
//            model[number-1] = null;
//            return true;
//            sehingga, dapat menggnakan code berikut :
            for (int i = (number - 1); i < model.length; i++){
//                untuk menghindari out of bound --> jika jumlah data array 10 dan yang dihapus adalah
//                angka 10, maka yang digeser ke atas adalah data ke 11. akan tetapi data 11 tidak ada,
//                sehingga diisi null
                if (i == (model.length-1)){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");

        var result = removeTodoList(2);
            System.out.println(result);

            showTodoList();
    }

//    input --> return string karna ingin menerima input data dari user dan return nya berupa string
//    perlu membuat variable scanner dg tipe data scanner di atas
    public static String input(String info){
//        data merupakan inputan dari user
//        setelah user input data, maka data di return menggunakan scanner.nextLine() dan disimpan di variabel data
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("programmer");
        System.out.println((channel));
    }

//    View menampilkan todo list
    public static void viewShowTodoList(){
        while(true){
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. x");

            var input = input("Pilih");

//            agar todo list terus menerus tampil maka menggunakan perulangan while
//            equals untuk komparasi pada string. sedangkan untuk int menggunkan ==
            if(input.equals("1")){
//                karna ingin menambahkan jadi harus pindah view
                viewAddTodoList();
            } else if(input.equals("2")){
                viewRemoveTodoList();
            } else if(input.equals("x")){
                break;
            } else{
                System.out.println("pilihan tidak ditemukan");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("SATU");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        viewShowTodoList();
    }

//    view menambahkan todo list
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODO LIST");

        var todo = input("todo (x jika batal");

        if(todo.equals("x")){
//            batal
        } else {
            addTodoList(todo);
        }
    }

//    testview ada todo list
    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

//    view menghapus todo dari list
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor yang dihapus (x jika batal)");

        if(number.equals("x")){
//            batal
        } else{
//            karna number yang di inputkan di awal berupa string, maka id konvert terlebih dahulu ke int
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }

    }

    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
