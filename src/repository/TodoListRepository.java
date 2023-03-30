package repository;

//MEMBUAT REPOSITORY

import entity.TodoList;

//Membuat method logic yang akan digunakan :
//1. Mengambil/mendapatkan semua data todo list
//2. Menambah data todo list
//3. menghapus data todo list
public interface TodoListRepository {
//    mengambil semua todo list
    TodoList[] getAll();

//    menambah todo list
    void add(TodoList todoList);

//    menghapus todo list
    boolean remove(Integer number);
}
