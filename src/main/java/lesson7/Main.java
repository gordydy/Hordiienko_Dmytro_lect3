package lesson7;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Data data1 = new Data("roma@gmail.com", "USA", 8);
        Data data2 = new Data("kirill@yahoo.com", "UKR", 2);
        Data data3 = new Data("bohdan@gmail.com", "GER", 1);
        Data data4 = new Data("dima1@yahoo.com", "UK", 7);
        Data data5 = new Data("oleg@gmail.com", "UKR", 6);
        Data data6 = new Data("nazar1@yahoo.com", "UKR", 4);
        Data data7 = new Data("boris@gmail.com", "USA", 5);
        Data data8 = new Data("ludmila@yahoo.com", "USA", 3);

        Pagination pagination = new Pagination(8, 8, 8);

        Response<Data> response = new Response<>();
        response.setData(Arrays.asList(data1, data2, data3, data4, data5, data6, data7, data8));
        response.setPagination(pagination);

        response.sortData();
        System.out.println("Printing response sorting by user id:");
        printResponse(response);

    }

    private static void printResponse(Response<Data> response) {
        for (Data data : response.getData()) {
            System.out.println("\"Data\": { ");
            System.out.println("  \"Email\": " + "\"" + data.getEmail() + "\"" +
                    "\n" + "  \"Geo\": " + "\"" + data.getGeo() + "\"" +
                    "\n" + "  \"User_id\": " + data.getUserId() + "\n" + "}");
        }

        System.out.println("Pagination:");
        System.out.println("Offset: " + response.getPagination().getOffset());
        System.out.println("Limit: " + response.getPagination().getLimit());
        System.out.println("Total: " + response.getPagination().getTotalCount());
    }
}


