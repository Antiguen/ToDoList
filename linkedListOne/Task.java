package linkedListOne;
public class Task {
    private final String title;
    private final String description;
    private boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }
}
class Node {
    public Node next;
    public Task task;
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}
class ToDoList {
    private Node head;

    public void addToDo(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void markToDoAsCompleted(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.task.getTitle().equals(title)) {
                current.task.markCompleted();
                System.out.println("Task '" + title + "' marked as completed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task '" + title + "' not found.");
    }

    public void viewToDoList() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node current = head;
        System.out.println("To-Do List:");
        while (current != null) {
            String completionStatus = current.task.isCompleted() ? "Completed" : "Pending";
            System.out.println("- " + completionStatus + " : " + current.task.getTitle());
            current = current.next;
        }
    }
    public static void main(String[] args) {
        // Example usage
        ToDoList toDoList = new ToDoList();
        toDoList.addToDo(new Task("Buy groceries", "Sugar, Chocolate, Fruits"));
        toDoList.addToDo(new Task("Finish report", "Due tomorrow"));

        toDoList.viewToDoList();

        toDoList.markToDoAsCompleted("Buy groceries");
        toDoList.viewToDoList();
    }
}
