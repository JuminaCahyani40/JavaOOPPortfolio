package entity;


//MEMBUAT ENTITY

public class TodoList {
    public String todo;

//    constructor tanpa parameter
    public TodoList(){

    }

//    constructor with parameter
    public TodoList(String todo) {
        this.todo = todo;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
