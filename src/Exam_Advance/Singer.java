package Exam_Advance;

import java.util.Scanner;

public class Singer {
    private static int nextSingerId = 1;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;


    public Singer( String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public Singer() {
        this.singerId = nextSingerId++;
    }

    public static int getNextSingerId() {
        return nextSingerId;
    }

    public static void setNextSingerId(int nextSingerId) {
        Singer.nextSingerId = nextSingerId;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public void inputData(){

        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tên ca sĩ:");
        while (true){
            this.singerName=scanner.nextLine();
            if (singerName.length()>=0){
                break;
            }else {
                System.out.println("Tên ca sĩ không được bỏ trống");
            }
        }
        System.out.println("Nhập tuổi của ca sĩ:");
        while (true){
            this.age= Integer.parseInt(scanner.nextLine());
            if (age>0){
                break;
            }else {
                System.out.println("Tuổi phải lớn hơn 0");
            }
        }
        System.out.println("Nhập giới tính:");
        String genderInput = scanner.nextLine().toLowerCase();
        this.gender = genderInput.equals("nam");

        System.out.println("nhap quoc tich");
        while (true){
            this.nationality= scanner.nextLine();
            if (nationality.length()>0){
                break;
            }else {
                System.out.println("Thể loại nhạc không được để trống");
            }
        }

        System.out.println("nhap the loai");
        while (true){
            this.genre= scanner.nextLine();
            if (genre.length()>0){
                break;
            }else {
                System.out.println("Thể loại nhạc không được để trống");
            }
        }

    }
    public void DisplayData(){

        System.out.println("mã ca sĩ " + singerId);
        System.out.println("tên ca sĩ  " + singerName);
        System.out.println("tuổi " + age);
        System.out.println("quốc tịch " + nationality);
        System.out.println("giới tính " + (gender?"nam":"nu"));
        System.out.println("thể loại " + genre);
    }
}
