package Exam_Advance;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;

public class Song {
    private static int nextSongId = 1;
    private String songId;
    private String songName;
    private String descriptions;
    private String singer;
    private String songWriter;
    private Date createdDate = new Date();
    private boolean songStatus;

    public Song() {
        this.songId = "S" + String.format("%03d", nextSongId++);
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Singer[]singers,int singerIndex){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập tên bài hát: ");
        this.songName=scanner.nextLine();
        while (true){
            if (songName.length()>0) {
                break;
            } else {
                System.out.println("Ca sĩ không được để trống.");
            }
        }

        System.out.print("Nhập mô tả bài hát: ");
        setDescriptions(scanner.nextLine());

        System.out.print("Nhập người sáng tác: ");
//        setSongWriter(scanner.nextLine());
        this.songWriter=scanner.nextLine();
        while (true){
            if (songWriter.length()>0) {
                break;
            } else {
                System.out.println("Người sáng tác không được để trống.");
            }

        }

        System.out.println("Danh sách ca sĩ có sẵn:");
        for (int i = 0; i <singerIndex ; i++) {
            singers[i].DisplayData();
        }
        System.out.print("Nhập ID ca sĩ cho bài hát: ");
        int singerId = Integer.parseInt(scanner.nextLine());
        Singer selectedSinger = null;
        for (Singer s : singers) {
            if (s.getSingerId() == singerId) {
                selectedSinger = s;
                break;
            }
        }
        if (selectedSinger != null) {
            setSinger(String.valueOf(selectedSinger));
        } else {
            System.out.println("Không tìm thấy ca sĩ với ID đã nhập.");
        }
    }

    public void displayData(){
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả: " + descriptions);
        System.out.println("Ca sĩ: " + singer);
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Trạng thái: " + (songStatus ? "Hoạt động" : "Không hoạt động"));
    }


}
