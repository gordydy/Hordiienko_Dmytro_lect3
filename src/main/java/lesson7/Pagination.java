package lesson7;

public class Pagination {
    private int offset;
    private int limit;
    private int total;
    public Pagination(int offset, int limit, int totalCount) {
        this.offset = offset;
        this.limit = limit;
        this.total = totalCount;
    }



    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotalCount() {
        return total;
    }


}

