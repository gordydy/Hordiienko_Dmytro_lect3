package lesson7;

public class Data<T> implements Comparable<Data<T>> {
    private T email;
    private T geo;
    private int user_id;

    public Data(T email, T geo, int user_id) {
        this.email = email;
        this.geo = geo;
        this.user_id = user_id;
    }

    public T getEmail() {
        return email;
    }

    public T getGeo() {
        return geo;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public int compareTo(Data<T> x) {
        return Integer.compare(this.user_id, x.user_id);
    }
}
