package lesson7;

public class Data implements Comparable<Data> {
    private String email;
    private String geo;
    private int userId;

    public Data(String email, String geo, int userId) {
        this.email = email;
        this.geo = geo;
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public String getGeo() {
        return geo;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public int compareTo(Data x) {
        return Integer.compare(this.userId, x.userId);
    }
}
