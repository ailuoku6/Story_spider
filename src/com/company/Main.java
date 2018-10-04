package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Spider spider = new Spider("http://www.gushi365.com");
        for (int i = 0;i<spider.getStories().size();i++){
            System.out.println(i+"  "+spider.getStories().get(i).getTitle()+"   "+spider.getStories().get(i).getLink());
        }
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println(spider.getStoryDetail(index));
    }
}
