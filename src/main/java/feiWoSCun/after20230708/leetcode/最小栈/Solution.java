package feiWoSCun.after20230708.leetcode.最小栈;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/23
 * @Email: 2825097536@qq.com
 */
class MinStack {
    public static void main(String[] args) {
        System.out.println(-6/2);
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int capicity;
    Stack<Integer> st = new Stack<Integer>();
    int min = Integer.MAX_VALUE;

    public MinStack() {
        st.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        q1.offer(val);
        st.push(Math.min(st.peek(),val));

    }

    public int transfer() {
        int val = 0;
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                int val1 = q1.poll();
                q2.offer(val1);
            }
            if (q1.size() == 1) {
                val = q1.poll();
            }
        }
        return val;
    }
    private void exchange(){
        Queue<Integer> temp = null;
        //swap
        temp =this.q1;
        this.q1 = this.q2;
        this.q2 = temp;
    }
    public void pop() {
        this.transfer();
        this.exchange();
        st.pop();
    }

    public int top() {
        int val = this.transfer();
        q2.offer(val);
        this.exchange();
        return val;
    }

    public int getMin() {
        return st.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */