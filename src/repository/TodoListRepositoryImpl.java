package repository;

import entity.TodoList;

// untuk method ini digunakan di repository karna jika nanti akan ada perubahan code, misal akan konversi array ke collection
// maka yg diubah logic code di repository, bukan melalui service

public class TodoListRepositoryImpl implements TodoListRepository{

    public TodoList[] data = new TodoList[10];
    @Override
    public TodoList[] getAll() {
        return data;
    }
//    buat method baru
    public boolean isFull(){
//        cek apakah model penuh?
        var isFull = true;
        for(var i = 0;i < data.length; i++) {
            if (data[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIfFull(){
//jika penuh maka resize ukuran array 2x lipat
        if (isFull()){
            var temp = data;
            data = new TodoList[data.length * 2];

            for(int i = 0; i < temp.length; i++){
                data[i]=temp[i];
            }
        }

    }
    @Override
    public void add(TodoList todoList) {
        resizeIfFull();
//        Menambahkan data todo ke list dan tidak boleh ada yang kosong sehingga
//        tambahkan ke posisi yang data array nya null

        for(var i = 0; i < data.length; i++){
            if(data[i] == null){
                data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
//menghapus number dimulai dari 1, sedangkan dari array nya dimulai dari 0
        if((number - 1) >= data.length){
            return false;
//jika sebelumnya model null atau tidak ada datanya, maka
        } else if (data[number-1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++){
                if (i == (data.length-1)){
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
