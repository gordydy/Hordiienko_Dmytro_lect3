package lesson7;

import java.util.List;

public class Response<T> {
    private List<T> data;
    private Pagination pagination;

    public Response() {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public void sortData() {
        data.sort(null);
    }
}






