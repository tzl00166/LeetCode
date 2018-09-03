class MovingAverage {
    
    Queue<Integer> queue;
    public int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }
    
    public double next(int val) {
        double sum = 0;
        while(queue.size() >= size)
            queue.poll();
        
        queue.offer(val);
        for(int num : queue)
            sum += num;
        
        return (double)(sum / queue.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */