package lesson7;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Data<String> data1 = new Data<>("roma@gmail.com", "USA", 8);
        Data<String> data2 = new Data<>("kirill@yahoo.com", "UKR", 2);
        Data<String> data3 = new Data<>("bohdan@gmail.com", "GER", 1);
        Data<String> data4 = new Data<>("dima1@yahoo.com", "UK", 7);
        Data<String> data5 = new Data<>("oleg@gmail.com", "UKR", 6);
        Data<String> data6 = new Data<>("nazar1@yahoo.com", "UKR", 4);
        Data<String> data7 = new Data<>("boris@gmail.com", "USA", 5);
        Data<String> data8 = new Data<>("ludmila@yahoo.com", "USA", 3);

        Pagination pagination = new Pagination(8, 8, 8);

        Response<String> response = new Response<>();
        response.setData(Arrays.asList(data1, data2, data3, data4, data5, data6, data7, data8));
        response.setPagination(pagination);

        response.sortData();
        System.out.println("Sorting by User id:");
        printResponse(response);
    }
    private static void printResponse(Response<String> response) {
        System.out.println("Data:");
        for (Data<String> data : response.getData()) {
            System.out.println("Email: " + data.getEmail() +
                    " || Geo: " + data.getGeo() +
                    " || User id: " + data.getUser_id());
        }

        System.out.println("Pagination:");
        System.out.println("Offset: " + response.getPagination().getOffset());
        System.out.println("Limit: " + response.getPagination().getLimit());
        System.out.println("Total: " + response.getPagination().getTotalCount());
    }
}


