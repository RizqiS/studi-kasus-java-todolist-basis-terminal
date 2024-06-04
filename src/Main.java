import java.util.Scanner;

public class Main {

    /*
    * model data todolist
    * */
    public static String[] todo = new String[10];
    public static java.util.Scanner scanner = new Scanner(System.in);

    /*
    * run program main
    * */
    public static void main(String[] args) {
        viewShowTodoList();
    }

    /*
    * input
    * */
    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }



    /*
    * show todo list
    * */
    public static void showTodoList() {
        /* var count = 0;
        for(var item: todo) {
            var no = ++count;
            if(item != null) {
                System.out.println(no + "." + item);
            }
        } */

       for(var index = 0; index < todo.length; index++) {
           var no = index + 1;
           var item = todo[index];

           if(item != null) {
               System.out.println(no + "." + item);
           }
       }
    }

    /*
    * test todo list
    * */


    /*
    * add todo list
    * */
    public static void addTodoList(String todos) {

        /* check is todo full or not if pull resize size else not resize*/
        var fullied = true;
        for(var index = 0; index < todo.length; index++) {
            if(todo[index] == null) {
                fullied = false;
                break;
            }
        }
        if(fullied) {
            var temp = todo;
            todo = new String[todo.length * 2];
            for(var index = 0; index < temp.length; index++) {
                todo[index] = temp[index];
            }
        }

        /* add todo if todo value array is null */
        for(var index = 0; index < todo.length; index++) {
            if(todo[index] == null) {
                todo[index] = todos;
                return;
            }
        }
    }

    /*
    * remove todo list
    * */
    public static boolean removeTodoList(Integer id) {
        if((id - 1) >= todo.length) {
           return false;
        }
        if(todo[id - 1] == null) {
            return false;
        }

        for(var index = (id - 1); index < todo.length; index++) {
            if(index == (todo.length - 1)) {
                todo[index] = null;
            }else {
                todo[index] = todo[index + 1];
            }
        }

        return true;
    }


    /*
    * view todolist
    * */
    public static void viewShowTodoList() {
        System.out.println("TODO LIST");
        while(true) {
            showTodoList();
            System.out.println("MENU");
            System.out.println("1. add todo");
            System.out.println("2. remove todo");
            System.out.println("3. exit");
            var input = input("choose todo");

            switch (input) {
                case "1" -> viewAddTodoList();
                case "2" -> viewRemoveTodoList();
                case "3" -> {
                    return;
                }
                default -> System.out.println("your choose not found");
            }
        }
    }

    /*
    * view add todolist
    * */
    public static void viewAddTodoList() {
        System.out.println("VIEW ADD TODO LIST");
        var inputTodo = input("add todo (3. if exit)");

        if(inputTodo.equals("3")) {
            return;
        }
        addTodoList(inputTodo);
    }

    /*
    * view remove todolist
    * */
    public static void viewRemoveTodoList() {
        System.out.println("REMOVE TODO LIST");
        var id = input("remove todo (3. if exit)");

        if(id.equals("3")) {
            return;
        }

        var success = removeTodoList(Integer.valueOf(id));
        if(!success) {
            System.out.println("failed remove todolist : "+ Integer.valueOf(id));
        }
    }

    /*
    * test all todo: view, input, add, remove
    * */
    public static void testInput() {
        var name = input("what is your name ");
        System.out.println(name);
    }
    public static void testShowTodoList() {
        todo[0] = "learn next js with java spring bot";
        todo[1] = "learn next js with express";
        showTodoList();
    }
    public static void testAddTodoList() {
        for(var no = 1; no < 20; no++) {
            addTodoList("learn basic java today "+ no);
        }
        showTodoList();
    }
    public static void testRemoveTodoList() {
        addTodoList("todo 1");
        addTodoList("todo 2");
        addTodoList("todo 3");

        /*var res = removeTodoList(3);
        System.out.println(res);*/

        /*var valid = removeTodoList(1);
        System.out.println(valid);*/

        System.out.println(todo.length - 1);

        showTodoList();
    }
    public static void testViewShowTodoList() {
        for (int index = 0; index < todo.length; index++) {
            addTodoList("todo " + index);
        }
        viewShowTodoList();
    }
    public static void testViewAddTodoList() {
        // testViewShowTodoList();
        showTodoList();
    }
    public static void testViewRemoveTodoList() {
        addTodoList("todo 1");
        addTodoList("todo 2");
        addTodoList("todo 3");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}