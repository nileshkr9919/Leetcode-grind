class LRUCache {
    private cache: Map<number, number>;
    private capacity: number;
    constructor(capacity: number) {
        this.cache = new Map();
        this.capacity = capacity;
    }

    get(key: number): number {
        if(this.cache.has(key)) {
            const value = this.cache.get(key);
            this.cache.delete(key);
            this.cache.set(key, value);
            return value;
        }
        return -1;
    }

    put(key: number, value: number): void {
        if(this.cache.has(key)) {
            this.cache.delete(key);
        }
        if(this.cache.size >= this.capacity) {
            this.cache.delete(this.cache.keys().next().value);
        }
        this.cache.set(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */