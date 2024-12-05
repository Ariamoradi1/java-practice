import java.util.ArrayList;
import java.util.List;

class MemoryPool {
    private final byte[] pool;
    private final List<MemoryBlock> freeBlocks;
    private final int blockSize;

    public MemoryPool(int poolSize, int blockSize) {
        if (poolSize % blockSize != 0) {
            throw new IllegalArgumentException("Pool size must be a multiple of block size.");
        }

        this.pool = new byte[poolSize];
        this.blockSize = blockSize;
        this.freeBlocks = new ArrayList<>();

        for (int i = 0; i < poolSize; i += blockSize) {
            freeBlocks.add(new MemoryBlock(i, blockSize));
        }
    }

    public synchronized MemoryBlock allocate() {
        if (freeBlocks.isEmpty()) {
            throw new OutOfMemoryError("No free blocks available.");
        }
        return freeBlocks.remove(freeBlocks.size() - 1);
    }

    public synchronized void deallocate(MemoryBlock block) {
        if (block == null || block.getSize() != blockSize) {
            throw new IllegalArgumentException("Invalid block.");
        }
        freeBlocks.add(block);
    }

    static class MemoryBlock {
        private final int start;
        private final int size;

        MemoryBlock(int start, int size) {
            this.start = start;
            this.size = size;
        }

        public int getStart() {
            return start;
        }

        public int getSize() {
            return size;
        }

        public String toString() {
            return "MemoryBlock{start=" + start + ", size=" + size + "}";
        }
    }
}

public class MemoryPoolTest {
    public static void main(String[] args) {
        MemoryPool pool = new MemoryPool(1024, 128);

        MemoryPool.MemoryBlock block1 = pool.allocate();
        System.out.println("Allocated: " + block1);

        MemoryPool.MemoryBlock block2 = pool.allocate();
        System.out.println("Allocated: " + block2);

        pool.deallocate(block1);
        System.out.println("Deallocated block1.");

        MemoryPool.MemoryBlock block3 = pool.allocate();
        System.out.println("Allocated: " + block3);
    }
}
