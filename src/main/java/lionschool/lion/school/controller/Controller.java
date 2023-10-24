package lionschool.lion.school.controller;


import com.google.gson.Gson;
import lionschool.lion.school.domain.Author;
import lionschool.lion.school.service.MenuService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        MenuService menu = new MenuService();

        String fileName = "test.txt";

        try {

            FileWriter testWriter = new FileWriter(fileName , true);

            BufferedWriter bufferedWriter = new BufferedWriter(testWriter);


            String data = "텍스트 파일에 저장된 내용입니다.";

            // 데이터를 파일에 씁니다.
            bufferedWriter.write(data);
            while (true) {

                System.out.print("명령 : ");
                String input = in.next();
                if (input.equals("등록")) {
                    System.out.print("명언 : ");
                    String writers = in.next();
                    System.out.print("작가 : ");
                    String name = in.next();

                    menu.save(writers, name);

                    System.out.println(writers + "  " + name);
                }

                if (input.equals("목록")) {
                    menu.findAll();
                }

                if (input.equals("수정")) {
                    System.out.print("?id = ");
                    long findId = Integer.parseInt(in.next());

                    //TDD 를위해 임시 주석 처리
                    menu.update(findId);
                }

                if (input.equals("삭제")) {

                    System.out.print("?id = " );
                    long deleteId = Integer.parseInt(in.next());

                    menu.textDelete(deleteId);
                }

                //data json 파일 변형
                if (input.equals("포스트")){
                    List<Author> all = menu.jsPost();
                    Gson gson = new Gson();

                    String json = gson.toJson(all);

                    System.out.println(json);
                    bufferedWriter.write(all.toString());

                }

                if (input.equals("종료")) {
                    break;
                }


            }

            bufferedWriter.close();

            testWriter.close();

            System.out.println("파일 저장");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
