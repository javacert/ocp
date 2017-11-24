package javaexamples.cert.collections.queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

// Notes
// 1. You cannot put null in an ArrayDeque because methods like poll() use null as a special return to indicate that the
//    collection is empty.

// Scenarios - when to use?
// 1. When you want to pick something from a stack of maps (LI-FO data structure). Stack could be used, but shouldn't be for new code.
public class ArrayDequeExamples {

    public static void main(String[] args){
        usingArrayDequeAsAQueue();
        usingArrayDequeAsAStack();
    }

    // When used as a Queue, you add to the back and take off at the front
    private static void usingArrayDequeAsAQueue() {
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println(queue.offer(10));    // true - Queue is 10
        System.out.println(queue.offer(4));     // true - Queue is 10, 4
        System.out.println(queue.peek());         // 10
        System.out.println(queue.poll());         // 10
        System.out.println(queue.poll());         // 4
        System.out.println(queue.peek());         // null
    }

    // When used as a Stack, you add to the top and remove from the top
    private static void usingArrayDequeAsAStack() {
        Deque<Integer> stack = new ArrayDeque<>(); // Notice the Deque interface
        stack.push(10); // Stack is 10
        stack.push(4);  // Stack is 4, 10
        System.out.println(stack.peek());         // 4
        System.out.println(stack.poll());         // 4
        System.out.println(stack.poll());         // 10
        System.out.println(stack.peek());         // null
    }
}
