package service;

import repository.TodoListRepository;
import entity.TodoList;

public class TodoListServiceImpl implements TodoListService{

//    model akan error, tpi akan diganti dan diakses melalui repository.
//    shg membuat field RepositoryTodoList
    private TodoListRepository todoListRepository;

//constructor
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();
        System.out.println("TODOLIST");
        for(var i = 0;i < model.length;i++){
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("SUKSES MENAMBAHKAN TODO : " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if(success){
            System.out.println("Sukses Menghapus TODO " + number);
        } else{
            System.out.println("Gagal Menghapus TODO " + number);
        }
    }
}
